package com.mycompany.datastructures;

import java.util.List;
import com.mycompany.visitors.*;

public class Trie implements ITrie {
  TrieNode head;

  public Trie() {
    this.head = new Node();
  }

  public Trie(String word){
    this();
    this.insert(word);
  }

  public Trie(List<String> words){
    this();
    this.insert(words);
  }

  public void insert(String word){
    IVisitor insertVisitor = new InsertVisitor(word);
    this.head.accept(insertVisitor);
  }

  public void insert(List<String> words){
    InsertVisitor insertVisitor = new InsertVisitor("dummyWord");
    for (String word : words){
      insertVisitor.reset(word);
      this.head.accept(insertVisitor);
    }
  }

  public Boolean search(String word){
    SearchVisitor searchVisitor = new SearchVisitor(word);
    this.head.accept(searchVisitor);
    return searchVisitor.veredict();
  }

  public int countWord(String word){
    CountVisitor cvisitor = new CountVisitor(word+'$');
    this.head.accept(cvisitor);
    return cvisitor.getCount();
  }

  public int countPreffix(String word){
    CountVisitor cvisitor = new CountVisitor(word);
    this.head.accept(cvisitor);
    return cvisitor.getCount();
  }

  public String toString(){
    String msg = "Trie:\n"+this.head.toString();
    return msg;
  }


}
