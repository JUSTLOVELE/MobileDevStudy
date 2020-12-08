a = [4,5,3,2]
b = lambda obs: a[obs]
print(b(0))

old_policy_result = {
    obs: -1 for obs in range(64)
}

print(old_policy_result)
print(old_policy_result[2])

import gym
import numpy as np
env = gym.make("FrozenLake8x8-v0")
policy = lambda dim : np.random.choice(4)
print(policy(10))

new_policy = {}
new_policy[0] = 1
new_policy[2] = 3
print(new_policy)