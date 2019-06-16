package com.mycompany.datastructures;

class EmptyNode implements TrieNode {

  public TrieNode insert(String word, int index) {
    return new InnerNode(word, index);
  }
  public Boolean search(String word, int index){
    return false;
  }
}
