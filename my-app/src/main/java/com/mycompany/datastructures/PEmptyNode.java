package com.mycompany.datastructures;

class PEmptyNode implements TrieNode {

  public TrieNode insert(String word, int index) {
    return new PInnerNode(word, index);
  }
  public Boolean search(String word, int index){
    return false;
  }
}
