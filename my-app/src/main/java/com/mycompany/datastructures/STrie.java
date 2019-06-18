package com.mycompany.datastructures;

import java.util.List;
import com.mycompany.visitors.*;

public class STrie extends Trie implements ITrie {

  public STrie() {
    super.head = new SNode();
  }

  public STrie(String text){
    this();
    InsertVisitor insertVisitor = new InsertVisitor("dummyWord");
    String word = "dummyWord";
    for (int i=0;i<text.length()-1;i++){
      word = text.substring(i);
      insertVisitor.reset(word, i);
      this.head.accept(insertVisitor);
    }
  }

  public void insert(String word){
    ;
  }

  public void insert(List<String> words){
    ;
  }

  public String toString(){
    String msg = "STrie:\n"+super.head.toString();
    return msg;
  }
}
