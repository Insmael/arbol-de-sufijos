package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class InsertVisitor implements IVisitor{
  String word;
  int index;
  int posicion;

  public InsertVisitor(String word){
    this.word = word+'$';
    this.index = 0;
  }

  public InsertVisitor(String word, int posicion){
    this.word = word+'$';
    this.index = 0;
    this.posicion = posicion;
  }

  public void reset(String word){
    this.word = word+'$';
    this.index = 0;
  }

  public void reset(String word, int posicion){
    this.word = word+'$';
    this.index = 0;
    this.posicion = posicion;
  }

  public void visitNode(Node node){
    node.countsum1();
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
    visitPNodeorSNode(node, false);
  }

  public void visitSNode(SNode node){
    visitPNodeorSNode(node, true);
  }

  public void visitLeaf(Leaf node){
    node.countsum1();
  }

  public void visitSLeaf(SLeaf node){
    node.countsum1();
  }

  void visitPNodeorSNode(PNode node, Boolean isSNode){
    node.countsum1();
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
        PNode newson = null;
        if (isSNode){
          newson = new SNode();
        } else {
          newson = new PNode();
        }
        newson.setCount(oldson.getCount());
        newson.getSons().add(oldson);
        newson.getCaminos().add(restCamino);
        caminos.set(idx, newCamino);
        sons.set(idx, newson);
        newson.accept(this);
      }
    } else {
      //si no lo contiene y es para crear una hoja.
      if (rest.equals("$")){
        TrieNode leaf = null;
        if(isSNode){
          leaf = new SLeaf(posicion);
        }else {
          leaf = new Leaf(word);
        }
        sons.add(leaf);
        caminos.add("$");
        leaf.accept(this);
      //si no lo contiene y no es una hoja.
      } else {
        TrieNode newNode = null;
        if(isSNode) {
          newNode = new SNode();
        } else {
          newNode = new PNode();
        }
        int newindex = word.length()-1;
        caminos.add(word.substring(index, newindex));
        sons.add(newNode);
        index = newindex;
        newNode.accept(this);
      }
    }
  }
}
