package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.Arrays;
import java.util.List;

public class TopVisitor implements IVisitor
{
  String text;
  String word;
  int k;
  int q;
  int size;
  String[] pfxs;
  int[] ocurs;

  public TopVisitor(String text, int k, int q)
  {
    this.text = text;
    this.k = k;
    this.q = q;
    this.word = "";
    this.size = 0;
    this.pfxs = new String[k+1];
    this.ocurs = new int[k+1];
  }

  public void reset(int k, int q)
  {
    this.k = k;
    this.q = q;
    this.word = "";
    this.size = 0;
    this.pfxs = new String[k+1];
    this.ocurs = new int[k+1];
  }

  public List<String> getTop()
  {
    String[] top = Arrays.copyOf(this.pfxs,this.size);
    return Arrays.asList(top);
  }

  public void visitLeaf(Leaf node)
  {
    if(this.size < this.k || 0 < this.size && this.ocurs[this.size-1] < node.getCounter())
    {
      if(this.word.length()-1 >= this.q)
      {
        this.rearrange(this.word.substring(0,this.q), node.getCounter(), 0);
      }
    }
  }

  public void visitNode(Node node)
  {
    if(this.size < this.k || 0 < this.size && this.ocurs[this.size-1] < node.getCounter())
    {
      int wl = this.word.length();
      if(wl >= this.q)
      {
        this.rearrange(this.word.substring(0,this.q), node.getCounter(), 0);
      }
      else
      {
        int idx = 0;
        int l = 0;
        String infix = "";
        for(Camino camino : node.getCaminos())
        {
          idx = camino.getIndex();
          l = camino.getLength();
          infix = this.text.substring(idx,idx+l);
          this.word = this.word.concat(infix);
          camino.getNode().accept(this);
          this.word = this.word.substring(0,wl);
        }
      }
    }
  }

  public void rearrange(String word, int ncount, int i)
  {
    if(i < this.size)
    {
      int num = this.ocurs[i];
      if(ncount < num)
      {
        rearrange(word, ncount, i+1);
      }
      else
      {
        String s = this.pfxs[i];
        this.ocurs[i] = ncount;
        this.pfxs[i] = new String(word);
        rearrange(s, num, i+1);
      }
    }
    else if (i < this.k)
    {
      this.pfxs[i] = new String(word);
      this.ocurs[i] = ncount;
      this.size = i+1;
    }
  }
}
