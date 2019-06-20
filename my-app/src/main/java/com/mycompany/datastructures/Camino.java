package com.mycompany.datastructures;

public class Camino {
  INode node;
  Character chr;
  Integer index;
  Integer length;

  public Camino(INode node, Character chr, Integer idx, Integer length){
    this.node = node;
    this.chr = chr;
    this.index = idx;
    this.length = length;
  }

  public INode getNode(){return this.node;}
  public Character getChar(){return this.chr;}
  public Integer getIndex(){return this.index;}
  public Integer getLength(){return this.length;}
  public void setNode(INode node){this.node = node;}
  public void setChar(Character chr){this.chr = chr;}
  public void setIndex(Integer idx){this.index = idx;}
  public void setLength(Integer length){this.length = length;}

  public String toString(){
    return "Camino:chr:"+this.chr+"|idx:"+this.index+"|len:"+this.length+"|node->\n"+this.node;
  }
}
