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
public class LocateVisitorTest
{
    /**
     * Rigorous Test :-)
     */
     @Test
     public void emptySTrie()
     {
       String text = "$";
       STrie st = new STrie(text);
       List<Integer> result;
       assertFalse(st.search("eran"));
     }

     @Test
     public void aaaaaaSTrie()
     {
       String text =  "aaaaa";
       STrie st = new STrie(text+"$");
       List<Integer> result = st.locate("a");
       for (int i=0;i<text.length();i++){
         assertTrue(result.contains(i));
       }

     }

     @Test
     public void abababSTrie()
     {
       String text =  "abababababab";
       STrie st = new STrie(text+"$");
       List<Integer> result = st.locate("a");
       for (int i=0;i<text.length();i+=2){
         assertTrue(result.contains(i));
       }
       result = st.locate("b");
       for (int i=1;i<text.length();i+=2){
         assertTrue(result.contains(i));
       }
     }

     @Test
     public void fraseLocationSTrie()
     {
       String text =  "gran pecador gran pecador con la solteera";
       STrie st = new STrie(text+"$");
       List<Integer> result = st.locate("gran pecador");
       assertTrue(result.contains(0));
       assertTrue(result.contains(13));
       assertEquals(2,result.size());
     }

     @Test
     public void allLocationsEmptyArgSTrie()
     {
       String text =  "una noche en la playa owoo, vamoh a pasarla bien, de esta no te salvas, o nooo, vamoh a pasarla bien";
       STrie st = new STrie(text+"$");
       List<Integer> result = st.locate("");
       for(int i=0;i<text.length();i++){
         assertTrue(result.contains(i));
       }
     }
}
