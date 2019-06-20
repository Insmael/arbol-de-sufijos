package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class InsertVisitor implements IVisitor{
  String text;
  int index;
  int tlength;
  int pos;

  public InsertVisitor(String text, int pos){
    this.text = text;
    this.tlength = text.length();
    this.index = 0;
    this.pos = pos;
  }

  public void reset(int pos){
    this.pos = pos;
    this.index = 0;
  }

  public void visitLeaf(Leaf node){;}

  public void visitNode(Node node){
    node.plus1();
    if(this.index+this.pos == this.tlength-1){
      Camino camino = new Camino(new Leaf(this.pos),'$', this.pos+this.index, 1);
      node.addCamino(camino);
    } else {
      List<Camino> caminos = node.getCaminos();
      Boolean founded = false;
      for (Camino camino : caminos){
        if (this.equalChar(camino)){
          founded = true;
          Character chr = camino.getChar();
          int idx = camino.getIndex();
          int l = camino.getLength();
          int lim = this.tlength-this.index-this.pos;
          int shared = 1;
          for(; shared<l && shared<lim; shared++){
            if (!this.equalCharAt(shared,idx)){
              break;
            }
          }//numero de carácteres compartidos
          this.index += shared;
          if (shared == l){
            camino.getNode().accept(this);
          } else {
            Node newson = new Node();
            INode oldson = camino.getNode();
            newson.setCounter(oldson.getCounter());
            //el camino que va del nuevo nodo al viejo nodo
            Camino anotherc = new Camino(oldson, this.text.charAt(idx+shared), idx+shared, l-shared);
            newson.addCamino(anotherc);
            //ahora el viejo camino va al nuevo nodo
            camino.setNode(newson);
            camino.setLength(shared);
            newson.accept(this);
          }
          break;
        }
      }
      if(!founded){
        Camino camino = new Camino(new Leaf(this.pos), this.getChar(), this.pos+this.index, this.tlength-this.index-this.pos);
        node.addCamino(camino);
      }
    }
  }

  Boolean equalCharAt(int offset, int pfxIndex){
    return this.text.charAt(this.pos+this.index+offset) == this.text.charAt(pfxIndex+offset);
  }

  Boolean equalChar(Camino camino){
    return this.text.charAt(this.pos+this.index) == camino.getChar();
  }

  Character getChar(){
    return this.text.charAt(this.pos+this.index);
  }
}
