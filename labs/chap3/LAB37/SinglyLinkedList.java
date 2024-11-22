package labs.chap3.LAB37;

public class SinglyLinkedList {
  private Node head;
  private int size;

  // Initializes SinglyLinkedList with null head and size 0
  public SinglyLinkedList()
  {
    this.head = null;
    this.size = 0;
  }

  // Function to add Node into leaderboard if they are within the top 10
  // scores
  public void add(int score, String player)
  {
    Node newNode = new Node(score, player);

    // If the head is null, the newNode is automatically put into the
    // position of head
    if (head == null)
    {
      this.head = newNode;
      this.size = 1;
    }

    // If the newNode score is higher than the head's score then newNode
    // replaces current head
    else if(this.head.score < newNode.score)
    {
      newNode.next = this.head;
      this.head = newNode;
      this.size++;
    }
    else
    {
      int i = 0;
      Node prevNode = this.head;
      Node current = this.head;
      // Traverses the list until i is larger than size of linked list
      while(i < this.size)
      {
        // We know it is not greater than the head since it didn't trigger
        // the previous else if statement so we start a current.next
        current = current.next;

        // If the next node doesn't exist, it adds the value to the list
        // increments the size and breaks out of the while loop
        if(current == null)
        {
          prevNode.next = newNode;
          this.size++;
          break;
        }

        // If newNode's score is higher than current, prevNode.next is set
        // to newNode and newNode.next is set to current. Size is incremented
        // and then we break out of the while loop
        else if(current.score < newNode.score)
        {
          prevNode.next = newNode;
          newNode.next = current;
          this.size++;
          break;
        }

        // We move prevNode to current. At the start of the next while loop
        // current is moved to the next node as well
        prevNode = current;
        i++;
      }
    }
    // If size is 10 or greater, we grab the node at 10th place and
    // change it's .next pointer to null then decrement the size
    if(this.size > 10)
    {
      this.get(9).next = null;
      size--;
    }
  }

  // Removes a node from the linked list
  public void remove(int score, String player)
  {
    Node removalNode = new Node(score, player);

    // Checks if both the score and the player name to ensure that
    // the correct node is being removed
    if(this.head.score == removalNode.score
      && this.head.player.equals(removalNode.player))
    {
      // Creates temp node pointing to the head
      Node tempNode = this.head;
      
      // this.head now points to the seoncd node
      this.head = this.head.next;

      // Previous head node has their next pointer deleted and this.size
      // is decremented
      tempNode.next = null;
      this.size--;
    }

    else
    {
      Node prevNode = this.head;
      Node current = this.head;
      int i = 0;
      // Continue looking for node as long as i is less than size
      while(i < this.size - 1)
      {
        // We know it is not the head node because it did not trigger
        // the previous if statement so start at current.next
        current = current.next;

        // Check if current node is the one you're looking for
        if(current.score == removalNode.score
            && current.player.equals(removalNode.player))
        {
          // Previous node's .next is set to current.next's .next so that
          // nothing is pointing to this node anymore and current.next
          // is set to null. Then size is decremented and while loop
          // is broken
          prevNode.next = current.next;
          current.next = null;
          this.size--;
          break;
        }

        // If nothing is found, prevNode is set to current. current is moved
        // to current.next at the top of the while loop
        prevNode = current;
        i++;
      }
    }
  }

  // Retrieves the score at a given linked list index
  public Node get(int i)
  {
    // Return null if given negative value
    if(i < 0)
    {
      return null;
    }
    
    Node current = head;
    int count = 0;

    // Traverses list until we get to stated index or current is null
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

  // Gets head of linked list
  public int getSize()
  {
    return this.size;
  }

  // Prints the linked list
  public void print()
  {
    for(int i = 0; i < this.size; i++)
    {
      System.out.printf("%2d. ", i + 1);
      System.out.printf("%-15s", this.get(i).player);
      System.out.print(" - ");
      System.out.printf("%6d\n", this.get(i).score);
    }
    System.out.println();
  }
}