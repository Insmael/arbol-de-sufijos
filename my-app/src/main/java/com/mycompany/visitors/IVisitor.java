package com.mycompany.visitors;

import com.mycompany.datastructures.*;

public interface IVisitor {
  abstract public void visitNode(Node node);
  abstract public void visitLeaf(Leaf node);
}
