package com.mycompany.visitors;

import com.mycompany.datastructures.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SearchVisitorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void FindedSearchOverLeafTest()
    {
      String word = "siracusa";
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new Leaf(word+'$');
      assertFalse(svisitor.veredict());
      node.accept(svisitor);
      assertTrue(svisitor.veredict());
    }

    @Test
    public void NotFindedSearchOverLeafTest()
    {
      String word = "siracusa";
      String word2 = "salome";
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new Leaf(word2+'$');
      node.accept(svisitor);
      assertFalse(svisitor.veredict());
    }

    @Test
    public void NotFindedSearchOverEmptyNodeTest()
    {
      String word = "siracusa";
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new Node();
      node.accept(svisitor);
      assertFalse(svisitor.veredict());
    }

    @Test
    public void NotFindedSearchOverEmptyPNodeTest()
    {
      String word = "siracusa";
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new PNode();
      node.accept(svisitor);
      assertFalse(svisitor.veredict());
    }

    @Test
    public void FindedSearchOverOneNodeOneLeafEmptyStringTest()
    {
      String word = "";
      SearchVisitor svisitor = new SearchVisitor(word);
      Node node = new Node();
      TrieNode leaf = new Leaf(word+'$');
      node.getCaminos().add('$');
      node.getSons().add(leaf);
      node.accept(svisitor);
      assertTrue(svisitor.veredict());
    }

    @Test
    public void FindedSearchOverOnePNodeOneLeafEmptyStringTest()
    {
      String word = "";
      SearchVisitor svisitor = new SearchVisitor(word);
      PNode node = new PNode();
      TrieNode leaf = new Leaf(word+'$');
      node.getCaminos().add("$");
      node.getSons().add(leaf);
      node.accept(svisitor);
      assertTrue(svisitor.veredict());
    }


}
