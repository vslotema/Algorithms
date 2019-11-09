import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

def plot_ex_2() :
    df = pd.read_csv('data\\ex_2_hash_dist.txt', sep = ",")

    plt.bar(df['leadingZeroes'],df['distribution'])

    plt.show()

def plot_ex_4_bar() :
    df = pd.read_csv('data\\ex_4_m_estimate.txt', sep = ";")
    actual = 1_000_000

    df['error'] = pd.Series((((df['estimate'])-actual)/actual*100), index=df.index)
    plt.title("m/estimate")
    y_pos = np.arange(len(df['m']))

    plt.bar(y_pos, df['estimate'])

    plt.xticks(y_pos, df['m'])

    plt.show()


def plot_ex_4_error_plot() :
    df = pd.read_csv('data\\ex_4_m_estimate.txt', sep = ";")
    actual = 1_000_000

    df['error'] = pd.Series((((df['estimate'])-actual)/actual*100), index=df.index)
    plt.title("Error")
    y_pos = np.arange(len(df['m']))

    plt.plot(y_pos, abs(df['error']))

    plt.xticks(y_pos, df['m'])

    plt.show()

plot_ex_2()
plot_ex_4_bar()
plot_ex_4_error_plot()
