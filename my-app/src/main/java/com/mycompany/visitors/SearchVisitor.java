package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class SearchVisitor extends Visitor{
  String word;
  int wlength;
  int index;
  Boolean contains;

  public SearchVisitor(String word){
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
    this.contains = false;
  }


  public Boolean veredict(){
    return this.contains;
  }

  void inprefix(Node node){
    this.contains = true;
  }

  void nomatch(Node node){
    this.contains = false;
  }

  void pathfullmatch(Camino camino){
    camino.getNode().accept(this);
  }

  void pathpartialmatch(Camino camino, int shared){
    if (this.index == this.wlength-1){
      this.contains = true;
    } else {
      this.contains = false;
    }
  }
}
