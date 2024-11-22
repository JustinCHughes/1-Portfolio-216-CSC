package labs.chap3.LAB38;

public class Node {
  public int score;
  public String player;
  public Node next;
  public Node prev;

  public Node(int score, String player)
  {
    this.score = score;
    this.player = player;
    this.next = null;
    this.prev = null;
  }

  public Node()
  {
    this.score = -1;
    this.player = null;
    this.next = null;
    this.prev = null;
  }
}
