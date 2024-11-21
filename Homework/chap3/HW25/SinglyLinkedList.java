package Homework.chap3.HW25;

public class SinglyLinkedList {
  private Node head;
  private Node tail;
  private int size;

  public SinglyLinkedList()
  {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // Function to add Chainlink to the end of the linked list
  public void append(String data)
  {
    Node newNode = new Node(data);
    if (head == null)
    {
      this.head = newNode;
      this.tail = newNode;
      this.size = 1;
    }
    else
    {
      this.tail.next = newNode;
      this.tail = newNode;
      this.size++;
    }
  }

  // Retrieves the data at a given linked list index
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