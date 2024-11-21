package Homework.chap3.HW27;

public class Node {
  public String data;
  public Node next;
  public Node prev;

  public Node(String data)
  {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public Node()
  {
    this.data = null;
    this.next = null;
    this.prev = null;
  }
}
