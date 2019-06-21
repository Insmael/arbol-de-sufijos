package com.mycompany.util;

import java.nio.file.*;
import java.io.FileWriter;

public class IO {
  static String DIR = "/media/ismael/Deep Sea/Universidad/diseño y analisis de algoritmos/tarea 2/";


  public static String loadDNA(){
    System.out.print("Cargando el texto DNA:");
    return readFileAsString(DIR+"dna.50MB");
  }

  public static void saveProcessedDNA(String text, int n){
    System.out.println("Guardando el texto procesado de DNA.");
    try{
     FileWriter fw=new FileWriter(DIR+"dna_"+n+".txt");
     fw.write(text);
     fw.close();
    }catch(Exception e){System.out.println(e);}
    System.out.println("Guardado exitoso");
    System.out.println("nuevo archivo en:"+"dna_"+n+".txt");
  }

  public static void saveProcessedEnglish(String text, int n){
    System.out.println("Guardando el texto procesado de english.");
    try{
     FileWriter fw=new FileWriter(DIR+"eng_"+n+".txt");
     fw.write(text);
     fw.close();
    }catch(Exception e){System.out.println(e);}
    System.out.println("Guardado exitoso");
    System.out.println("nuevo archivo en:"+"eng_"+n+".txt");
  }

  public static String loadProcessedDNA(int n){
    System.out.print("Cargando el texto procesado DNA:");
    return readFileAsString(DIR+"dna_"+n+".txt");
  }

  public static String loadEnglish(){
    System.out.print("Cargando el texto english:");
    return readFileAsString(DIR+"english.50MB");
  }

  public static String loadProcessedEnglish(int n){
    System.out.print("Cargando el texto procesado english:");
    return readFileAsString(DIR+"eng_"+n+".txt");
  }

  public static String readFileAsString(String fileName) {
    String data = "";
    try{
      data = new String(Files.readAllBytes(Paths.get(fileName)));
    }
    catch(Exception e){
      System.out.println("unable to load file at"+fileName);
    }
    System.out.println("Éxito al cargar.");
    return data;
  }

}
