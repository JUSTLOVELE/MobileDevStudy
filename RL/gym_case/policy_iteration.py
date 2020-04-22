import math
import gym
from gym import spaces
from gym.utils import seeding
import numpy as np

env = gym.make("Pong-v0")
env.reset()

for _ in range(2000):
    env.render()
    env.step(env.action_space.sample())
env.close()