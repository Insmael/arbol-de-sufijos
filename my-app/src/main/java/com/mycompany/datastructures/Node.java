package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;
import java.util.ArrayList;
import java.util.List;

public class Node implements TrieNode {
  List<TrieNode> sons;
  List<Character> caminos;
  int count;

  public Node(){
    this.sons = new ArrayList<TrieNode>();
    this.caminos = new ArrayList<Character>();
    this.count = 0;
  }

  public List<TrieNode> getSons(){
    return this.sons;
  }

  public List<Character> getCaminos(){
    return this.caminos;
  }

  public void accept(IVisitor visitor){
    visitor.visitNode(this);
  }
}
