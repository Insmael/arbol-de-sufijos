package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class SearchVisitor implements IVisitor{
  String word;
  int index;
  Boolean contains;

  public SearchVisitor(String word){
    this.word = word+'$';
    this.index = 0;
    this.contains = false;
  }


  public Boolean veredict(){
    return this.contains;
  }

  public void visitNode(Node node){
    List<Character> caminos = node.getCaminos();
    if (caminos.contains(word.charAt(index)) ) {
      TrieNode nextNode = node.getSons().get(caminos.indexOf(word.charAt(index)));
      this.index+=1;
      nextNode.accept(this);
    }
  }

  public void visitPNode(PNode node){
    String rest = word.substring(index);
    List<String> caminos = node.getCaminos();
    int at = Str.containsAt(rest, caminos);
    if (at != -1) {
      String camino = caminos.get(at);
      int length = Str.containsLength(rest,camino);
      if (length == camino.length()){
        TrieNode nextNode = node.getSons().get(at);
        index+=length;
        nextNode.accept(this);
      }
    }
  }

  public void visitSNode(SNode node){
    visitPNode(node);
  }

  public void visitLeaf(Leaf node){
    //contains = true; //es suficiente
    contains = word.equals(node.getWord()); //porsilasmoscas
  }

  public void visitSLeaf(SLeaf node){
    this.contains = true; //es suficiente

  }

}
