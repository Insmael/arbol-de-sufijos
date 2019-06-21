package com.mycompany.util;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;


public class Preprocesor {
  List<String> toRemove;

  public Preprocesor(){
    toRemove = new ArrayList<String>();
  }

  public void defaultTextSet(){
    this.reset();
    this.addStrToRemove(".");
    this.addStrToRemove(";");
    this.addStrToRemove(",");
    this.addStrToRemove("!");
    this.addStrToRemove("\"");
    this.addStrToRemove("_");
    this.addStrToRemove("\n");

  }

  public void reset(){
    toRemove.clear();
  }

  public void addStrToRemove(String str){
    toRemove.add(str);
  }

  public String removeRegex(String text){
    System.out.println("removiendo los carácteres:"+this.toRemove);
    for (String str :toRemove){
      text = text.replace(str,"");
    }
    System.out.println("remoción terminada");
    return text;
  }

  public String compressSpaces(String text){
    System.out.println("removiendo espacios repetidos");
    text = text.replaceAll("\\s+"," ");
    System.out.println("remoción terminada");
    return text;
  }

  public String toPowerOfTwoLength(String text, int n){
    System.out.println("Reduciendo el largo de text a una potencia i de dos, con 10<=i<=23");
    System.out.println("El tamaño del texto es:"+text.length());
    if(text.length()<Math.pow(2,n)){
      assert false;
    }
    Double dnewl = Math.pow(2,n);
    int newl = dnewl.intValue();
    System.out.println("El nuevo tamaño del texto es:"+newl);
    return text.substring(0,newl);
  }

  public String process(String text){
    return compressSpaces(removeRegex(text.toLowerCase()));
  }

}
