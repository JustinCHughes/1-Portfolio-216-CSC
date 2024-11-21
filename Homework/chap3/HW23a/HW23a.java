// Suppose you are designing a multiplayer game that has n >= 1000 players,
// numbered 1 to n, interacting in an enchanted forest. The winner of this
// game is the first player who can meet all the other players at least once
// (ties are allowed). Assuming that there is a method meet (i,j), which is
// called each time a player i meets a player j (with i =/= j), describe a
// way to keep track of the pairs of meeting players and who is the winner.

// I would create an object named Player.java This object would contain
// its own player number as well as a HashSet that houses all the numbers of
// the players that it has met. Every time a new player is met, this would
// trigger an if statement that increments the score. Once a player reaches
// a score of 999, the game would end. If two players reach 999 at the same time
// the game would end and declare a draw.

package Homework.chap3.HW23a;

import java.util.Random;

public class HW23a {
  public static void main(String args[])
  {
    Player[] plays = new Player[1000];
    for(int i = 1, j = 0; i < 1001; i++, j++)
    {
      plays[j] = new Player(i);
    }

    Random rand = new Random();
    int randP1;
    int randP2;
    int winner = 0;

    while(true)
    { 
      randP1 = rand.nextInt(1000);
      randP2 = rand.nextInt(1000);

      // Meeting calls n+1 because index 0 is equal to player 1. So all player
      // numbers are offset by 1
      if(meet(randP1, randP2))
      {
        plays[randP1].meeting(randP2 + 1);
        plays[randP2].meeting(randP1 + 1);
      }
      
      // Checks if two players have reached victory at the same time
      // then breaks the while loop if that has happened.
      // Winner is set to 10001 to signify a dual winner because this is
      // not a possible player
      if(plays[randP1].getScore()==999 && plays[randP2].getScore()==999)
      {
        winner = -1;
        break;
      }
      // Checks if player randP1 or randP2 have individually won and then
      // sets winner to them and breaks the loop.
      else if(plays[randP2].getScore()==999)
      {
        winner = randP2;
        break;
      }
      else if(plays[randP1].getScore()==999)
      {
        winner = randP1;
        break;
      }
    }

    // Declares a tie between two players if there is a draw.
    if(winner == -1)
    {
      System.out.println("There was a draw between "+plays[randP1].getPlayer());
      System.out.print(" and " + plays[randP2].getPlayer() + "!");
    }
    // States the plays[winner] as the winner
    else
    {
      System.out.println("Player " + plays[winner].getPlayer() + " has won!");
    }
  }

  // Checks if player i and player j are the same player
  public static Boolean meet(int i, int j)
  {
    if(i != j)
    {
      return true;
    }
    return false;
  }
}
