package com.mycompany.datastructures;

import java.util.List;
import com.mycompany.visitors.*;

public class PTrie extends Trie implements ITrie {
  TrieNode head;

  public PTrie() {
    this.head = new PNode();
  }

  public PTrie(String word){
    this();
    this.insert(word);
  }

  public PTrie(List<String> words){
    this();
    this.insert(words);
  }

  public void makeSuffixTree(String text){
    for (int i=0;i<text.length()-1;i++){
      this.insert(text.substring(i));
    }
  }
}
