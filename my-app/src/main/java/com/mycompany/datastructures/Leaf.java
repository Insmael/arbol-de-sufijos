package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;

public class Leaf implements INode {
  int pos;

  public Leaf(int pos){this.pos = pos;}
  public int getPos(){return this.pos;}
  public void setPos(int pos){this.pos = pos;}

  public void accept(IVisitor visitor){
    visitor.visitLeaf(this);
  }

  public int getCounter(){return 1;}
  public void setCounter(int value){;}

  public String toString(){
    return "Leaf:pos:"+this.pos;
  }
}
