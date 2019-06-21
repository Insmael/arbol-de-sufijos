package com.mycompany.util;

import java.util.List;
import java.util.ArrayList;

public class Cronometer {
  List<String> msgs;
  List<Long> times;
  Long start;

  public Cronometer(){
    msgs = new ArrayList<String>();
    times = new ArrayList<Long>();
    start = System.nanoTime();
  }

  public void tick(){
    start = System.nanoTime();
  }
  public void tic(){
    this.tick();
  }

  public void tack(String msg){
    times.add(System.nanoTime()-start);
    msgs.add(msg);
  }
  public void tac(String msg){
    this.tack(msg);
  }

  public String getLastMsg(){
    return msgs.get(msgs.size()-1);
  }

  public long getLastTime(){
    return times.get(times.size()-1);
  }

  public List<String> getMsgs(){
    return msgs;
  }

  public List<Long> getTimes(){
    return times;
  }

}
