import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns


dir = "../results/"
col_names = ['dataset', 'largo texto', 'consulta','largo palabra','k','tiempo']


#el y es el tiempo, un grafico por consulta
#el x es len palabra
#una linea es largo texto
#los missmatch son su propia linea
#un plot es un data set

#cada k en top tiene su grafico
for dset in ['eng','dna']:
    count_lines = []
    miss_count_lines = []
    locate_lines = []
    miss_locate_lines = []
    build_lines = []
    k3 = []
    k5 = []
    k10 = []
    for num in range(10,24):
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
    #con x el largo de la palabra e y el tiempo, graficar
    #para esto concatenamos los dataframes separados en listas
    df_count = pd.concat(count_lines)
    df_miss_count = pd.concat(miss_count_lines)
    df_locate = pd.concat(locate_lines)
    df_miss_locate = pd.concat(miss_locate_lines)
    df_build = pd.concat(build_lines)
    df_topk3 = pd.concat(k3)
    df_topk5 = pd.concat(k5)
    df_topk10 = pd.concat(k10)
    lp = [10,11,12,13,14,15,16,17,18,19,20,21,22,23]
    ax = sns.lineplot(x="largo texto", y="tiempo", data=df_build)
    ax.set(yscale="log")
    plt.show()
    ax = sns.lineplot(x="largo palabra", y="tiempo", hue="largo texto",  data=df_count)
    ax.set(yscale="log")
    plt.show()
    ax = sns.lineplot(x="largo palabra", y="tiempo", hue="largo texto",  data=df_miss_count)
    ax.set(yscale="log")
    plt.show()
    ax = sns.lineplot(x="largo palabra", y="tiempo", hue="largo texto",  data=df_locate)
    ax.set(yscale="log")
    plt.show()
    ax = sns.lineplot(x="largo palabra", y="tiempo", hue="largo texto",  data=df_miss_locate)
    ax.set(yscale="log")
    plt.show()
    ax = sns.lineplot(x="largo palabra", y="tiempo", hue="largo texto",  data=df_topk3)
    ax.set(yscale="log")
    plt.show()
    ax = sns.lineplot(x="largo palabra", y="tiempo", hue="largo texto",  data=df_topk5)
    ax.set(yscale="log")
    plt.show()
    ax = sns.lineplot(x="largo palabra", y="tiempo", hue="largo texto",  data=df_topk10)
    ax.set(yscale="log")
    plt.show()
