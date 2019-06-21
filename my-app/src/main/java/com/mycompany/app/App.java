package com.mycompany.app;

import com.mycompany.util.*;
import com.mycompany.datastructures.STrie;
import java.util.List;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
      System.out.println("Experimentación: Árbol de sufijos.");
      System.out.println("Cargando los textos.");

      int img_n = Integer.valueOf(args[0]);
      String text = IO.loadProcessedEnglish(img_n);
      //construir el índice
      Cronometer crn = new Cronometer();
      System.out.println("Construyendo el arbol de sufijos.");
      crn.tic();
      STrie st = new STrie(text+"$");
      crn.tac("Suffix trie build");
      System.out.println("construcción terminada.");
      System.out.println("tiempo requerido: "+crn.getLastTime());
      //hacer las consultas
      System.out.println("Consultas count");
      List<String> words = PatronBuilder.build(text);
      crn.tic();
      int nconsultas=0;
      for(String word :words){
        st.count(word);
        nconsultas++;
      }
      crn.tac("count "+nconsultas+" veces");
      Long res = crn.getLastTime()/nconsultas;
      System.out.println("tiempo requerido: "+crn.getLastTime());
      System.out.println("tiempo requerido por consulta: "+res);
      System.out.println("Consultas Locate");
      nconsultas=0;
      crn.tic();
      for(String word :words)
      {
        st.locate(word);
        nconsultas++;
      }
      crn.tac("locate "+nconsultas+" veces");
      res = crn.getLastTime()/nconsultas;
      System.out.println("tiempo requerido: "+crn.getLastTime());
      System.out.println("tiempo requerido por consulta: "+res);
      int[] ks  = {3,5,10};
      int[] eng_qs = {4,5,6,7};
      System.out.println("Consultas Top");
      for(int k : ks)
      {
        for (int q : eng_qs)
        {
          crn.tic();
          st.top(k,q);
          crn.tac("top-"+k+"-"+q);
          System.out.println("top-"+k+"-"+q);
          System.out.println("tiempo requerido: "+crn.getLastTime());
        }
      }
      //mostrar los resultados
      //graficar los resultados
    }
}
