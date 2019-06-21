package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;
import java.util.ArrayList;
import java.util.List;

public class Node implements INode
{
    List<Camino> caminos;
    int counter;

    public Node()
    {
      this.caminos = new ArrayList<Camino>();
      this.counter = 0;
    }

    public Node(Camino camino)
    {
      this.caminos = new ArrayList<Camino>();
      caminos.add(camino);
      this.counter = 0;
      //caminos.add(camino);
    }

    Node(List<Camino> lcaminos)
    {
      this.caminos = new ArrayList<Camino>(lcaminos);
      this.counter = 0;
    }

    public int getCounter()
    {
      return this.counter;
    }

    public List<Camino> getCaminos()
    {
      return this.caminos;
    }

    public void addCamino(Camino camino)
    {
      this.caminos.add(camino);
    }

    public void setCounter(int value)
    {
      this.counter = value;
    }

    public void plus1()
    {
      this.counter+=1;
    }

    public void accept(IVisitor visitor)
    {
      visitor.visitNode(this);
    }

    public String toString()
    {
      return "node:counter:"+this.counter+"|caminos->"+this.caminos;
    }
}
