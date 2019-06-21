package com.mycompany.app;

import com.mycompany.util.*;
import com.mycompany.datastructures.STrie;
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
      //construir el índice
      Cronometer crn = new Cronometer();
      System.out.println("Construyendo el arbol de sufijos.");
      crn.tic();
      //STrie st = new STrie(text+"$");
      crn.tac("Suffix trie build");
      System.out.println("construcción terminada.");
      //hacer las consultas
      //mostrar los resultados
      //graficar los resultados
    }
}
