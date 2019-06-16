package com.mycompany.datastructures;

import java.util.List;

public class PatriciaTrie {
  TrieNode head;

  public PatriciaTrie() {
    this.head = new PEmptyNode();
  }

  public PatriciaTrie(String word){
    this.insert(word);
  }

  public PatriciaTrie(List<String> words){
    this.insert(words);
  }

  public void insert(String word){
    this.head = head.insert(word+'$', 0);
  }

  public void insert(List<String> words){
    for (String word : words){
      this.insert(word);
    }
  }

  public Boolean search(String word){
    return this.head.search(word+'$', 0);
  }
}
