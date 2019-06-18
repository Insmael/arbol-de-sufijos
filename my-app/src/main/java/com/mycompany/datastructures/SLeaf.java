package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;

public class SLeaf implements TrieNode {
  int count;
  int posicion;

  public SLeaf(int posicion){
    this.posicion = posicion;
    this.count =0;
  }

  public int getCount(){
    return this.count;
  }

  public void countsum1(){
    this.count+=1;
  }

  public void accept(IVisitor visitor){
    visitor.visitSLeaf(this);
  }

  public String toString(){
    String msg = "SLeaf:"+"count:"+this.count+" posicion:"+this.posicion;
    return msg;
  }
}
