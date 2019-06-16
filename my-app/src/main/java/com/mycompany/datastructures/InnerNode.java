package com.mycompany.datastructures;

import java.util.ArrayList;
import java.util.List;

class InnerNode implements TrieNode {
  List<TrieNode> sons;
  List<Character> caracteres;

  public InnerNode(String word, int index){
    this.sons = new ArrayList<TrieNode>();
    this.caracteres = new ArrayList<Character>();
    caracteres.add(word.charAt(index));
    if(word.charAt(index) == '$'){
      sons.add(new Leaf(word));
    }
    else {
      sons.add(new InnerNode(word, index+1));
    }
  }

  public TrieNode insert(String word, int index){
    if (caracteres.contains(word.charAt(index))){
      TrieNode nextNode = sons.get(caracteres.indexOf(word.charAt(index)));
      nextNode.insert(word, index+1);
    } else {
      caracteres.add(word.charAt(index));
      if (word.charAt(index) == '$'){
        sons.add(new Leaf(word));
      } else {
        sons.add(new InnerNode(word, index+1));
      }
    }
    return this;
  }

  public Boolean search(String word, int index){
    if (caracteres.contains(word.charAt(index)) ) {
      TrieNode nextNode = sons.get(caracteres.indexOf(word.charAt(index)));
      return nextNode.search(word, index+1);
    }
    else{
      return false;
    }
  }
}
