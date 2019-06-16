package com.mycompany.datastructures;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TrieNodeTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void emptyTrieSearch()
    {
        Trie aTrie = new Trie();
        assertFalse(aTrie.search(""));
        assertFalse(aTrie.search("dogo"));
        assertFalse(aTrie.search("marciano"));
    }

    @Test
    public void EmptyWordTrieSearch()
    {
        Trie aTrie = new Trie();
        aTrie.insert("");
        assertTrue(aTrie.search(""));
        assertFalse(aTrie.search("dogo"));
        assertFalse(aTrie.search("marciano"));
    }

    @Test
    public void oneWordTrieSearch()
    {
        Trie aTrie = new Trie();
        aTrie.insert("urano");
        assertFalse(aTrie.search(""));
        assertFalse(aTrie.search("dogo"));
        assertFalse(aTrie.search("marciano"));
        assertTrue(aTrie.search("urano"));
    }

    @Test
    public void listBuildTrieAllWordsSearch()
    {
        Trie aTrie = new Trie();
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
        aTrie.insert(words);
        for (String word : words){
          assertTrue(aTrie.search(word));
        }
        assertFalse(aTrie.search(""));
        assertFalse(aTrie.search("solapa"));
        assertFalse(aTrie.search("chancho"));
    }

    @Test
    public void ManyWordTriesuffixSearch()
    {
        Trie aTrie = new Trie();
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
        aTrie.insert(words);
        for (String word : words){
          assertTrue(aTrie.search(word));
        }
        assertFalse(aTrie.search("sir"));
        assertFalse(aTrie.search("s"));
        assertFalse(aTrie.search("a"));
        assertFalse(aTrie.search("solapa"));
        assertFalse(aTrie.search("chancho"));
    }

    @Test
    public void suffixTriesuffixSearch()
    {
        Trie aTrie = new Trie();
        List<String> words = new ArrayList<String>();
        words.add("siracusa");
        words.add("s");
        words.add("si");
        words.add("sira");
        words.add("sirac");
        words.add("siracu");
        words.add("siracus");
        aTrie.insert(words);
        for (String word : words){
          assertTrue(aTrie.search(word));
        }
        assertFalse(aTrie.search("sir"));
    }
}
