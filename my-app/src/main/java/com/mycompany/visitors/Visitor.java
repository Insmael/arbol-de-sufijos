package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class Visitor implements IVisitor
{
  String text;
  String word;
  int index;
  int wlength;

  public Visitor(String text, String word)
  {
    this.text = text;
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
  }

  public void reset(String word)
  {
    this.word = word;
    this.wlength = word.length();
    this.index = 0;
  }

  public void visitLeaf(Leaf node)
  {
    ;
  }

  public void visitNode(Node node)
  {
    if(this.index == this.wlength)
    {
      this.inprefix(node);
    }
    else
    {
      int shared=0;
      for (Camino camino : node.getCaminos())
      {
        shared = 0;
        for(; shared<camino.getLength() && shared<this.wlength-this.index;shared++)
        {
          if (this.word.charAt(this.index+shared)
                != this.text.charAt(camino.getIndex()+shared))
          {
            break;
          }
        }//numero de carácteres compartidos
        if (shared > 0)
        {
          this.index += shared;
          if (shared == camino.getLength())
          {
            camino.getNode().accept(this);
          }
          else
          {
            this.pathpartialmatch(camino, shared);
          }
          break;
        }
      }
    }
  }

  void inprefix(Node node)
  {
    ;
  }

  void pathpartialmatch(Camino camino, int shared)
  {
    ;
  }
}
