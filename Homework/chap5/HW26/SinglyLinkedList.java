package Homework.chap5.HW26;

public class SinglyLinkedList {
  private Node head;
  private Node tail;
  private int size;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void append(String data)
  {
    Node newNode = new Node(data);
    if(this.head == null)
    {
      this.head = newNode;
      this.tail = newNode;
      this.size = 0;
    }
    else
    {
      this.tail.next = newNode;
      this.tail = newNode;
      this.size++;
    }
  }

  public int getSize()
  {
    return this.size;
  }

  public Node getHead()
  {
    return this.head;
  }

  public void setHead(Node newHead)
  {
    this.head = newHead;
  }

  public Node getTail()
  {
    return this.tail;
  }

  public void setTail(Node newTail)
  {
    this.tail = newTail;
  }

  public void print()
  {
    Node current = this.head;
    while(current != null)
    {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  public Node get(int i)
  {
    if(i < 0)
    {
      return null;
    }

    Node current = head;
    int count = 0;

    while(current != null)
    {
      if(count == i)
      {
        return current;
      }
      current = current.next;
      count++;
    }

    return null;
  }
}
