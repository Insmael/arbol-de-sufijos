package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class InsertVisitor implements IVisitor
{
  String text;
  int index;
  int tlength;
  int pos;

  public InsertVisitor(String text, int pos)
  {
    this.text = text;
    this.tlength = text.length();
    this.index = 0;
    this.pos = pos;
  }

  public void reset(int pos)
  {
    this.pos = pos;
    this.index = 0;
  }

  public void visitLeaf(Leaf node)
  {
    ;
  }

  public void visitNode(Node node)
  {
    node.plus1();
    int shared = 0;
    for (Camino camino : node.getCaminos())
    {
      //numero de carácteres compartidos
      shared = 0;
      for(; shared<camino.getLength()
            && shared < this.tlength-this.index-this.pos; shared++)
      {
        if (this.text.charAt(this.pos+this.index+shared)
            != this.text.charAt(camino.getIndex()+shared))
        {
          break;
        }
      }
      if (shared > 0)
      {
        this.index += shared;
        if (shared == camino.getLength())
        {
          camino.getNode().accept(this);
        }
        else
        {
          Node newson = new Node();
          newson.setCounter(camino.getNode().getCounter());

          //el camino que va del nuevo nodo al viejo nodo
          newson.addCamino(new Camino(camino.getNode(),
                            camino.getIndex()+shared,
                            camino.getLength()-shared));

          //ahora el viejo camino va al nuevo nodo
          camino.setNode(newson);
          camino.setLength(shared);
          newson.accept(this);
        }
        break;
      }
    }
    if(shared==0)
    {
      Camino camino = new Camino(new Leaf(this.pos),
                                  this.pos+this.index,
                                  this.tlength-this.index-this.pos);
      node.addCamino(camino);
    }
  }
}
