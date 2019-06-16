package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;

public class Leaf implements TrieNode {
  String word;
  int count;

  public Leaf(String word){
    this.word = word;
    this.count =0;
  }

  public String getWord(){
    return this.word;
  }

  public int getCount(){
    return this.count;
  }

  public void countsum1(){
    this.count+=1;
  }

  public void accept(IVisitor visitor){
    visitor.visitLeaf(this);
  }
}
