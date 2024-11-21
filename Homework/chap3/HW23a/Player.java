package Homework.chap3.HW23a;

import java.util.HashSet;

public class Player {
  private HashSet<Integer> met;
  private final int player;
  private int score;

  public Player(int player)
  {
    HashSet<Integer> met = new HashSet<>();
    this.player = player;
    this.score = 0;
    this.met = met;
  }

  public int getPlayer()
  {
    return this.player;
  }

  public int getScore()
  {
    return this.score;
  }

  public HashSet<Integer> getMet()
  {
    return this.met;
  }

  public void meeting(int j)
  {
    if(met.add(j))
    {
      this.score += 1;
    }
  }
};