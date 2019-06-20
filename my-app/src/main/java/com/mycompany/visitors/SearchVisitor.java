package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class SearchVisitor extends Visitor implements IVisitor{
  Boolean contains;

  public SearchVisitor(String text, String word){
    super(text, word);
    this.contains = false;
  }

  public void reset(String word){
    this.contains = false;
    super.reset(word);
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

  void pathpartialmatch(Camino camino, int shared){
    if (this.index == this.wlength){
      this.contains = true;
    } else {
      this.contains = false;
    }
  }
}
