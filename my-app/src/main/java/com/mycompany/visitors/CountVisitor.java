package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class CountVisitor extends Visitor{
  String word;
  int wlength;
  int index;
  int count;

  public SearchVisitor(String word){
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
    this.count = 0;
  }


  public int getCount(){
    return this.contains;
  }

  void inprefix(Node node){
    this.count = node.getCount();
  }

  void nomatch(Node node){
    ;//se mantiene el contador en 0
  }

  void pathpartialmatch(Camino camino, int shared){
    if (this.index == this.wlength-1){
      camino.getNode().accept(this);
    } else {
      this.contains = false;
    }
  }
}
