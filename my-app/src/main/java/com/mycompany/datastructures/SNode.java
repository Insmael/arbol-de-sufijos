package com.mycompany.datastructures;

import com.mycompany.visitors.IVisitor;
import java.util.ArrayList;
import java.util.List;

public class SNode extends PNode implements TrieNode {

  public void accept(IVisitor visitor){
    visitor.visitSNode(this);
  }

  public String toString(){
    String msg = "SNode:\n"+"count:"+this.count+" ways:"+this.caminos+"\nsons:"+this.sons;
    return msg;
  }
}
