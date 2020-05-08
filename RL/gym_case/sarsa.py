import numpy as np
import gym
from gym import wrappers

n_states = 40
iter_max = 5000

initial_lr = 1.0 #初始学习速率
min_lr = 0.003 #
gamma = 1.0
t_max = 10000
eps = 0.1

def run_episode(env, policy=None, render=False):
    obs = env.reset()
    total_reward = 0
    step_idx = 0
    for _ in range(t_max):
        if True:
            env.render()
        if policy is None:
            action = env.action_space.sample()
        else:
            a,b = obs_to_state(env, obs)
            action = policy[a][b]
        obs, reward, done, _ = env.step(action)
        total_reward += gamma ** step_idx * reward
        step_idx += 1
        if done:
            break
    return total_reward

def obs_to_state(env, obs):
    """Maps an observation to state"""
    #将连续的状态空间化为离散的
    env_low = env.observation_space.low
    env_high = env.observation_space.high
    env_dx = (env_high - env_low)/n_states
    a = int((obs[0] - env_low[0])/env_dx[0])
    b = int((obs[1] - env_low[1])/env_dx[1])
    return a,b

env = gym.make('MountainCar-v0')
env.seed(0)
np.random.seed(0)
q_table = np.zeros((n_states, n_states, 3))

for i in range(iter_max):
    obs = env.reset()
    total_reward = 0
    #学习速率是衰减的
    eta = max(min_lr, initial_lr * (0.85 ** (i//100)))

    for j in range(t_max):

        a,b = obs_to_state(env, obs)

        if np.random.uniform(0, 1) < eps:
            action = np.random.choice(env.action_space.n)
        else:
            action = np.argmax(q_table[a][b])
        
        obs, reward, done, _ = env.step(action)
        total_reward += reward
        #update q table
        a_, b_ = obs_to_state(env, obs)

        if np.random.uniform(0, 1) < eps:
            action_ = np.random.choice(env.action_space.n)
        else:
            action_ = np.argmax(q_table[a_][b_])
        q_table[a][b][action] = q_table[a][b][action] + eta * (reward + gamma *  q_table[a_][b_][action_] - q_table[a][b][action]) 
        
        if done:
            break
    
    if i%200 == 0:
         print('Iteration #%d -- Total reward = %d.' %(i+1, total_reward))

solution_policy = np.argmax(q_table, axis=2)
solution_policy_scores = [run_episode(env, solution_policy, False) for _ in range(100)]
print("Average score of solution = ", np.mean(solution_policy_scores))