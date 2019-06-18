package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;
import java.util.ArrayList;
import java.util.List;

public class PNode implements TrieNode {
  List<String> caminos;
  List<TrieNode> sons;
  int count;

  public PNode(){
    this.sons = new ArrayList<TrieNode>();
    this.caminos = new ArrayList<String>();
  }

  public List<TrieNode> getSons(){
    return this.sons;
  }

  public List<String> getCaminos(){
    return this.caminos;
  }

  public int getCount(){
    return this.count;
  }

  public void setCount(int newcount){
    this.count = newcount;
  }

  public void accept(IVisitor visitor){
    visitor.visitPNode(this);
  }

  public void countsum1(){
    this.count+=1;
  }

  public String toString(){
    String msg = "PNode:\n"+"count:"+this.count+" ways:"+this.caminos+"\nsons:"+this.sons;
    return msg;
  }
}
