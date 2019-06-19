package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class Visitor implements IVisitor{
  String word;
  int index;
  int wlength;

  public Visitor(String word){
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
  }

  public void visitLeaf(Leaf node){;}

  public void visitNode(Node node){
    if(this.index >= this.wlength-1){
      this.inprefix(node)
    } else {
      List<Caminos> caminos = node.getCaminos();
      for (Camino camino : caminos){
        if (camino.getChar() == this.word.charAt(this.index){
          Character chr = camino.getChar();
          int idx = camino.getIndex();
          int l = camino.getLength();
          String prefix = this.text.substring(idx, idx+l);
          int shared = 1;
          for(; shared<l && shared<=this.wlength-1-this.index;b++){
            if (prefix.charAt(shared) != this.word.charAt(this.index+shared){
              break;
            }
          }//numero de carácteres compartidos
          this.index += shared;
          if (shared == l){
            camino.getNode().accept(this);
          } else {
            this.pathpartialmatch(camino, shared);
          }
        }
      }
      this.nomatch(node);
    }
  }

  void inprefix(Node node){;}
  void nomatch(Node node){;}
  void pathpartialmatch(Camino camino, int shared){;}
}
