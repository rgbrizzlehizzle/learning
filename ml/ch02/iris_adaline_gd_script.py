import os
import pandas
import matplotlib.pyplot as pyplot
import numpy

from matplotlib.colors import ListedColormap
from AdalineGD import *

def plot_decision_regions(X, y, classifier, resolution=0.02):
    # Setup marker generator and color map
    markers = ('s', 'x', 'o', '^' 'v')
    colors = ('red', 'blue', 'lightgreen', 'gray', 'cyan')
    cmap = ListedColormap(colors[:len(numpy.unique(y))])

    # plot the decision surface

# Load initial dataset
base_iris_url = 'https://archive.ics.uci.edu'
path = os.path.join(base_iris_url, 'ml', 'machine-learning-databases', 'iris', 'iris.data')

df = pandas.read_csv(path, header=None, encoding='utf-8')

# Select Setosa and Versicolor
y = df.iloc[0:100, 4].values
y = numpy.where(y == 'Iris-setosa', -1, 1)

# Extract sepal length and petal length
X = df.iloc[0:100, [0,2]].values

fig, ax = pyplot.subplots(nrows=1, ncols=2, figsize=(10, 4))

# First Learning Rate
ada1 = AdalineGD(n_iter=10, eta=0.01).fit(X,y)
ax[0].plot(range(1, len(ada1.cost_) + 1), numpy.log10(ada1.cost_), marker='o')
ax[0].set_xlabel('Epochs')
ax[0].set_ylabel('log(Sum-squared-error)')
ax[0].set_title('Adaline - Learning rate 0.01')

# Second Learning Rate
ada2 = AdalineGD(n_iter=10, eta=0.0001).fit(X,y)
ax[1].plot(range(1, len(ada2.cost_) + 1), ada2.cost_, marker='o')
ax[1].set_xlabel('Epochs')
ax[1].set_ylabel('Sum-squared-error')
ax[1].set_title('Adaline - Learning rate 0.0001')

# pyplot.show()

X_std = numpy.copy(X)
X_std[:,0] = (X[:,0] - X[:,0].mean()) / X[:,0].std()
X_std[:,1] = (X[:,1] - X[:,1].mean()) / X[:,1].std()

ada_gd = AdalineGD(n_iter=15, eta=0.01)
ada_gd.fit(X_std, y)
plot_decision_regions(X_std, y, classifier=ada_gd)
pyplot.title('Adaline - Gradient Descent')
pyplot.xlabel('sepal length [standardized]')
pyplot.ylabel('petal length [standardized]')
pyplot.legend(loc='upper left')
pyplot.tight_layout()
pyplot.show()
pyplot.plot(range(1, len(ada_gd.cost_) + 1), ada_gd.cost_, marker='o')
pyplot.xlabel('Epochs')
pyplot.ylabel('Sum-squared-error')
pyplot.tight_layout()
pyplot.show()
