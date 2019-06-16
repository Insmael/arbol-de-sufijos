package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class InsertVisitor implements IVisitor{
  String word;
  int index;

  public InsertVisitor(String word){
    this.word = word+'$';
    this.index = 0;
  }

  public void reset(String word){
    this.word = word+'$';
    this.index = 0;
  }


  public void visitNode(Node node){
    List<Character> caminos = node.getCaminos();
    Character chr = word.charAt(index);
    if (caminos.contains(chr) ) {
      TrieNode nextNode = node.getSons().get(caminos.indexOf(chr));
      index+=1;
      nextNode.accept(this);
    } else {
      caminos.add(chr);
      TrieNode newNode = null;
      if (chr == '$'){
        newNode = new Leaf(word);
      } else {
        newNode = new Node();
      }
      node.getSons().add(newNode);
      index+=1;
      newNode.accept(this);
    }
  }

  public void visitPNode(PNode node){
    String rest = word.substring(index);
    List<String> caminos = node.getCaminos();
    List<TrieNode> sons = node.getSons();
    int idx = Str.containsAt(rest, caminos);
    if (idx != -1) {
      String camino = caminos.get(idx);
      int length = Str.containsLength(rest, camino);
      index+=length;
      TrieNode oldson = sons.get(idx);
      if (length == camino.length()){
        oldson.accept(this);
      } else {
        //length es menor al camino completo
        String newCamino = camino.substring(0,length);
        String restCamino = camino.substring(length, camino.length());
        PNode newson = new PNode();
        newson.getSons().add(oldson);
        newson.getCaminos().add(restCamino);
        caminos.set(idx, newCamino);
        sons.set(idx, newson);
        newson.accept(this);
      }
    } else {
      //si no lo contiene y es para crear una hoja.
      if (word.charAt(index) == '$'){
        sons.add(new Leaf(word));
        caminos.add("$");
      //si no lo contiene y no es una hoja.
      } else {
        int subLength = rest.length()-1;
        TrieNode newNode = new PNode();
        caminos.add(word.substring(index, subLength));
        sons.add(newNode);
        index +=subLength;
        newNode.accept(this);
      }
    }
  }

  public void visitLeaf(Leaf node){
    ;
  }
}
