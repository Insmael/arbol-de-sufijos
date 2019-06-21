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
       result = st.top(1,2);
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
     public void abababSTrie()
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

}
