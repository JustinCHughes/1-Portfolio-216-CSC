package Homework.chap3.HW8;

public class DoublyLinkedList {
  private Node head;
  private Node tail;

  public DoublyLinkedList()
  {
    this.head = null;
    this.tail = null;
  }

  // Function to add Chainlink to the end of the linked list
  public void append(String data)
  {
    Node newNode = new Node(data);
    if (head == null)
    {
      head = newNode;
      tail = newNode;
    }
    else
    {
      Node current = head;
      while (current.next != null)
      {
        current = current.next;
      }
      current.next = newNode;
      this.tail = current.next;
      this.tail.prev = current;
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
}