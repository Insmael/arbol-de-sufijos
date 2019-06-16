package com.mycompany.utils;

import java.util.List;

public class Str {
  public static int containsAt(String word, List<String> wordList){
    for (int j = 0; j < wordList.size(); j++){
      String anotherWord = wordList.get(j);
      for (int i = 0; i<anotherWord.length(); i++){
        if (anotherWord.charAt(i) != word.charAt(i)){
          break;
        }
        if (i==anotherWord.length()-1){
          return j;
        }
      }
    }
    return -1;
  }

  public static int containsLength(String word, String anotherWord){
    for(int i = 0; i<anotherWord.length();i++){
      if (anotherWord.charAt(i) != word.charAt(i)){
        return i+1;
      }
    }
    return  anotherWord.length();
  }
}
