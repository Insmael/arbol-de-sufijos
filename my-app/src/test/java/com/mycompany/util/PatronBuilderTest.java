package com.mycompany.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class PatronBuilderTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void buildTest()
    {
      String text = "uno dos tres cuatro cinco seis siete ocho nueve diez";
      List<String> words = PatronBuilder.build(text);
      int decimo = text.length()/10;
      assertEquals(decimo,words.size());
    }
}
