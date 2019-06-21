package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.ArrayList;
import java.util.List;

public class TopVisitor implements IVisitor{
  String text;
  String word;
  int k;
  int q;
  int deep;
  List<String> pfxs;
  List<Integer> ocurs;

  public void reset(int k, int q){
    this.k = k;
    this.q = q;
    this.word = "";
    pfxs.clear();
    ocurs.clear();
  }

  public TopVisitor(String text, int k, int q){
    this.text = text;
    this.k = k;
    this.q = q;
    this.word = "";
    this.pfxs = new ArrayList<String>();
    this.ocurs = new ArrayList<Integer>();
  }

  public List<String> getTop(){
    return new ArrayList<String> (this.pfxs);
  }

  public void visitLeaf(Leaf node){
    int wl = this.word.length()-1;
    if(wl >= this.q){
      this.rearrange(this.word.substring(0,this.q), node.getCounter(), 0);
    }
  }

  public void visitNode(Node node)
  {
    int wl = this.word.length();
    if(wl >= this.q)
    {
      this.rearrange(this.word.substring(0,this.q), node.getCounter(), 0);
    }
    else
    {
      for(Camino camino : node.getCaminos())
      {
        int idx = camino.getIndex();
        int l = camino.getLength();
        String infix = this.text.substring(idx,idx+l);
        this.word = this.word.concat(infix);
        camino.getNode().accept(this);
        this.word = this.word.substring(0,wl);
      }
    }
  }

  public void rearrange(String word, int ncount, int i)
  {
    if(i<this.pfxs.size())
    {
      int num = this.ocurs.get(i);
      if(ncount<num)
      {
        rearrange(word, ncount, i+1);
      }
      else
      {
        String s = this.pfxs.get(i);
        this.ocurs.set(i, ncount);
        this.pfxs.set(i,new String(word));
        rearrange(s,num,i+1);
      }
    }
    else
    {
      if (i<this.k+1)
      {
        this.pfxs.add(new String(word));
        this.ocurs.add(ncount);
      }
    }
  }
}
