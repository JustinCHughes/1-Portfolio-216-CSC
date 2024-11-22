package labs.chap3.LAB37;

public class Node {
  public int score;
  public String player;
  public Node next;

  public Node(int score, String player)
  {
    this.score = score;
    this.player = player;
    this.next = null;
  }
}
