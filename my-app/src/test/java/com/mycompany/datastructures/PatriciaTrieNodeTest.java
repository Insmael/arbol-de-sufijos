package com.mycompany.datastructures;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PatriciaTrieNodeTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void emptyPatriciaTrieSearch()
    {
        PatriciaTrie aPatriciaTrie = new PatriciaTrie();
        assertFalse(aPatriciaTrie.search(""));
        assertFalse(aPatriciaTrie.search("dogo"));
        assertFalse(aPatriciaTrie.search("marciano"));
    }

    @Test
    public void EmptyWordPatriciaTrieSearch()
    {
        PatriciaTrie aPatriciaTrie = new PatriciaTrie();
        aPatriciaTrie.insert("");
        assertTrue(aPatriciaTrie.search(""));
        assertFalse(aPatriciaTrie.search("dogo"));
        assertFalse(aPatriciaTrie.search("marciano"));
    }

    @Test
    public void oneWordPatriciaTrieSearch()
    {
        PatriciaTrie aPatriciaTrie = new PatriciaTrie();
        aPatriciaTrie.insert("urano");
        assertFalse(aPatriciaTrie.search(""));
        assertFalse(aPatriciaTrie.search("dogo"));
        assertFalse(aPatriciaTrie.search("marciano"));
        assertTrue(aPatriciaTrie.search("urano"));
    }

    @Test
    public void listBuildPatriciaTrieAllWordsSearch()
    {
        PatriciaTrie aPatriciaTrie = new PatriciaTrie();
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
        aPatriciaTrie.insert(words);
        for (String word : words){
          assertTrue(aPatriciaTrie.search(word));
        }
        assertFalse(aPatriciaTrie.search(""));
        assertFalse(aPatriciaTrie.search("solapa"));
        assertFalse(aPatriciaTrie.search("chancho"));
    }

    @Test
    public void ManyWordPatriciaTriesuffixSearch()
    {
        PatriciaTrie aPatriciaTrie = new PatriciaTrie();
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
        aPatriciaTrie.insert(words);
        for (String word : words){
          assertTrue(aPatriciaTrie.search(word));
        }
        assertFalse(aPatriciaTrie.search("sir"));
        assertFalse(aPatriciaTrie.search("s"));
        assertFalse(aPatriciaTrie.search("a"));
        assertFalse(aPatriciaTrie.search("solapa"));
        assertFalse(aPatriciaTrie.search("chancho"));
        assertTrue('$'<'0');
    }

    @Test
    public void suffixPatriciaTriesuffixSearch()
    {
        PatriciaTrie aPatriciaTrie = new PatriciaTrie();
        List<String> words = new ArrayList<String>();
        words.add("s");
        words.add("si");
        words.add("sira");
        words.add("sirac");
        words.add("siracusa");
        words.add("siracu");
        words.add("siracus");
        aPatriciaTrie.insert(words);
        for (String word : words){
          assertTrue(aPatriciaTrie.search(word));
        }
        assertFalse(aPatriciaTrie.search("sir"));
    }
}
