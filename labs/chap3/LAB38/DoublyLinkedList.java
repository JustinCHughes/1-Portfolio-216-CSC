package labs.chap3.LAB38;

public class DoublyLinkedList {
  private Node head;
  private Node tail;
  private int size;

  // Initializes SinglyLinkedList with null head and size 0
  public DoublyLinkedList()
  {
    Node sentryHeadNode = new Node();
    Node sentryTailNode = new Node();

    this.head = sentryHeadNode;
    this.tail = sentryTailNode;
    this.size = 0;
  }

  // Function to add Node into leaderboard if they are within the top 10
  // scores
  public void add(int score, String player)
  {
    Node newNode = new Node(score, player);

    // If the head is null, the newNode is automatically put into the
    // position of head
    if (this.head.next == null)
    {
      this.tail.prev = newNode;
      this.head.next = newNode;
      newNode.next = this.tail;
      newNode.prev = this.head;
      this.size = 1;
    }

    // If the newNode score is higher than the head's score then newNode
    // replaces current head
    else if(this.head.next.score < newNode.score)
    {
      newNode.next = this.head.next;
      newNode.prev = this.head;
      newNode.next.prev = newNode;
      newNode.prev.next = newNode;
      this.size++;
    }
    else
    {
      int i = 0;
      Node prevNode = this.head.next;
      Node current = this.head.next;
      // Traverses the list until i is larger than size of linked list
      while(i < this.size)
      {
        // We know it is not greater than the head since it didn't trigger
        // the previous else if statement so we start a current.next
        current = current.next;

        // If the next node doesn't exist, it adds the value to the list
        // increments the size and breaks out of the while loop
        if(current == this.tail)
        {
          newNode.next = this.tail;
          newNode.prev = prevNode;
          newNode.next.prev = newNode;
          newNode.prev.next = newNode;
          this.size++;
          break;
        }

        // If newNode's score is higher than current, prevNode.next is set
        // to newNode and newNode.next is set to current. Size is incremented
        // and then we break out of the while loop
        else if(current.score < newNode.score)
        {
          newNode.next = current;
          newNode.prev = prevNode;
          newNode.next.prev = newNode;
          newNode.prev.next = newNode;
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
      Node tempNode = this.tail.prev;
      this.tail.prev = tempNode.prev;
      this.tail.prev.next = this.tail;
      tempNode.prev = null;
      tempNode.next = null;
      size--;
    }
  }

  // Removes a node from the linked list
  public void remove(int score, String player)
  {
    Node removalNode = new Node(score, player);

    // Checks if both the score and the player name to ensure that
    // the correct node is being removed
    if(this.head.next.score == removalNode.score
      && this.head.next.player.equals(removalNode.player))
    {
      // Creates temp node pointing to the head.next
      Node tempNode = this.head.next;
      
      // this.head now points to the second node
      this.head.next = tempNode.next;
      this.head.next.prev = this.head;

      // Previous head node has their next pointer deleted and this.size
      // is decremented
      tempNode.next = null;
      tempNode.prev = null;
      this.size--;
    }

    // Checks if score is equivalent to the last node before sentry node
    else if(this.tail.prev.score == removalNode.score
      && this.tail.prev.player.equals(removalNode.player))
    {
      // Creates temp node pointing to the tail.prev
      Node tempNode = this.tail.prev;

      // this.tail now points to the second to last node
      this.tail.prev = tempNode.prev;
      this.tail.prev.next = this.tail;

      // Previous last node has pointers remove and size is decremented
      tempNode.next = null;
      tempNode.prev = null;
      this.size--;
    }

    else
    {
      // To ensure we are getting to the end in the most efficient way
      // We are going to try to find the node simultaneously from the
      // front of the doubly linked list and the back. This requires
      // the back and the forwardNode to approach the front from the tail
      // while the front node traverses forward at the same time
      Node prevNode = this.head.next;
      Node front = this.head.next;
      Node forwardNode = this.tail.prev;
      Node back = this.tail.prev;
      int i = 0;
      // Continue looking for node as long as i is less than size / 2
      while(i < this.size / 2)
      {
        // We know it is not the first node because it did not trigger
        // the previous if statement so start at current.next
        // For the same reasoning, we know it is not the last node before
        // the tail
        front = front.next;
        back = back.prev;

        // Check if current node is the one you're looking for
        if(front.score == removalNode.score
            && front.player.equals(removalNode.player))
        {
          // Previous node's .next is set to current.next's .next so that
          // nothing is pointing to this node anymore and current.next
          // is set to null. Then size is decremented and while loop
          // is broken
          prevNode.next = front.next;
          prevNode.next.prev = prevNode;
          front.next = null;
          front.prev = null;
          this.size--;
          break;
        }

        // Same logic as above except from the tail side
        else if(back.score == removalNode.score
            && back.player.equals(removalNode.player))
        {
          forwardNode.prev = back.prev;
          forwardNode.prev.next = forwardNode;
          back.next = null;
          back.prev = null;
          this.size--;
          break;
        }

        // If nothing is found, prevNode is set to front and forwardNode is
        // set to back. front and back traverse in the list at the top of
        // the while loop
        prevNode = front;
        forwardNode = back;
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
    
    Node current = head.next;
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

  public void printReverse()
  {
    for(int i = this.size - 1; i > -1; i--)
    {
      System.out.printf("%2d. ", i + 1);
      System.out.printf("%-15s", this.get(i).player);
      System.out.print(" - ");
      System.out.printf("%6d\n", this.get(i).score);
    }
    System.out.println();
  }
}