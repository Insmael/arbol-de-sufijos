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
public class InsertVisitorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void oneWordNodeTest()
    {
      String word = "siracusa";
      InsertVisitor ivisitor = new InsertVisitor(word);
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new Node();
      node.accept(ivisitor);
      node.accept(svisitor);
      assertTrue(svisitor.veredict());
    }

    @Test
    public void oneWordPNodeTest()
    {
      String word = "siracusa";
      InsertVisitor ivisitor = new InsertVisitor(word);
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new PNode();
      node.accept(ivisitor);
      node.accept(svisitor);
      assertTrue(svisitor.veredict());
    }


    @Test
    public void emptyWordNodeTest()
    {
      String word = "";
      InsertVisitor ivisitor = new InsertVisitor(word);
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new Node();
      node.accept(ivisitor);
      node.accept(svisitor);
      assertTrue(svisitor.veredict());
    }

    @Test
    public void emptyWordPNodeTest()
    {
      String word = "";
      InsertVisitor ivisitor = new InsertVisitor(word);
      SearchVisitor svisitor = new SearchVisitor(word);
      TrieNode node = new PNode();
      node.accept(ivisitor);
      node.accept(svisitor);
      assertTrue(svisitor.veredict());
    }

    @Test
    public void manyWordPNodeTest()
    {
      List<String> words = new ArrayList<String>();
      words.add("dogo");
      words.add("canis");
      words.add("mayores");
      words.add("orion");
      words.add("argonavis");
      words.add("sirio");
      words.add("siracusa");
      words.add("tirano");
      words.add("casio");
      words.add("flavio");
      TrieNode node = new PNode();
      InsertVisitor ivisitor = new InsertVisitor("dummyword");
      for (String word: words){
        ivisitor.reset(word);
        node.accept(ivisitor);
      }
      SearchVisitor svisitor = null;
      for (String word: words){
        svisitor = new SearchVisitor(word);
        node.accept(svisitor);
        assertTrue(svisitor.veredict());
      }
    }

    @Test
    public void manyWordNodeTest()
    {
      List<String> words = new ArrayList<String>();
      words.add("dogo");
      words.add("canis");
      words.add("mayores");
      words.add("orion");
      words.add("argonavis");
      words.add("sirio");
      words.add("siracusa");
      words.add("tirano");
      words.add("casio");
      words.add("flavio");
      TrieNode node = new Node();
      InsertVisitor ivisitor = new InsertVisitor("dummyword");
      for (String word: words){
        ivisitor.reset(word);
        node.accept(ivisitor);
      }
      SearchVisitor svisitor = null;
      for (String word: words){
        svisitor = new SearchVisitor(word);
        node.accept(svisitor);
        assertTrue(svisitor.veredict());
      }
    }
}
