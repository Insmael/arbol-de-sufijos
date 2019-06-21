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
      Boolean founded = false;
      for (Camino camino : node.getCaminos()){
        if (this.equalChar(camino)){
          founded = true;
          int shared = 1;
          for(; shared<camino.getLength() && shared<this.tlength-this.index-this.pos; shared++){
            if (!this.equalCharAt(shared,camino.getIndex())){
              break;
            }
          }//numero de carácteres compartidos
          this.index += shared;
          if (shared == camino.getLength()){
            camino.getNode().accept(this);
          } else {
            Node newson = new Node();
            newson.setCounter(camino.getNode().getCounter());
            //el camino que va del nuevo nodo al viejo nodo
            newson.addCamino(new Camino(camino.getNode(), this.text.charAt(camino.getIndex()+shared), camino.getIndex()+shared, camino.getLength()-shared));
            //ahora el viejo camino va al nuevo nodo
            camino.setNode(newson);
            camino.setLength(shared);
            camino = null;
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
