package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import com.mycompany.utils.*;
import java.util.List;

public class TopVisitor implements IVisitor{
  String text;
  String word;
  int k;
  int q;
  int deep;
  List<String> pfxs;
  List<int> ocurs;

  public TopVisitor(String text, int k, int q){
    this.k = k;
    this.q = q;
    this.word = "";
    this.pfxs = new List<String>();
    this.ocurs = new List<Integer>();
  }

  public List<String> getResult(){

  }


  public void visitNode(Node node){
    int wl = this.length();
    if(wl >= this.q){
      this.rearrange(this.word, node.getCount(), 0);
      }
    } else {
      if (wl <this.q) {
      for(Camino camino : caminos){
        int idx = camino.getIndex();
        int l = camino.getLength();
        String infix = this.text.substring(idx,idx+l);
        this.word.concat(infix);
        camino.getNode().accept(this);
        this.word = this.word.substring(0,wl);
      }
    }
  }

  public void rearrange(String word, int ncount, int i){
    if(i<this.pfxs.length()){
      int num = this.ocurs.get(i)M
      if(ncount<num){
        rearrange(word, ncount, i+1);
      } else {
        String s = this.pfxs.get(i);
        this.ocurs.set(i, ncount);
        this.pfxs.set(i,word);
        rearrange(s,num,i+1);
      }
    } else {
      if (i<this.k+1)
      this.pfxs.add(word);
      this.ocurs.add(ncount);
    }
  }

}
