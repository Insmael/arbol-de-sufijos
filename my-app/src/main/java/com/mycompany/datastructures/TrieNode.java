package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;

public interface TrieNode {
  public abstract void accept(IVisitor visitor);
}
