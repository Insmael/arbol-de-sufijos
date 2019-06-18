package com.mycompany.datastructures;

import java.util.List;

public interface ITrie {
  abstract public void insert(String word);
  abstract public void insert(List<String> words);
  abstract public Boolean search(String word);
  abstract public int countWord(String word);
  abstract public int countPreffix(String word);
}
