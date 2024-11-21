package Homework.chap3.HW26;

public class DoublyLinkedList {
  private Node head;
  private Node tail;
  private int size;

  public DoublyLinkedList()
  {
    Node sentryHeadNode = new Node();
    Node sentryTailNode = new Node();

    this.head = sentryHeadNode;
    this.tail = sentryTailNode;
    this.size = 0;
  }

  // Function to add Chainlink to the end of the linked list
  public void append(String data)
  {
    Node newNode = new Node(data);
    if(this.head.next == null)
    {
      this.head.next = newNode;
      this.tail.prev = newNode;
      newNode.prev = this.head;
      newNode.next = this.tail;
    }
    else
    {
      newNode.prev = this.tail.prev;
      newNode.next = this.tail;
      newNode.prev.next = newNode;
      this.tail.prev = newNode;
    }
    this.size += 1;
  }

  // Retrieves the data at a given linked list index
  public Node get(int i)
  {
    if(i < 0)
    {
      return null;
    }
    
    Node current = head.next;
    int count = 0;

    while(current != this.tail)
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

  public Node getHead()
  {
    return this.head;
  }

  public Node getTail()
  {
    return this.tail;
  }

  public int getSize()
  {
    return this.size;
  }
}