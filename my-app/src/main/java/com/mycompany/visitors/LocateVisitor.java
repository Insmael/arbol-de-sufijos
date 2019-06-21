package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.List;
import java.util.ArrayList;

public class LocateVisitor extends Visitor implements IVisitor
{
  List<Integer> locations;

  public LocateVisitor(String text, String word)
  {
    super(text,word);
    this.locations = new ArrayList<Integer>();
  }

  public void reset(String word)
  {
    this.locations.clear();
    super.reset(word);
  }


  public List<Integer> getLocations()
  {
    return this.locations;
  }

  public void visitLeaf(Leaf node)
  {
    this.locations.add(node.getPos());
  }

  void inprefix(Node node)
  {
    for (Camino camino : node.getCaminos())
    {
      camino.getNode().accept(this);
    }
  }

  void nomatch(Node node)
  {
    this.locations.add(-1);
  }

  void pathpartialmatch(Camino camino, int shared)
  {
    if (this.index == this.wlength)
    {
      //si se consumio por completo la palabra buscada
      camino.getNode().accept(this);
    }
    else
    {
      ;
    }
  }
}
