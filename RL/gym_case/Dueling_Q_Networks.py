import torch
from torch import nn
import numpy as np
import pandas as pd
import gym
import collections
#使用cuda加速训练
device = 'cuda' if torch.cuda.is_available() else 'cpu'

class DQNReplayer:

    def __init__(self, capacity):
        self.memory = pd.DataFrame(index=range(capacity),
                                   columns=['observation', 'action', 'reward',
                                            'next_observation', 'done'])
        self.i = 0
        self.count = 0
        self.capacity = capacity

    def store(self, *args):
        self.memory.loc[self.i] = args
        self.i = (self.i + 1) % self.capacity
        self.count = min(self.count + 1, self.capacity)

    def sample(self, size):
        indices = np.random.choice(self.count, size=size)
        return (np.stack(self.memory.loc[indices, field]) for field in
                self.memory.columns)

class DuelingNet(nn.Module):

    def __init__(self, layers, num_actions):

        super(DuelingNet, self).__init__()
        self.layers = layers
        self.num_actions=num_actions
        self.features = nn.Sequential(
            nn.Linear(self.layers, 64, bias=True),
            nn.ReLU(),
        )
        self.adv = nn.Linear(64, self.num_actions, bias=True)
        self.val = nn.Linear(64, 1, bias=True)

    def forward(self, x):
        x = self.features(x)
        adv = self.adv(x)
        val = self.val(x).expand(adv.size()) #扩展某个size为1的维度，值一样  （1，6）
        x = val + adv -adv.mean().expand(adv.size())
        return x


class agent():
    # 设置超参数
    def __init__(self, env=gym.make('MountainCar-v0'), layers=2, capacity=500, LR=0.001, gamma=0.9, epsilon=0.05):
        self.env = env
        self.layers = layers
        self.min = env.unwrapped.min_position
        self.max = env.unwrapped.max_position
        self.action_num = env.action_space.n
        self.net1 = DuelingNet(self.layers, self.action_num).to(device)
        self.net2 = DuelingNet(self.layers, self.action_num).to(device)
        self.optimizer1 = torch.optim.Adam(self.net1.parameters(), lr=LR)
        self.loss_func = nn.MSELoss()
        self.replayer = DQNReplayer(capacity)
        self.lr = LR
        self.gamma = gamma
        self.epsilon = epsilon

    # 选择动作
    def action(self, state, israndom):
        state_ = torch.Tensor(state).to(device)
        if israndom and np.random.random() < self.epsilon:
            return np.random.randint(0, self.action_num)
        return torch.max(torch.from_numpy(self.net1.forward(state_).cpu().detach().numpy()).to(device), 0)[1].item()

    # 训练网络
    def learn(self, state, action, reward, next_state, done):
        if done:
            self.replayer.store(state, action, reward, next_state, 0)
        else:
            self.replayer.store(state, action, reward, next_state, 1)
        if self.replayer.count < self.replayer.capacity:
            return None

        batch = list(self.replayer.sample(10))
        state = torch.FloatTensor(batch[0]).to(device)
        action = torch.LongTensor(batch[1]).unsqueeze(1).to(device)
        reward = torch.FloatTensor(batch[2]).unsqueeze(1).to(device)
        next_state = torch.FloatTensor(batch[3]).to(device)
        done = torch.FloatTensor(batch[4]).unsqueeze(1).to(device)

        a = self.net1.forward(next_state).max(dim=1)[1].view(-1, 1)
        u = reward + self.gamma * self.net2.forward(next_state).gather(1, a) * done
        loss = self.loss_func(self.net1.forward(state).gather(1, action), u)
        self.optimizer1.zero_grad()
        loss.backward()
        self.optimizer1.step()

    # 储存模型参数
    def save_models(self, episode):
        torch.save(self.net1.state_dict(), './net/double_dqn.pkl')
        torch.save(self.net2.state_dict(), './net/double_dqn_target.pkl')
        print('=====================')
        print('%d episode model has been save...' % (episode))

agent = agent()
best_reward = 0
mean_test = collections.deque(maxlen=10)
for i_episode in range(2000):
    state = agent.env.reset()
    total_reward = 0
    treward = 0
    step_num=0

    #每十个回合统一两个网络的参数
    if i_episode%10==0:
        agent.net2.load_state_dict(agent.net1.state_dict())

    while True:
#        agent.env.render()
        action = agent.action(state, True)
        next_state, reward, done, info = agent.env.step(action)
        reward_real = reward#环境真实奖励

    #奖励函数（非常重要，影响收敛结果和收敛速度）
        if next_state[0]>-0.4 and next_state[0]<0.5:
            reward=10*(next_state[0]+0.4)**3
        elif next_state[0]>=0.5:
            reward=100
        elif next_state[0]<=-0.4:
            reward=-0.1

        treward+=reward#奖励函数奖励
        agent.learn(state, action, reward, next_state, done)
        state=next_state
        total_reward += reward_real
        step_num += 1
        if done or step_num>=200:
            break
    print('episode: {} , total_reward: {} , treward: {}'.format(i_episode, round(total_reward, 3), round(treward, 3)))

    # TEST
    if i_episode % 10 == 0:
        state = agent.env.reset()
        test_reward = 0
        while True:
#            agent.env.render()
            action = agent.action(state, israndom=False)
            next_state, reward, done, info = agent.env.step(action)
            test_reward += reward
            state = next_state
            if done:
                agent.env.close()
                break
        print('episode: {} , test_reward: {}'.format(i_episode, round(test_reward, 3)))
        mean_test.append(test_reward)
        if np.mean(mean_test)>best_reward:
            best_reward = np.mean(mean_test)
            agent.save_models(i_episode)