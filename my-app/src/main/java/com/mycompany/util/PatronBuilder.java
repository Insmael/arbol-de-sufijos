package com.mycompany.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PatronBuilder
{

  public static List<String> build(String text)
  {
    int l = text.length();
    int n = l/10;
    List<String> results = new ArrayList<String>();
    List<String> words = Arrays.asList(text.split(" "));
    Random randomGen =new Random();
    randomGen.setSeed(12);
    for (int i=0;i<n;i++)
    {
      results.add(words.get(randomGen.nextInt(words.size())));
    }
    return results;
  }
}
