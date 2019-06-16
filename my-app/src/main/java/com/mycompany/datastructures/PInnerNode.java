package com.mycompany.datastructures;

import java.util.ArrayList;
import java.util.List;

class PInnerNode implements TrieNode {
  List<TrieNode> sons;
  List<String> caminos;

  public PInnerNode(String camino, TrieNode node){
    this.sons = new ArrayList<TrieNode>();
    this.caminos = new ArrayList<String>();
    caminos.add(camino);
    sons.add(node);
  }

  public PInnerNode(String word, int index){
    this.sons = new ArrayList<TrieNode>();
    this.caminos = new ArrayList<String>();
    caminos.add(Character.toString(word.charAt(index)));
    if(word.charAt(index) == '$'){
      sons.add(new Leaf(word));
    }
    else {
      //en teoría nunca se llega a esta parte....
      sons.add(new InnerNode(word, index+1));
    }
  }

  public TrieNode insert(String word, int index){
    int at = this.containsAt(word, index);
    if (at != -1) {
      int length = this.containsLength(word,index,at);
      String camino = caminos.get(at);
      TrieNode oldson = sons.get(at);
      if (length == camino.length()){
        oldson.insert(word,index+length);
      } else {
        //length es menor al camino completo
        String newCamino = camino.substring(0,length);
        String restCamino = camino.substring(length, camino.length());
        TrieNode newson = new PInnerNode(restCamino, oldson);
        caminos.set(at, newCamino);
        sons.set(at, newson);
        newson.insert(word, index+length);
      }
    } else {
      //si no lo contiene y es para crear una hoja.
      if (word.charAt(index) == '$'){
        sons.add(new Leaf(word));
      //si no lo contiene y no es una hoja.
      } else {
        int subLength = word.length()-index-1;
        caminos.add(word.substring(index, subLength));
        sons.add(new InnerNode(word, index+subLength));
      }
    }
    return this;
  }

  public Boolean search(String word, int index){
    int at = this.containsAt(word, index);
    if (at != -1) {
      int length = this.containsLength(word,index,at);
      String camino = caminos.get(at);
      if (length == camino.length()){
        TrieNode nextNode = sons.get(at);
        return nextNode.search(word, index+length);
      }
    }
    return false;
  }

  int containsAt(String word, int index){
    String rest = word.substring(index);
    for (int j=0; j<this.caminos.size();j++){
      String camino = this.caminos.get(j);
      for(int i = 0; i<camino.length();i++){
        if (camino.charAt(i) != rest.charAt(i)){
          break;
        }
        if(i==camino.length()-1){
          return j;
        }
      }
    }
    return -1;
  }

  int containsLength(String word, int index, int at){
    String rest = word.substring(index);
    String camino = this.caminos.get(at);
    for(int i = 0; i<camino.length();i++){
      if (camino.charAt(i) != rest.charAt(i)){
        return i+1;
      }
    }
    return  camino.length();
  }
}
