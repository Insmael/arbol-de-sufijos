package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node implements INode
{
    Camino[] caminos;
    int counter;

    public Node()
    {
      this.caminos = new Camino[0];
      this.counter = 0;
    }

    public int getCounter()
    {
      return this.counter;
    }

    public Camino[] getCaminos()
    {
      return this.caminos;
    }

    public void addCamino(Camino camino)
    {
      Camino[] temp = new Camino[this.caminos.length+1];
      java.lang.System.arraycopy(this.caminos,0,temp,0,this.caminos.length);
      temp[temp.length-1]=camino;
      this.caminos=temp;
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
