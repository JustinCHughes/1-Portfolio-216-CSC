package Homework.chap3.HW6;

public class ManLinkedList {
  private Node head;

  public ManLinkedList()
  {
    this.head = null;
  }

  // Function to add Chainlink to the end of the linked list
  public void append(ChainLink data)
  {
    Node newNode = new Node(data);
    if (head == null)
    {
      head = newNode;
    }
    else
    {
      Node current = head;
      while (current.next != null)
      {
        current = current.next;
      }
      current.next = newNode;
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
}