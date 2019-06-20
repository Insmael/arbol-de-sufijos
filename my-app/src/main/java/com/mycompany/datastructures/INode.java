package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;

public interface INode {
  public abstract void accept(IVisitor visitor);
  public abstract int getCounter();
  public abstract void setCounter(int value);
}
