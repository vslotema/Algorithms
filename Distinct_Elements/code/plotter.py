import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

def plot_ex_2() :
    df = pd.read_csv('data\\ex_2_hash_dist.txt', sep = ",")
    print(df)

    plt.bar(df['leadingZeroes'],df['distribution'])

    plt.xlabel("Hash")
    plt.ylabel("Elements")

    plt.show()

def plot_ex_4_bar() :
    df = pd.read_csv('data\\ex_4_rand_input.txt', sep = ";")
    actual = 1_000_000

    plt.title("m/estimate")
    y_pos = np.arange(len(df['m']))

    plt.bar(y_pos, df['estimate'])

    plt.xticks(y_pos, df['m'])

    plt.xlabel("m")
    plt.ylabel("Estimate")

    plt.show()


def plot_ex_4_error_plot() :
    df = pd.read_csv('data\\ex_4_rand_input.txt', sep = ";")
    actual = 1_000_000

    df['error'] = pd.Series((((df['estimate'])-actual)/actual*100), index=df.index)
    plt.title("Error")
    y_pos = np.arange(len(df['m']))

    plt.plot(y_pos, abs(df['error']))

    plt.xticks(y_pos, df['m'])

    plt.xlabel("m")
    plt.ylabel("Error %")

    plt.show()

def check_stdev() :
    actual = 1_000_000

    df = pd.read_csv('data\\ex_4_rand_input.txt', sep = ";")
    df['stdev'] = pd.Series((1.04/np.sqrt(df['m'])), index=df.index)
    df['satisfies_1dev_margin'] = pd.Series(abs(df['estimate']-actual) < actual*df['stdev'])
    df['satisfies_2dev_margin'] = pd.Series(abs(df['estimate']-actual) < actual*df['stdev']*2)
    print(df)
    '''
    fig, ax = plt.subplots()

    fig.patch.set_visible(False)
    ax.axis('off')
    ax.axis('tight')


    table = ax.table(cellText=df.values, colLabels=df.columns, loc = 'center')
    table.set_fontsize(100)
    plt.show()
    '''
check_stdev()

#plot_ex_2()
#plot_ex_4_bar()
#plot_ex_4_error_plot()
