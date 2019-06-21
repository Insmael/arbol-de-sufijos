package com.mycompany.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PatronBuilder
{

  public static List<String> buildEng(String text)
  {
    int l = text.length();
    int n = l/10;
    List<String> results = new ArrayList<String>();
    List<String> words = Arrays.asList(text.split(" "));
    Random randomGen =new Random();
    randomGen.setSeed(12);
    for (int i = 0; i < n; i++)
    {
      results.add(words.get(randomGen.nextInt(words.size())));
    }
    return results;
  }

  public static List<String> buildMissMatchEng()
  {
    return Arrays.asList("dogmatico", "gatito", "interesante", "profundamente", "quiropractico", "dogo", "chan", "verdugo", "kuma", "lavandera", "califragilisticoespialidoso", "onomatopeya", "wolframios", "calamardo", "dibujo", "ostia", "chile", "chocolate", "bebe", "dos", "uno", "siete", "doscientos");
  }

  public static List<String> buildMissMatchDna()
  {
    return Arrays.asList("acctccxa" , "txgg" , "atgcagacgtxttata" , "tttttttt" , "actagggactagatxt", "actagggactagatatactagggactagatxt", "atatatatcgatagctatacgtatagctatgt", "atatatatatatatatatatatatatatatatatatatatatatatatatatatatatatatat", "gcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgcgc");
  }

  public static List<String> buildDna(String text)
  {
    int l = text.length();
    int n = l/10;
    int[] sizes = {8, 16, 32, 64};
    List<String> results = new ArrayList<String>();
    Random randomGen =new Random();
    Random randomGen2 =new Random();
    randomGen.setSeed(12);
    randomGen2.setSeed(53);
    int idx, len;
    for (int i = 0; i < n; i++)
    {
      len = sizes[randomGen.nextInt(sizes.length)];
      idx = randomGen.nextInt(l-len);
      results.add(text.substring(idx,idx+len));
    }
    return results;
  }
}
