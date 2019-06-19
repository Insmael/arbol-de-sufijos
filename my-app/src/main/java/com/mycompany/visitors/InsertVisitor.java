package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class InsertVisitor implements IVisitor{
  String word;
  int index;
  int pos;
  int wlength;

  public InsertVisitor(String word, int pos){
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
    this.pos = pos;
  }


  public void reset(String word){
    this.word = word;
    this.index = 0;
  }

  public void reset(String word, int pos){
    this.word = word;
    this.index = 0;
    this.posicion = pos;
  }

  public void visitNode(Node node){
    node.plus1();
    super.visitNode(node);
  }

  void inprefix(Node node){
    Camino camino = new Camino(new Leaf(pos),"$", this.index, 1);
    node.addCamino(camino);
  }

  void nomatch(Node node){
    Camino camino = new Camino(new Node(), this.word.charAt(this.index), this.wlength-1, this.wlength - this.index-1);
    node.addCamino(camino);
    this.index = this.wlength-1;
    camino.getNode().accept(this);
  }

  void pathpartialmatch(Camino camino, int shared){
    Node oldson = camino.getNode();
    Node newson = new Node()
    newson.setCounter(oldson.getCounter());
    //el camino que va del nuevo nodo al viejo nodo
    Camino anotherc = new Camino(oldson, c, idx+shared, l-shared);
    newson.addCamino(anotherc);
    //ahora el viejo camino va al nuevo nodo
    camino.setNode(newson);
    camino.setLength(shared);
    newson.accept(this);
  }
}
