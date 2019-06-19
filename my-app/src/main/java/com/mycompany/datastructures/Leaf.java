package com.mycompany.datastructures;

class Leaf implements INode {
  int pos;

  public Leaf(int pos){this.pos = pos;}
  public int getPos(){return this.pos;}
  public void setPos(int pos){this.pos = pos;}

  public void accept(Visitor visitor){
    visitor.visitLeaf(this);
  }
}
