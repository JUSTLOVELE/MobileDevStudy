import tensorflow as tf
import gym.envs as envs
import gym
import numpy as np
import random
import copy
import os
import tensorflow.keras as keras
from collections import deque
# https://geektutu.com/post/tensorflow2-gym-dqn.html
class DQNAgent(object):

    def __init__(self, env):
        self.env = env
        #经验池
        self.replay_size = 2000
        self.memory = deque(maxlen=self.replay_size)
        self.gamma = 0.95
        self.learning_rate = 0.0001
        self.step = 0
        self.model = self.create_model()
        self.target_model = self.create_model()

    def create_model(self):
        model = tf.keras.Sequential()
        #状态维度为2,动作维度为3,所以输入的维度是2,输出的维度是3
        model.add(tf.keras.layers.Dense(100, input_dim=2, activation='relu'))
        model.add(tf.keras.layers.Dense(100, activation='relu'))
        # model.add(tf.keras.layers.Dense(128, activation='tanh'))
        model.add(tf.keras.layers.Dense(3, activation='linear'))
        model.compile(loss='mse', optimizer=tf.keras.optimizers.Adam(lr=self.learning_rate))
        return model

    def save_replay(self, state, action, reward, next_state, done):
        #位置大于0.4时给出额外的奖励有助于快速收敛
        if next_state[0] >= 0.4:
            reward += 1

        self.memory.append((state, action, reward, next_state, done))

    def train(self, batch_size=64):
        # 确保每批返回的数量不会超出memory实际的存量，防止错误
        if len(self.memory) < 2000:
            return
        self.step += 1

        if self.step % 200 == 0:
            #200步就要更新一次target_model的参数
            self.target_model.set_weights(self.model.get_weights())

        replay_batch = random.sample(self.memory, batch_size)
        s_batch = np.array([replay[0] for replay in replay_batch])
        next_s_batch = np.array([replay[3] for replay in replay_batch])
        Q = self.model.predict(s_batch)
        Q_next = self.target_model.predict(next_s_batch)

        # 使用公式更新训练集中的Q值
        for i, replay in enumerate(replay_batch):
            _, a, reward, _, _ = replay
            Q[i][a] = (1 - self.learning_rate) * Q[i][a] + self.learning_rate * (reward + self.gamma * np.amax(Q_next[i]))

        # 传入网络进行训练
        self.model.fit(s_batch, Q, verbose=0)



        #选择长度为batch_size,随机数为0-len(memory)的一维数组
        # batches = np.random.choice(len(self.memory), size=batch_size)
        # for i in batches:
        #     state, action, reward, next_state, done = self.memory[i]
        #     Q = self.model.predict(state)
        #     Q_next = self.target_model.predict(next_state)
        #     Q[0][action] = (1 - self.learning_rate) * Q[0][action] + self.learning_rate * (
        #                 reward + self.gamma * np.amax(Q_next[0]))
        #     self.model.fit(state, Q, epochs=1, verbose=0)

    def act(self, state, epsilon=0.1):

        if np.random.uniform() < epsilon - self.step * 0.0002:
            return self.env.action_space.sample()
        else:
            act_value = self.model.predict(np.array([state]))
            return np.argmax(act_value[0])

if __name__ == '__main__':
    #状态的维度是2,动作的维度是3
    env = gym.make('MountainCar-v0')
    agent = DQNAgent(env)
    #保存模型到文件所在目录,如果已有模型就加载,继续训练
    folder = os.getcwd()

    if os.path.isfile(os.path.join(folder,"dqn_MountainCar.h5")):
        tf.keras.models.load_model('dqn_MountainCar.h5')

    episodes = 1000
    total_rewards = []
    for e in range(episodes):
        state = env.reset()
        #状态的维度是2
        total_reward = 0
        while True:
            #env.render()
            action = agent.act(state)
            next_state, reward, done, _ = env.step(action)
            agent.save_replay(state, action, reward, next_state, done)
            agent.train()
            total_reward += reward
            state = next_state

            if done:
                total_rewards.append(total_reward)
                print('episode:', e, 'total_reward:', total_reward, 'max:', max(total_rewards), agent.step)
                break
        #从历史中学习

        if np.mean(total_rewards[-10:]) > -160:
            print("saving model")
            agent.model.save('dqn_MountainCar.h5')
            break


