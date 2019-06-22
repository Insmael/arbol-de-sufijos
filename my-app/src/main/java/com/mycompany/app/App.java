package com.mycompany.app;

import com.mycompany.util.*;
import com.mycompany.datastructures.STrie;
import java.util.List;
import java.util.Arrays;
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
    String[] datasets = {"eng","dna"};
    STrie st= null;
    Entry entry = null;
    long start, stop, time;
    int runs = 20;
    List<Entry> entries;
    for (int t_num=10;t_num<=23;t_num++)
    {
      if (t_num==20) runs = 1;
      for (String dataset : datasets)
      {
        entries = new ArrayList<Entry>();
        //cargar los datos
        System.out.println("Cargando los datos de "+dataset+" "+t_num);
        System.out.println("el arbol de sufijos se armará a partir de los datos anteriores");
        String text = IO.loadData(dataset,t_num);


        //construir el índice
        entry = new Entry();
        entry.setDataset(dataset);
        entry.setPower(t_num);
        System.out.println("Construyendo el arbol de sufijos.");
        start = System.nanoTime();

        for (int vuelta = 0; vuelta < runs; vuelta++)
        {
        st = new STrie(text+"$");
        }

        stop = System.nanoTime();
        time = (stop-start)/runs;
        entry.setTime(time);
        System.out.println("Construcción terminada.");
        System.out.println("tiempo requerido: "+(stop-start));
        entry.setConsult("build");
        entry.setTime(time);
        entry.setWordlength(0);
        entry.setK(0);
        entries.add(entry);

        //CONSULTAS
        System.out.println("Comenzando las consultas");
        //elegir las palabras aleatorias
        List<String> words = null;
        List<String> misswords = null;
        if (dataset.equals("eng"))
        {
          words = PatronBuilder.buildEng(text);
          misswords = PatronBuilder.buildMissMatchEng();
        }
        else // dataset.equals("dna")
        {
          words = PatronBuilder.buildDna(text);
          misswords = PatronBuilder.buildMissMatchDna();
        }

        //consulta count
        //hacer las consultas

        System.out.println("Consultas Count.");
        for (String word : words)
        {
          entry = new Entry();
          entry.setDataset(dataset);
          entry.setPower(t_num);
          entry.setWordlength(word.length());
          entry.setConsult("count");
          entry.setK(0);
          start = System.nanoTime();

          for (int vuelta = 0; vuelta < runs; vuelta++)
          {
            st.count(word);
          }

          stop = System.nanoTime();
          time = (stop-start)/runs;
          entry.setTime(time);
          entries.add(entry);
        }

        for(String word : misswords)
        {
          entry = new Entry();
          entry.setDataset(dataset);
          entry.setPower(t_num);
          entry.setWordlength(word.length());
          entry.setConsult("count");
          entry.setK(-1);
          start = System.nanoTime();

          for (int vuelta = 0; vuelta < runs; vuelta++)
          {
            st.count(word);
          }

          stop = System.nanoTime();
          time = (stop-start)/runs;
          entry.setTime(time);
          entries.add(entry);
        }
        System.out.println("Consultas Count terminadas.");



        System.out.println("Consultas Locate.");
        for (String word : words)
        {
          entry = new Entry();
          entry.setDataset(dataset);
          entry.setPower(t_num);
          entry.setWordlength(word.length());
          entry.setConsult("locate");
          entry.setK(0);
          start = System.nanoTime();

          for (int vuelta = 0; vuelta < runs; vuelta++)
          {
            st.locate(word);
          }

          stop = System.nanoTime();
          time = (stop-start)/runs;
          entry.setTime(time);
          entries.add(entry);
        }
        for(String word : misswords)
        {
          entry = new Entry();
          entry.setDataset(dataset);
          entry.setPower(t_num);
          entry.setWordlength(word.length());
          entry.setConsult("locate");
          entry.setK(-1);
          start = System.nanoTime();

          for (int vuelta = 0; vuelta < runs; vuelta++)
          {
            st.locate(word);
          }

          stop = System.nanoTime();
          time = (stop-start)/runs;
          entry.setTime(time);
          entries.add(entry);
        }
        System.out.println("Consultas Locate terminadas.");

        //consultas top;
        int[] ks  = {3,5,10};
        int[] qs ;
        int[] eng_qs = {4, 5, 6, 7};
        int[] dna_qs = {4, 8, 16, 32};
        if (dataset.equals("eng"))
        {
          qs = eng_qs;
        }
        else // dataset.equals("dna")
        {
          qs = dna_qs;
        }

        System.out.println("Consultas Top.");
        for(int k : ks)
        {
          for (int q : qs)
          {
            entry = new Entry();
            entry.setDataset(dataset);
            entry.setPower(t_num);
            entry.setWordlength(q);
            entry.setConsult("top");
            entry.setK(k);
            start = System.nanoTime();

            for (int vuelta = 0; vuelta < runs; vuelta++)
            {
              st.top(k,q);
            }

            stop = System.nanoTime();
            time = (stop-start)/runs;
            entry.setTime(time);
            entries.add(entry);
          }
        }
        System.out.println("Consultas Top terminadas.");
        System.out.println("Todas las consultas han terminado.");


        System.out.println("Guardando resultados.");
        IO.saveEntries(dataset,t_num,entries);
        System.out.println("Resultados guardados.\n");
      }
    }
  }
}
