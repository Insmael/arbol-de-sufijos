package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class CountVisitor implements IVisitor{
  String word;
  int index;
  int count;

  public CountVisitor(String word){
    this.word = word;
    this.index = 0;
    this.count = 0;
  }

  public void reset(){
    this.count = 0;
    this.index = 0;
  }

  public void reset(String word){
    this.word = word;
    this.index = 0;
    this.count = 0;
  }

  public int getCount(){
    return this.count;
  }

  public void visitNode(Node node){
    if (index == word.length()){
      count = node.getCount();
    } else {
      List<Character> caminos = node.getCaminos();
      if (caminos.contains(word.charAt(index)) ) {
        TrieNode nextNode = node.getSons().get(caminos.indexOf(word.charAt(index)));
        this.index+=1;
        nextNode.accept(this);
      }
    }
  }

  public void visitPNode(PNode node){
    if (index >= word.length()){
      count = node.getCount();
    } else {
      String rest = word.substring(index);
      List<String> caminos = node.getCaminos();
      if (!caminos.isEmpty()){
        int at = Str.containsAt(rest, caminos);
        if (at != -1) {
          String camino = caminos.get(at);
          System.out.println("camino:"+camino);
          System.out.println("rest:"+rest);
          int length = 0;
          if(camino.length() < rest.length()){
            length = Str.containsLength(rest,camino);
          } else {
            length = Str.containsLength(camino, rest);
          }
          System.out.println("length:"+length);
          TrieNode nextNode = node.getSons().get(at);
          index+=length;
          System.out.println("index:"+index);
          System.out.println("maxlength:"+word.length());
          nextNode.accept(this);
        }
      }
    }
  }

  public void visitSNode(SNode node){
    visitPNode(node);
  }


  public void visitLeaf(Leaf node){
    //contains = true; //es suficiente
    count = node.getCount();
  }

  public void visitSLeaf(SLeaf node){
    count = node.getCount();
  }
}
