package com.mycompany.datastructures;

import com.mycompany.visitors.*;
import java.util.ArrayList;
import java.util.List;

public class STrie {
  INode head;
  String text;
  InsertVisitor ivstr;
  SearchVisitor svstr;
  CountVisitor cvstr;
  LocateVisitor lvstr;
  TopVisitor tvstr;


  public STrie(String text){
    this.text = text;
    this.head = new Node();
    this.ivstr = new InsertVisitor(text,0);
    this.svstr = new SearchVisitor(text,"");
    this.cvstr = new CountVisitor(text,"");
    this.lvstr = new LocateVisitor(text,"");
    this.tvstr = new TopVisitor(text,0,0);

    for (int i=0;i<text.length()-1;i++){
      ivstr.reset(i);
      //System.out.println(text.charAt(i));
      this.head.accept(ivstr);
      //System.out.println(this.head);
    }
  }

  public Boolean search(String prefix){
    svstr.reset(prefix);
    head.accept(svstr);
    return svstr.veredict();
  }

  public int count(String prefix){
    cvstr.reset(prefix);
    head.accept(cvstr);
    return cvstr.getCount();
  }

  public List<Integer> locate(String prefix){
    lvstr.reset(prefix);
    head.accept(lvstr);
    return lvstr.getLocations();
  }

  public List<String> topkq(int k, int q){
    tvstr.reset(k,q);
    head.accept(tvstr);
    return tvstr.getTop();
  }

  public String toString(){
    return "STrie: head->"+this.head.toString();
  }
}
