package com.mycompany.datastructures;

public class Camino
{
  INode node;
  int index;
  int length;

  public Camino(INode node, int idx, int length)
  {
    this.node = node;
    this.index = idx;
    this.length = length;
  }

  public INode getNode()
  {
    return this.node;
  }

  public int getIndex()
  {
    return this.index;
  }

  public int getLength()
  {
    return this.length;
  }

  public void setNode(INode node)
  {
    this.node = node;
  }

  public void setIndex(int idx)
  {
    this.index = idx;
  }

  public void setLength(int length)
  {
    this.length = length;
  }

  public String toString()
  {
    return "Camino:idx:"+this.index+"|len:"+this.length+"|node->\n"+this.node;
  }
}
