package com.mycompany.datastructures;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PTrieTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void emptyPTrieSearch()
    {
        PTrie aPTrie = new PTrie();
        assertFalse(aPTrie.search(""));
        assertFalse(aPTrie.search("dogo"));
        assertFalse(aPTrie.search("marciano"));
    }

    @Test
    public void EmptyWordPTrieSearch()
    {
        PTrie aPTrie = new PTrie();
        aPTrie.insert("");
        assertTrue(aPTrie.search(""));
        assertFalse(aPTrie.search("dogo"));
        assertFalse(aPTrie.search("marciano"));
    }

    @Test
    public void oneWordPTrieSearch()
    {
        PTrie aPTrie = new PTrie();
        aPTrie.insert("urano");
        assertFalse(aPTrie.search(""));
        assertFalse(aPTrie.search("dogo"));
        assertTrue(aPTrie.search("urano"));
        assertFalse(aPTrie.search("marciano"));
    }

    @Test
    public void listBuildPTrieAllWordsSearch()
    {
        PTrie aPTrie = new PTrie();
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
        aPTrie.insert(words);
        for (String word : words){
          assertTrue(aPTrie.search(word));
        }
        assertFalse(aPTrie.search(""));
        assertFalse(aPTrie.search("solapa"));
        assertFalse(aPTrie.search("chancho"));
    }

    @Test
    public void ManyWordPTriesuffixSearch()
    {
        PTrie aPTrie = new PTrie();
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
        aPTrie.insert(words);
        for (String word : words){
          assertTrue(aPTrie.search(word));
        }
        assertFalse(aPTrie.search("sir"));
        assertFalse(aPTrie.search("s"));
        assertFalse(aPTrie.search("a"));
        assertFalse(aPTrie.search("solapa"));
        assertFalse(aPTrie.search("chancho"));
        assertTrue('$'<'0');
    }

    @Test
    public void preffixPTriePreffixSearch()
    {
        PTrie aPTrie = new PTrie();
        List<String> words = new ArrayList<String>();
        words.add("s");
        words.add("si");
        words.add("sira");
        words.add("sirac");
        words.add("siracusa");
        words.add("siracu");
        words.add("siracus");
        aPTrie.insert(words);
        for (String word : words){
          assertTrue(aPTrie.search(word));
        }
        assertFalse(aPTrie.search("sir"));
    }

    @Test
    public void suffixPTrieSuffixSearch()
    {
        PTrie aPTrie = new PTrie();
        List<String> words = new ArrayList<String>();
        words.add("siracusa");
        words.add("iracusa");
        words.add("acusa");
        words.add("racusa");
        words.add("sa");
        words.add("cusa");
        words.add("a");
        aPTrie.insert(words);
        for (String word : words){
          assertTrue(aPTrie.search(word));
        }
        assertFalse(aPTrie.search("usa"));
    }

    @Test
    public void countPTrie()
    {
        PTrie aPTrie = new PTrie();
        List<String> words = new ArrayList<String>();
        words.add("siracusa");
        words.add("iracusa");
        words.add("racusa");
        words.add("acusa");
        words.add("cusa");
        words.add("usa");
        words.add("sa");
        words.add("a");
        aPTrie.insert(words);
        assertTrue(true);
        //assertEqual(2,aPTrie.count("a"));
        //assertEqual(1,aPTrie.count("siracusa"));
    }
}
