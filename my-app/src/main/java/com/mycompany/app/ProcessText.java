package com.mycompany.app;

import com.mycompany.util.*;
/**
 * Hello world!
 *
 */
public class ProcessText
{
    public static void main( String[] args )
    {
      System.out.println("Experimentación: Árbol de sufijos.");
      System.out.println("Preprocesado de los textos.");
      Preprocesor pp = new Preprocesor();

      System.out.println("PREPROCESANDO DNA.");
      String text = IO.loadDNA();

      pp.addStrToRemove("\n");
      text = pp.removeRegex(text);
      String toStore="";
      for(int i =10;i<=23;i++){
        toStore = pp.toPowerOfTwoLength(text,i);
        IO.saveProcessedDNA(text,i);
      }

      System.out.println("PREPROCESANDO ENGLISH.");
      text = IO.loadEnglish();
      //preprocesar el texto
      pp.defaultTextSet();
      text = pp.removeRegex(text);
      text = pp.compressSpaces(text);
      for(int i =10;i<=23;i++){
        toStore = pp.toPowerOfTwoLength(text,i);
        IO.saveProcessedEnglish(text,i);
      }
      System.out.println("Preprocesado de los textos terminado exitosamente.");



    }
}
