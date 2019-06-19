package com.mycompany.datastructures;

import java.utils.Arrayist;
import java.utils.List;

class STrie {
  INode head;

  public STrie(){
    head = Node();
  }

  public void build(String text){
    for (int i=0;i<text.length();i++){
      this.insert(text.substring(i));
    }
  }

  public void insert(String sufix){
    ;
  }

  public Boolean search(String prefix){
    return false;
  }

  public int count(String prefix){
    return 0;
  }

  public List<Integer> locate(String prefix){
    return null;
  }

  public List<String> topkq(int k, int q){
    return null;

  }
}
