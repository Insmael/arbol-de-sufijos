package com.mycompany.datastructures;

import java.util.List;
import com.mycompany.visitors.*;

public class PTrie extends Trie implements ITrie {

  public PTrie() {
    super.head = new PNode();
  }

  public PTrie(String word){
    this();
    this.insert(word);
  }

  public PTrie(List<String> words){
    this();
    this.insert(words);
  }

  public String toString(){
    String msg = "PTrie:\n"+super.head.toString();
    return msg;
  }

}
