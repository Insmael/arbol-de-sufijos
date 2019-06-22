from matplotlib.pyplot import figure
import matplotlib.ticker as ticker
import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd
import numpy as np

figure(num=None, figsize=(8, 6), dpi=80, facecolor='w', edgecolor='k')

dir = "../results/"
col_names = ['dataset', 'largo texto', 'consulta','largo palabra','k','tiempo [$s^{-9}$]']

#el último texto procesado, el número relfeja la potencia de do asociada al largo del texto
last_proceced = 22
#el y es el tiempo [$s^-9$], un grafico por consulta
#el x es len palabra
#una linea es largo texto
#los missmatch son su propia linea
#un plot es un data set

#cada k en top tiene su grafico

def plot_and_save(plotname, data_set, df):
    fig, ax = plt.subplots(figsize=(8, 4), constrained_layout=True)
    ax = sns.lineplot(x="largo palabra", y="tiempo [$s^{-9}$]", hue="largo texto",  data=df)
    L=plt.legend()
    for i in range(1,len(L.get_texts())):
        text=L.get_texts()[i]
        text.set_text('$s^{{{}}}$'.format(text.get_text()))
    ax.set_yscale('log')
    plt.savefig('plots/{}_{}.png'.format(plotname,data_set))
    plt.close(fig)

for dset in ['eng','dna']:
    count_lines = []
    miss_count_lines = []
    locate_lines = []
    miss_locate_lines = []
    build_lines = []
    k3 = []
    k5 = []
    k10 = []
    for num in range(10,last_proceced+1):
        filename = '{}{}_{}.csv'.format(dir,dset,num)
        df = pd.read_csv(filename, names = col_names)
        df = df.drop(['dataset'],axis=1)

        #caso build
        df_consult = df.query('consulta=="build"')
        #es solo una build por archivo
        build_lines.append(df_consult)

        #caso count
        df_consult = df.query('consulta=="count"')
        df_miss = df_consult.query('k==-1')
        df_ok = df_consult.query('k==0')
        #promediar por largo palabra
        #df_miss_line = df_miss.groupby('largo palabra')
        #df_ok_line = df_ok.groupby('largo palabra')
        #guardar las lineas en el string
        miss_count_lines.append(df_miss)
        count_lines.append(df_ok)

        #caso locate
        df_consult = df.query('consulta=="locate"')
        df_miss = df_consult.query('k==-1')
        df_ok = df_consult.query('k==0')
        #df_miss_line = df_miss.groupby('largo palabra')
        #df_ok_line = df_ok.groupby('largo palabra')
        #promediar por largo palabra
        miss_locate_lines.append(df_miss)
        locate_lines.append(df_ok)

        #caso top
        df_consult = df.query('consulta=="top" & k==3')
        #df_k = df.groupby('largo palabra')
        k3.append(df_consult)

        df_consult = df.query('consulta=="top" & k==5')
        #df_k = df.groupby('largo palabra')
        k5.append(df_consult)

        df_consult = df.query('consulta=="top" & k==10')
        #df_k = df.groupby('largo palabra')
        k10.append(df_consult)

    #ahora que tenemos las listas de lineas por el largo de texto
    #con x el largo de la palabra e y el tiempo [$s^-9$], graficar
    #para esto concatenamos los dataframes separados en listas
    df_count = pd.concat(count_lines)
    df_miss_count = pd.concat(miss_count_lines)
    df_locate = pd.concat(locate_lines)
    df_miss_locate = pd.concat(miss_locate_lines)
    df_build = pd.concat(build_lines)
    df_topk3 = pd.concat(k3)
    df_topk5 = pd.concat(k5)
    df_topk10 = pd.concat(k10)

    fig, ax = plt.subplots(figsize=(8, 4), constrained_layout=True)
    ax = sns.lineplot(x="largo texto", y="tiempo [$s^{-9}$]", data=df_build)
    ax.set_yscale('log')
    ax.xaxis.set_major_formatter(ticker.FormatStrFormatter('$2^{%d}$'))
    plt.savefig('plots/build_{}.png'.format(dset))
    plt.close()

    plot_and_save("count", dset, df_count)
    plot_and_save("miss_count", dset, df_miss_count)
    plot_and_save("locate", dset, df_locate)
    plot_and_save("miss_locate", dset, df_miss_locate)
    plot_and_save("top_3", dset, df_topk3)
    plot_and_save("top_5", dset, df_topk5)
    plot_and_save("top_10", dset, df_topk10)
