from collections import deque
import random
import gym
import numpy as np
#from tensorflow.keras import models, layers, optimizers
import tensorflow as tf
import matplotlib.pyplot as plt

class DQN(object):
    def __init__(self):
        self.step = 0
        self.update_freq = 200  # 模型更新频率
        self.replay_size = 2000  # 训练集大小
        self.replay_queue = deque(maxlen=self.replay_size)
        self.gamma = 0.9
        self.model = self.create_model()
        # self.target_model = self.create_model()

    def create_model(self):
        """创建一个隐藏层为100的神经网络"""
        STATE_DIM, ACTION_DIM = 2, 3
        # model = models.Sequential([
        #     layers.Dense(100, input_dim=STATE_DIM, activation='relu'),
        #     layers.Dense(ACTION_DIM, activation="linear")
        # ])

        # inputs = tf.keras.Input(shape=(state_size,))
        # fc1 = tf.keras.layers.Dense(128, activation='relu')(inputs)
        # fc2 = tf.keras.layers.Dense(128, activation='relu')(fc1)
        # advantage_output = tf.keras.layers.Dense(action_size, activation='linear')(fc2)
        # if self.dueling:
        #     value_out = tf.keras.layers.Dense(1, activation='linear')(fc2)
        #     norm_advantage_output = keras.layers.Lambda(lambda x: x - tf.reduce_mean(x))(advantage_output)
        #     # outputs = tf.keras.layers.Add()([value_out,advantage_output-tf.reduce_mean(advantage_output,axis=1,keepdims=True)])
        #     outputs = tf.keras.layers.Add()([value_out, norm_advantage_output])
        #     model = tf.keras.Model(inputs, outputs)

        inputs = tf.keras.Input(shape=STATE_DIM)
        layer1 = tf.keras.layers.Dense(units=100, activation='relu')(inputs)
        advantage_output =  tf.keras.layers.Dense(ACTION_DIM, activation="linear")(layer1)
        value_out = tf.keras.layers.Dense(1, activation='linear')(layer1)
        norm_advantage_output = tf.keras.layers.Lambda(lambda x: x - tf.reduce_mean(x))(advantage_output)
        outputs = tf.keras.layers.Add()([value_out, norm_advantage_output])
        model = tf.keras.Model(inputs, outputs)
        model.compile(loss='mean_squared_error', optimizer=tf.keras.optimizers.Adam(0.001))
        return model

    def act(self, s, epsilon=0.1):
        """预测动作"""
        # 刚开始时，加一点随机成分，产生更多的状态
        if np.random.uniform() < epsilon - self.step * 0.0002:
            return np.random.choice([0, 1, 2])
        return np.argmax(self.model.predict(np.array([s]))[0])

    def save_model(self, file_path='MountainCar-v0-dueling-dqn.h5'):
        print('model saved')
        self.model.save(file_path)

    def remember(self, s, a, next_s, reward, done):
        """历史记录，position >= 0.4时给额外的reward，快速收敛"""
        if next_s[0] >= 0.4:
            reward += 1
        self.replay_queue.append((s, a, next_s, reward, done))

    def train(self, batch_size=64, lr=1, factor=0.95):
        if len(self.replay_queue) < self.replay_size:
            return
        self.step += 1
        # 每 update_freq 步，将 model 的权重赋值给 target_model
        # if self.step % self.update_freq == 0:
        #     self.target_model.set_weights(self.model.get_weights())
        replay_batch = random.sample(self.replay_queue, batch_size)
        #状态值集合,第一个元素为状态
        s_batch = np.array([replay[0] for replay in replay_batch])
        # 状态值集合,第三个元素为下一状态
        next_s_batch = np.array([replay[2] for replay in replay_batch])
        Q = self.model.predict(s_batch)
        #Q_next = self.target_model.predict(next_s_batch)
        Q_next = self.model.predict(next_s_batch)
        # 使用公式更新训练集中的Q值
        for i, replay in enumerate(replay_batch):
            # _target = 经验池.奖励 + gamma衰退值 * (model根据_next_state预测的结果)[0]中最大（对比所有操作中，最大值）
            # 根据_next_state  预测取得  当前的回报 + 未来的回报 * 折扣因子（gama）
            s, a, next_s, reward, done = replay

            if done:
                Q[i][a] = reward
            else:
                Q[i][a] = reward + np.amax(Q_next[i]) * self.gamma
            #Q[i][a] = (1 - lr) * Q[i][a] + lr * (reward + factor * np.amax(Q_next[i]))
        # 传入网络进行训练
        self.model.fit(s_batch, Q, verbose=0)


env = gym.make('MountainCar-v0')
episodes = 1000  # 训练1000次
score_list = []  # 记录所有分数
agent = DQN()
for i in range(episodes):
    s = env.reset()
    score = 0
    while True:
        a = agent.act(s)
        next_s, reward, done, _ = env.step(a)
        agent.remember(s, a, next_s, reward, done)
        agent.train()
        score += reward
        s = next_s
        if done:
            score_list.append(score)
            print('episode:', i, 'score:', score, 'max:', max(score_list), agent.step)
            break
    # 最后10次的平均分大于 -160 时，停止并保存模型
    if np.mean(score_list[-10:]) > -160:
        agent.save_model()
        break
env.close()

plt.plot(score_list, color='green')
plt.show()