package com.mycompany.util;

public class Entry
{
  String dataset;
  int power;
  String consult;
  int wordlength;
  int k;
  long time;

  public Entry()
  {
    ;
  }

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

  public void setDataset(String dataset){
    this.dataset = dataset;
  }

  public void setPower(int power){
    this.power = power;
  }

  public void setConsult(String consult){
    this.consult = consult;
  }

  public void setWordlength(int wordlength){
    this.wordlength = wordlength;
  }

  public void setK(int k){
    this.k = k;
  }

  public void setTime(long time){
    this.time = time;
  }

  public String getDataset(){
    return this.dataset;
  }

  public int getPower(){
    return this.power;
  }

  public String getConsult(){
    return this.consult;
  }

  public int getWordlength(){
    return this.wordlength;
  }

  public int getK(){
    return this.k;
  }

  public long getTime(){
    return this.time;
  }
}
