package com.mycompany.visitors;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.mycompany.datastructures.*;
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
     public void emptySTrie()
     {
       String text = "$";
       STrie st = new STrie(text);
       assertFalse(st.search("eran"));
     }

     @Test
     public void aaaaa_STrie()
     {
       String text = "aaaaa";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++){
         assertTrue(st.search(text.substring(i)));
       }
     }

     @Test
     public void abab_STrie()
     {
       String text = "abab";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++){
         assertTrue(st.search(text.substring(i)));
       }
     }

     @Test
     public void abac_STrie()
     {
       String text = "abac";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++){
         assertTrue(st.search(text.substring(i)));
       }
     }

     @Test
     public void aabaac_STrie()
     {
       String text = "aabaac";
       STrie st = new STrie(text+"$");
       for(int i=0;i<text.length();i++){
         assertTrue(st.search(text.substring(i)));
       }
     }

    @Test
    public void textSTrie()
    {
      String text = "eran las 5 e la mañana, y blablabla para un sueño";
      STrie st = new STrie(text+"$");
      for(int i=0;i<text.length();i++){
        assertTrue(st.search(text.substring(i)));
      }
    }
}
