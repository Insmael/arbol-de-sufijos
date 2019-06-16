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

  public void accept(IVisitor visitor){
    visitor.visitPNode(this);
  }
}
