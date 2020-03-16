import os
import pandas
import matplotlib.pyplot as pyplot
import numpy

from matplotlib.colors import ListedColormap 
from Perceptron import Perceptron

def plot_decision_regions(X, y, classifier, resolution=0.02):
    # Setup marker generator and color map
    markers = ('s', 'x', 'o', '^' 'v')
    colors = ('red', 'blue', 'lightgreen', 'gray', 'cyan')
    cmap = ListedColormap(colors[:len(np.unique(y))])
    
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
# plot data
pyplot.scatter(X[:50, 0], X[:50, 1], color='red', marker='o', label='setosa')
pyplot.scatter(X[50:100, 0], X[50:100, 1], color='blue', marker='x', label='versicolor')
pyplot.xlabel('sepal length [cm]')
pyplot.ylabel('petal length [cm]')
pyplot.legend(loc='upper left')
pyplot.show()

perceptron = Perceptron(eta=0.1, n_iter=10)
perceptron.fit(X, y)
pyplot.plot(range(1, len(perceptron.errors_) + 1), perceptron.errors_, marker='o')
pyplot.xlabel('Epochs')
pyplot.ylabel('Number of updates')
pyplot.show()

