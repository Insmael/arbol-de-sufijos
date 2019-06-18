package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CountVisitorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void CountOverLeafTest()
    {
      String word = "siracusa";
      CountVisitor cvisitor = new CountVisitor(word);
      TrieNode node = new Leaf(word+'$');
      node.accept(cvisitor);
      assertEquals(0,cvisitor.getCount());
      InsertVisitor ivisitor = new InsertVisitor(word);
      node.accept(ivisitor);
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
    }

    @Test
    public void CountOverSLeafTest()
    {
      String word = "siracusa";
      String word2 = "salome";
      CountVisitor cvisitor = new CountVisitor(word);
      TrieNode node = new SLeaf(0);
      node.accept(cvisitor);
      assertEquals(0,cvisitor.getCount());
      InsertVisitor ivisitor = new InsertVisitor(word);
      node.accept(ivisitor);
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
    }

    @Test
    public void CountOverNodeTest()
    {
      String word = "siracusa";
      CountVisitor cvisitor = new CountVisitor(word);
      InsertVisitor ivisitor = new InsertVisitor(word);
      TrieNode node = new Node();
      node.accept(cvisitor);
      assertEquals(0,cvisitor.getCount());
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "mancha";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "sirano";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "sir";
      cvisitor.reset(word);
      node.accept(cvisitor);
      assertEquals(2,cvisitor.getCount());
      word = "siracusa";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset(word);
      node.accept(cvisitor);
      assertEquals(2,cvisitor.getCount());
      cvisitor.reset("sir");
      node.accept(cvisitor);
      assertEquals(3,cvisitor.getCount());
      cvisitor.reset("sira");
      node.accept(cvisitor);
      assertEquals(3,cvisitor.getCount());
    }

    @Test
    public void CountOverPNodeTest()
    {
      String word = "siracusa";
      CountVisitor cvisitor = new CountVisitor(word);
      InsertVisitor ivisitor = new InsertVisitor(word);
      TrieNode node = new PNode();
      node.accept(cvisitor);
      assertEquals(0,cvisitor.getCount());
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "mancha";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "sirano";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "sir";
      cvisitor.reset(word);
      node.accept(cvisitor);
      assertEquals(2,cvisitor.getCount());
      word = "siracusa";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset(word);
      node.accept(cvisitor);
      assertEquals(2,cvisitor.getCount());
      cvisitor.reset("sir");
      node.accept(cvisitor);
      assertEquals(3,cvisitor.getCount());
      cvisitor.reset("sira");
      node.accept(cvisitor);
      assertEquals(3,cvisitor.getCount());
    }

    @Test
    public void CountOverSNodeTest()
    {
      String word = "siracusa";
      CountVisitor cvisitor = new CountVisitor(word);
      InsertVisitor ivisitor = new InsertVisitor(word);
      TrieNode node = new SNode();
      node.accept(cvisitor);
      assertEquals(0,cvisitor.getCount());
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "mancha";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "sirano";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset();
      node.accept(cvisitor);
      assertEquals(1,cvisitor.getCount());
      word = "sir";
      cvisitor.reset(word);
      node.accept(cvisitor);
      assertEquals(2,cvisitor.getCount());
      word = "siracusa";
      ivisitor.reset(word);
      node.accept(ivisitor);
      cvisitor.reset(word);
      node.accept(cvisitor);
      assertEquals(2,cvisitor.getCount());
      cvisitor.reset("sir");
      node.accept(cvisitor);
      assertEquals(3,cvisitor.getCount());
      cvisitor.reset("sira");
      node.accept(cvisitor);
      assertEquals(3,cvisitor.getCount());
    }


}
