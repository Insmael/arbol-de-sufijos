package com.mycompany.datastructures;

interface TrieNode {
  public abstract TrieNode insert(String word, int index);
  public abstract Boolean search(String word, int index);
}
