package com.mycompany.visitors;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import com.mycompany.datastructures.*;
import java.util.List;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TopVisitorTest
{
    /**
     * Rigorous Test :-)
     */
     @Test
     public void emptySTrie()
     {
       String text = "$";
       STrie st = new STrie(text);
       List<String> result;
       result = st.top(0,2);
       assertTrue(result.isEmpty());
     }

     @Test
     public void aaaaaaSTrie()
     {
       String text =  "aaaaa";
       STrie st = new STrie(text+"$");
       List<String> result;
       for (int i=1;i<text.length();i++)
       {
         result = st.top(1,i);
         assertTrue(result.contains(text.substring(text.length()-i)));
         assertEquals(1,result.size());
       }

     }

     @Test
     public void top2_abababababab_STrie()
     {
       String text =  "abababababab";
       STrie st = new STrie(text+"$");
       List<String> result = st.top(2,text.length()-1);
       assertTrue(result.contains("bababababab"));
       assertTrue(result.contains("abababababa"));
       assertEquals(2,result.size());
       result = st.top(20,text.length()-1);
       assertTrue(result.contains("bababababab"));
       assertTrue(result.contains("abababababa"));
       assertEquals(2,result.size());
     }

     @Test
     public void top3_abcdefgh_STrie()
     {
       String text =  "abcdefgh";
       STrie st = new STrie(text+"$");
       List<String> result = st.top(3,text.length()-2);
       assertTrue(result.contains("abcdef"));
       assertTrue(result.contains("bcdefg"));
       assertTrue(result.contains("cdefgh"));
       assertEquals(3,result.size());
       result = st.top(20,text.length()-2);
       assertTrue(result.contains("abcdef"));
       assertTrue(result.contains("bcdefg"));
       assertTrue(result.contains("cdefgh"));
       assertEquals(3,result.size());
     }

     @Test
     public void top4_abcdefg_STrie()
     {
       String text =  "abcdefg";
       STrie st = new STrie(text+"$");
       List<String> result = st.top(4,text.length()-3);
       assertTrue(result.contains("abcd"));
       assertTrue(result.contains("bcde"));
       assertTrue(result.contains("cdef"));
       assertTrue(result.contains("defg"));
       assertEquals(4,result.size());
       result = st.top(20,text.length()-3);
       assertTrue(result.contains("abcd"));
       assertTrue(result.contains("bcde"));
       assertTrue(result.contains("cdef"));
       assertTrue(result.contains("defg"));
       assertEquals(4,result.size());
     }

     @Test
     public void sirSTrie()
     {
       String text =  "siranosiracusasiriosirbyronsistersicario";
       STrie st = new STrie(text+"$");
       List<String> result = st.top(1,3);
       assertTrue(result.contains("sir"));
       assertEquals(1,result.size());
     }

}
