package com.mycompany.datastructures;

class Leaf implements TrieNode {
  String word;

  public Leaf(String word){
    this.word = word;
  }

  public TrieNode insert(String word, int index){
    return this;
  }

  public Boolean search(String word, int index){
    assert index== word.length();
    assert index == this.word.length();
    return true;//return this.word.equal(word);
  }
}
