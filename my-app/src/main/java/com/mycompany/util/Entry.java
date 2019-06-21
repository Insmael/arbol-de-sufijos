package com.mycompany.util;

public class Entry
{
  int power;
  String dataset;
  String consult;
  int wordlength;
  int k;
  long time;

  public Entry(int power, String dataset,
                String consult, int wordlength, int k, long time)
  {
    this.power = power;
    this.dataset = dataset;
    this.consult = consult;
    this.wordlength = wordlength;
    this.k = k;
    this.time = time;
  }
}
