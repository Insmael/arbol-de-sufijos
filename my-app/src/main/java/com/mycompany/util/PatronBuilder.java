package com.mycompany.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class PatronBuilder {
  List<String> patrones;

  public PatronBuilder(String text){
    int l = text.length();
    int n = l/10;
    int i = 0;
    int startpos, endpos;
    int randpos = 0;
    Random randomGen =new Random();
    randomGen.setSeed(12);

    while (i<n){
      // random number between 0 y l-1
      randpos = randomGen.nextInt(l);
      if(text.charAt(randpos)==' ' && randpos<l-1){
        startpos = randpos+1;
      } else{
        startpos = randpos-1;
        while(startpos>0){
          if(text.charAt(startpos) == ' '){
            startpos++;
            break;
          }
          startpos--;
        }
      }
      for (endpos = startpos;endpos<l;endpos++){
        if(text.charAt(endpos) == ' '){
          break;
        }
      }
      patrones.add(text.substring(startpos,endpos));
      i++;
    }
  }

  public List<String> getPatrones(){
    return this.patrones;
  }
}
