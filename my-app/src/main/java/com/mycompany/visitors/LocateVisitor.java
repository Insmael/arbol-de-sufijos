package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class LocateVisitor extends Visitor{
  String word;
  int wlength;
  int index;
  List<int> locations;

  public SearchVisitor(String word){
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
    this.count = 0;
  }


  public List<int> getLocations(){
    return this.locations;
  }

  void visitLeaf(Leaf leaf){
    this.locations.add(leaf.getPos());
  }

  void inprefix(Node node){
    for (Camino camino: node.getCaminos()){
      camino.getNode().accept(this);
    }
  }

  void nomatch(Node node){
    ;//se mantiene el contador en 0
  }

  void pathpartialmatch(Camino camino, int shared){
    if (this.index == this.wlength-1){
      //si se consumio por completo la palabra buscada
      camino.getNode().accept(this);
    } else {
      ;
    }
  }
}
