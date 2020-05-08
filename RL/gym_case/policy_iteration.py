import math
import gym
from gym import spaces
from gym.utils import seeding
import numpy as np


def run_episode(env, policy, gamma = 1.0, render = False):

    obs = env.reset()
    total_reward = 0
    step_idx = 0
    while True:
        if render:
            env.render()
        obs, reward, done , _ = env.step(int(policy[obs]))
        total_reward += (gamma ** step_idx * reward)
        step_idx += 1
        if done:
            break
    return total_reward


def evaluate_policy(env, policy, gamma = 1.0, n = 100):
    scores = [run_episode(env, policy, gamma, False) for _ in range(n)]
    return np.mean(scores)


def policy_evaluation(env, gamma, theta, V, policy, index):
    # 2.策略估计
    while True:
        delta = 0
        index += 1
        prev_v = np.copy(V)
        for s in range(env.observation_space.n):
            action = policy[s]
            v = 0
            for p, s_next, r, _ in env.env.P[s][action]:
                v = v + p * (r + gamma * prev_v[s_next])
            V[s] = v


            if delta < abs(V[s] - prev_v[s]):
                delta = abs(V[s] - prev_v[s])

        if delta < theta:
            return V, index

def police_improvement(env, gamma, V, old_policy, policy_stable=True):
    # 3.策略改进
    policy = np.zeros(env.observation_space.n)
    for s in range(env.observation_space.n):
        #old_action = policy[s]
        q_value = np.zeros(env.action_space.n)
        for action in range(env.action_space.n):
            for p, s_next, r, _ in env.env.P[s][action]:
                q_value[action] += (p * (r + gamma * V[s_next]))
        policy[s] = np.argmax(q_value)
        if policy[s] != old_policy[s]:
            policy_stable = False

    return policy, policy_stable


def policy_Iteration(env, gamma):

    theta = 1e-10
    # 1.初始化
    policy = np.random.choice(env.action_space.n, size=(env.observation_space.n))
    V = np.zeros(env.observation_space.n)
    index = 0
    while True:
        index += 1
        # 2.策略估计
        V, index = policy_evaluation(env=env, gamma=gamma, theta=theta, V=V, policy=policy, index=index)
        # 3.策略改进
        new_policy, policy_stable = police_improvement(env=env, gamma=gamma, V=V, old_policy=policy)

        if policy_stable:
            print(index)
            return new_policy
        else:
            policy = new_policy
        #np.all(policy = new_policy)



env = gym.make("FrozenLake-v0")
env.reset()
gamma = 1.0
new_policy = policy_Iteration(env, gamma)
scores = evaluate_policy(env, new_policy, gamma=1.0)
print(new_policy)
print('Average scores = ', np.mean(scores))










