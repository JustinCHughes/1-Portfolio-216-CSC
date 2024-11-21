// Describe in detail how to swap two nodes x and y (and not just their
// contents) in a singly linked list L given references only to x and y.
// Repeat this exercise for the case when L is a doubly linked list.
// Which algorithm takes more time?

// Singly Linked List Swap.
// Please reference swapSingle method for actual code
// First, I ensure that x and y are not equal and being asked to be swapped
// with itself.
// Second, I grab the current x and y nodes and put them into curr variables
// Third, I need to determine if x or y is a head of the singly linked list.
// If either of them is the head, I need to set a new head accordingly.
// Fourth, I swap the pointers TO the nodes first.
// Fifth, I swap the .next pointers the nodes have. After this the nodes are
// officially swapped

// Double Linked List Swap
// Please reference swapDouble method for actual code
// First, I ensuyre that x and y are not equal and being asked to tbe swapped
// with itself
// Second, I grab the current x and y nodes and put them into curr variables
// as well as their respective prev variables
// Third, I swap the prev and next pointers for X and Y nodes
// Fourth, I create a temp node and swap the next pointers
// Fifth, because next is now set, I can call .next.prev to set surrounding
// prev variables

// I believe the Singly Linked List Swap takes more time
// The Doubly Linked List only needed to find the two nodes in question and
// then we found prev and next from the pointers there to begin the swaps.
// The Singly Linked List, I needed to iterate over the lists to find the
// nodes in question as well as the previous nodes. This leads to two more
// instances of iteration. Thus, Doubly Linked Lists are more efficient
// for node swapping

package Homework.chap3.HW27;

public class HW27 {
  public static void main(String[] args)
  {
    SinglyLinkedList L = new SinglyLinkedList();
    DoublyLinkedList M = new DoublyLinkedList();

    L.append("LOne");
    L.append("LTwo");
    L.append("LThree");
    L.append("LFour");

    M.append("MOne");
    M.append("MTwo");
    M.append("MThree");
    M.append("MFour");

    int swap1 = 0;
    int swap2 = 3;
    swapSingle(L, swap1, swap2);
    swapDouble(M, swap1, swap2);

    // Traverse SinglyLinkedList forwards using .get()
    for(int i = 0; i < L.getSize(); i++)
    {
      System.out.print(L.get(i).data + " ");
    }
    System.out.println();

    // Traverse DoublyLinkedList forwards using .get()
    for(int i = 0; i < M.getSize(); i++)
    {
      System.out.print(M.get(i).data + " ");
    }
    System.out.println();

    // Traverse DoublyLinkedList backwards using .getReverse()
    for(int i = M.getSize() - 1; i > -1; i--)
    {
      System.out.print(M.getReverse(i).data + " ");
    }
    System.out.println();

  }

  public static void swapSingle(SinglyLinkedList L, int x, int y)
  {
    if(x != y)
    {
      // Grabbing current node references
      // Cannot initially grab prevX and prevY because unknown if they are the
      // head of the singlylinkedlist and thus do not have a prev
      Node currX = L.get(x);
      Node currY = L.get(y);

      // Determine if i or j are the head
      if(x == 0)
      {
        // Grab prevY only because I is head
        Node prevY = L.get(y - 1);

        // Swap the positions in terms of nodes that point to them
        prevY.next = currX;
        L.setHead(currY);
      }
      else if (y == 0)
      {
        // Grab prevX only because J is head
        Node prevX = L.get(x - 1);

        // Swap the positions in terms of nodes that point to them
        prevX.next = currY;
        L.setHead(currX);
      }
      else
      {
        // Same logic as above except neither is the head so it can
        // proceed without setting a new head
        Node prevY = L.get(y - 1);
        Node prevX = L.get(x - 1);
        prevX.next = currY;
        prevY.next = currX;
      }

      // Create a holder for currX.next as it is swapped
      // Change what the swapped nodes points to
      Node temp = currX.next;
      currX.next = currY.next;
      currY.next = temp;
    }
  }

  public static void swapDouble(DoublyLinkedList M, int x, int y)
  {
    if(x != y)
    {
      Node currY = M.get(y);
      Node prevY = currY.prev;
  
      Node currX = M.get(x);
      Node prevX = currX.prev;
  
      // Swap next and prev pointers
      prevX.next = currY;
      currY.prev = prevX;
  
      prevY.next = currX;
      currX.prev = prevY;
  
      // Swap next pointers of x and y
      Node temp = currX.next;
      currX.next = currY.next;
      currY.next = temp;
  
      // Can just call .next.prev to curr instead since .next swaps are done
      currX.next.prev = currX;
      currY.next.prev = currY;
    }
  }
}
