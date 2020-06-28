import random
import gym
import numpy as np
from tensorflow.keras import models, layers, optimizers
import tensorflow as tf


env = gym.make('CartPole-v1')
env.seed(543)


