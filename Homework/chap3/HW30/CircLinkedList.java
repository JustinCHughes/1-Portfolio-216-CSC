package Homework.chap3.HW30;

public class CircLinkedList {
  private Node tail;
  private int size;

  public CircLinkedList()
  {
    this.tail = null;
    this.size = 0;
  }

  // Function to add Chainlink to the end of the linked list
  public void append(String data)
  {
    Node newNode = new Node(data);
    if(this.tail == null)
    {
      this.tail = newNode;
      this.tail.next = newNode;
    }
    newNode.next = this.tail.next;
    this.tail.next = newNode;
    this.tail = newNode;
    this.size++;
  }

  // Retrieves the data at a given linked list index
  public Node get(int i)
  {
    if(i < 0)
    {
      return null;
    }
    
    Node current = tail.next;
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

  public Node getTail()
  {
    return this.tail;
  }

  public int getSize()
  {
    return this.size;
  }

  public void setTail(Node newTail)
  {
    newTail.next = this.tail.next;
    this.tail = newTail;
    this.size = this.size / 2;
  }

  public void rotate(int rotations)
  {
    for(int i = 0; i < rotations; i++)
    {
      this.tail = this.tail.next;
    }
  }

  public void print()
  {
    for(int i = 0; i < this.size; i++)
    {
      System.out.print(this.get(i).data + " ");
    }
    System.out.println();
  }
}
