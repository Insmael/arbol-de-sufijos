package com.mycompany.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PreprocesorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void ProcessEmptyText()
    {
      String text  = "";
      Preprocesor pp = new Preprocesor();
      pp.addStrToRemove("a");
      pp.addStrToRemove("b");
      pp.addStrToRemove("c");
      String procesedText = pp.process(text);
      assertTrue(procesedText.equals(""));
    }

    @Test
    public void remove_a_Text()
    {
      String text  = "eran las 7 eh laa mañana, y uno por uno al matadero";
      Preprocesor pp = new Preprocesor();
      pp.addStrToRemove("a");
      String procesedText = pp.process(text);
      assertTrue(procesedText.equals("ern ls 7 eh l mñn, y uno por uno l mtdero"));
    }

    @Test
    public void remove_vocals_Text()
    {
      String text  = "Buscando visa la razon de ser, buscando visa la razon de ser";
      Preprocesor pp = new Preprocesor();
      pp.addStrToRemove("a");
      pp.addStrToRemove("e");
      pp.addStrToRemove("i");
      pp.addStrToRemove("o");
      pp.addStrToRemove("u");
      String procesedText = pp.process(text);
      assertTrue(procesedText.equals("bscnd vs l rzn d sr, bscnd vs l rzn d sr"));
    }

    @Test
    public void remove_newlines_Text()
    {
      String text  = "Buscando\n visa\n la\n ra\nzon d\ne ser\n, b\nuscan\ndo visa la raz\non d\n\ne \nser\n";
      Preprocesor pp = new Preprocesor();
      pp.addStrToRemove("\n");
      String procesedText = pp.process(text);
      assertTrue(procesedText.equals("buscando visa la razon de ser, buscando visa la razon de ser"));
    }

    @Test
    public void compress_space_Text()
    {
      String text  = "Tengo    un    dios    admirado     en     los    cielos, que me libra de mal y temores";
      Preprocesor pp = new Preprocesor();
      String procesedText = pp.process(text);
      assertTrue(procesedText.equals("tengo un dios admirado en los cielos, que me libra de mal y temores"));
    }

    @Test
    public void compress_space_and_remove_vocals_Text()
    {
      String text  = "Tengo    un    dios    admirado     en     los    cielos, que me libra de mal y temores";
      Preprocesor pp = new Preprocesor();
      pp.addStrToRemove("a");
      pp.addStrToRemove("e");
      pp.addStrToRemove("i");
      pp.addStrToRemove("o");
      pp.addStrToRemove("u");
      String procesedText = pp.process(text);
      assertTrue(procesedText.equals("tng n ds dmrd n ls cls, q m lbr d ml y tmrs"));
    }

    @Test
    public void expectedFormatOfText()
    {
      String text  = "There .Are SOme shite; things .  in this  awero,o.";
      Preprocesor pp = new Preprocesor();
      pp.defaultTextSet();
      String procesedText = pp.process(text);
      assertTrue(procesedText.equals("there are some shite things in this aweroo"));
    }
}
