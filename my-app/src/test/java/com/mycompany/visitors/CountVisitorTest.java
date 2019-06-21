package com.mycompany.visitors;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import com.mycompany.datastructures.*;
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
     public void emptySTrie()
     {
       String text = "$";
       STrie st = new STrie(text);
       assertEquals(0,st.count("eran"));
     }

     @Test
     public void aaaaa_STrie()
     {
       String text = "aaaaa";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++)
       {
         assertEquals(i+1,st.count(text.substring(i)));
       }
     }

     @Test
     public void abab_STrie()
     {
       String text = "abab";
       STrie st = new STrie(text+"$");
       assertEquals(1,st.count("abab"));
       assertEquals(1,st.count("aba"));
       assertEquals(1,st.count("ba"));
       assertEquals(2,st.count("a"));
       assertEquals(2,st.count("b"));
       assertEquals(2,st.count("ab"));
       assertEquals(1,st.count("bab"));
       assertEquals(4,st.count(""));
     }

}
