package com.mycompany.datastructures;

import java.utils.Arrayist;
import java.utils.List;

class Node implements INode {
    List<Camino> caminos;
    int counter;

    public Node(){
      this.caminos = new ArrayList<Camino>();
      this.counter = 0;
    }

    public Node(Camino camino){
      this.caminos = new ArrayList<Camino>(camino);
      this.counter = 0;
      //caminos.add(camino);
    }

    Node(List<Camino> lcaminos){
      this.caminos = new ArrayList<Camino>(lcaminos);
      this.counter = 0;
    }

    public int getCounter(){
      return this.counter;
    }

    public List<Caminos> getCaminos(){
      return this.caminos;
    }

    public void addCamino(Camino camino){
      this.caminos.add(camino);
    }

    public int setCounter(int value){
      this.counter = value;
    }

    public void plus1(){
      this.counter+=1;
    }

    public void accept(Visitor visitor){
      visitor.visitNode(this);
    }
}
