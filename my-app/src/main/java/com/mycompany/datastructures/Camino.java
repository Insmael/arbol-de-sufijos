package com.mycompany.datastructures;

public class Camino
{
  INode node;
  Integer index;
  Integer length;

  public Camino(INode node, Integer idx, Integer length)
  {
    this.node = node;
    this.index = idx;
    this.length = length;
  }

  public INode getNode()
  {
    return this.node;
  }

  public Integer getIndex()
  {
    return this.index;
  }

  public Integer getLength()
  {
    return this.length;
  }
  
  public void setNode(INode node)
  {
    this.node = node;
  }

  public void setIndex(Integer idx)
  {
    this.index = idx;
  }

  public void setLength(Integer length)
  {
    this.length = length;
  }

  public String toString()
  {
    return "Camino:idx:"+this.index+"|len:"+this.length+"|node->\n"+this.node;
  }
}
