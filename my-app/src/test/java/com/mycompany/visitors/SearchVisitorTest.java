package com.mycompany.visitors;

import com.mycompany.datastructures.*;
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
     public void emptySTrie()
     {
       String text = "$";
       STrie st = new STrie(text);
       assertFalse(st.search("eran"));
     }

     @Test
     public void aaaaaaSTrie_bbbbb_search()
     {
       String text =  "aaaaa";
       String text2 = "bbbbb";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text2.length();i++)
       {
         assertFalse(st.search(text2.substring(i)));
         assertTrue(st.search(text.substring(i)));
       }
     }

     @Test
     public void aaaaa_STrie_abababab_search()
     {
       String text = "aaaaa";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++)
       {
         assertTrue(st.search(text.substring(i)));
       }
       String text2 = "abababab";
       for(int i=0;i<text2.length();i++)
       {
         assertFalse(st.search(text2.substring(i)));
       }
     }

     @Test
     public void STrie_emptysearch()
     {
       String text = "procura coquetearme maaas";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++)
       {
         assertTrue(st.search(text.substring(i)));
       }
       assertTrue(st.search(""));
     }

     @Test
     public void STrie_biggersearch()
     {
       String text = "procura coquetearme maaas";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++){
         assertTrue(st.search(text.substring(i)));
       }
       String text2 = text + "y no reparo de lo que te hareee";
       for(int i=0;i<text.length();i++)
       {
         assertFalse(st.search(text2.substring(i)));
       }
     }
}
