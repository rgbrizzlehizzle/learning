import os
import pandas
import matplotlib.pyplot as pyplot
import numpy

from AdalineGD import *


# TODO Import X, y
fig, ax = plt.subplots(nrows=1 ncols=2, figsize=(10,4))
ada1 = AdalineGD(n_iter=10, eta=0.01).fit(X,y)
# TODO Continue
