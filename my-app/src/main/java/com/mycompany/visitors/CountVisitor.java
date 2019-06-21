package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;

public class CountVisitor extends Visitor implements IVisitor
{
  int count;

  public CountVisitor(String text, String word)
  {
    super(text,word);
    this.count = 0;
  }


  public int getCount()
  {
    return this.count;
  }

  void inprefix(Node node)
  {
    this.count = node.getCounter();
  }

  void nomatch(Node node)
  {
    ;//se mantiene el contador en 0
  }

  public void visitLeaf(Leaf node)
  {
    this.count = node.getCounter();
  }

  void pathpartialmatch(Camino camino, int shared)
  {
    if (this.index == this.wlength)
    {
      camino.getNode().accept(this);
    }
    else
    {
      ;
    }
  }
}
