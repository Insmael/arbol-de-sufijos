package com.mycompany.datastructures;

import java.util.List;

public class Trie {
  TrieNode head;

  public Trie() {
    this.head = new EmptyNode();
  }

  public Trie(String word){
    this.insert(word);
  }

  public Trie(List<String> words){
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
