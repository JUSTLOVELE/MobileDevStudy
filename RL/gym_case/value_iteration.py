import gym
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


env = gym.make("FrozenLake-v0")
env.reset()
gamma = 1.0
theta = 1e-20
V = np.zeros(env.observation_space.n)

while True:
    delta = 0
    #pre_V = np.copy(V)
    for s in range(env.observation_space.n):
        v = V[s]
        q_value = np.zeros(env.action_space.n)
        for a in range(env.action_space.n):
            for p, s_next, r, _  in env.P[s][a]:
                q_value[a] += (p * (r + gamma * V[s_next]))
        V[s] = np.max(q_value)
        if delta < abs(v - V[s]):
            delta = abs(v - V[s])

    if delta < theta:
        break

optimal_policy = np.zeros(env.observation_space.n)

for s in range(env.observation_space.n):
    q_value = np.zeros(env.action_space.n)
    for a in range(env.action_space.n):
        for p, s_next, r, _ in env.P[s][a]:
            q_value[a] += (p * (r + gamma * V[s_next]))
    optimal_policy[s] = np.argmax(q_value)

print(optimal_policy)
scores = evaluate_policy(env, optimal_policy, gamma=1.0)
print('Average scores = ', np.mean(scores))



