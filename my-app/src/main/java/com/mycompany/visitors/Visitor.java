package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class Visitor implements IVisitor{
  String text;
  String word;
  int index;
  int wlength;

  public Visitor(String text, String word){
    this.text = text;
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
  }

  public void reset(String word){
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
  }

  public void visitLeaf(Leaf node){;}

  public void visitNode(Node node){
    if(this.index == this.wlength){
      this.inprefix(node);
    } else {
      List<Camino> caminos = node.getCaminos();
      Boolean founded = false;
      for (Camino camino : caminos){
        if (this.equalChar(camino)){
          founded = true;
          Character chr = camino.getChar();
          int idx = camino.getIndex();
          int l = camino.getLength();
          int lim = this.wlength-this.index;
          int shared = 1;
          for(; shared<l && shared<lim;shared++){
            if (!this.equalCharAt(shared,idx)){
              break;
            }
          }//numero de carácteres compartidos
          this.index += shared;
          if (shared == l){
            camino.getNode().accept(this);
          } else {
            this.pathpartialmatch(camino, shared);
          }
          break;
        }
      }
      if(!founded){
        this.nomatch(node);
      }
    }
  }

  Boolean equalCharAt(int offset, int pfxIndex){
    return this.word.charAt(this.index+offset) == this.text.charAt(pfxIndex+offset);
  }

  Boolean equalChar(Camino camino){
    return this.word.charAt(this.index) == camino.getChar();
  }

  void inprefix(Node node){;}
  void nomatch(Node node){;}
  void pathpartialmatch(Camino camino, int shared){;}
}
