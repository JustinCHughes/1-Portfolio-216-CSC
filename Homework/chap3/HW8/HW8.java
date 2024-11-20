// Describe a method for finding the middle node of a doubly linked list with
// header and trailer sentinels by "link hopping," and without relying on
// explicit knowledge of the size of the list. In the case of an even number of
// nodes, report the node slightly left of center as the "middle." What is the
// running time of this method?

// The algorithm below named findMid starts at the the head and the tail. It
// then traverses through the list. It checks at each iteration if start or
// start.next is equal to end. It returns when either of these scenarios and
// returns node start. This equation would be O(n) as it approaches the mid
// point from either side. This removes any duplicated work and only requires
// one run through.

package Homework.chap3.HW8;

public class HW8 {
  public static void main(String[] args)
  {
    DoublyLinkedList list = new DoublyLinkedList();

    list.append("One");
    list.append("Two");
    list.append("Three");

    System.out.println("3 Mid: " + findMid(list).data);

    list.append("Four");
    System.out.println("4 Mid: " + findMid(list).data);

    list.append("Five");
    System.out.println("5 Mid: " + findMid(list).data);
  }

  // Finds midpoint Node
  public static Node findMid(DoublyLinkedList list)
  {
    Node start = list.getHead();
    Node end = list.getTail();

    while(true)
    {
      // If start is equal to end, then start is at the midpoint
      // and it is an odd number of items in the linked list
      if(start.equals(end))
      {
        break;
      }
      // If start.next equals end, then it can be assumed there are an odd
      // number of items within the linked list. Thus, it returns start as it
      // is the preceding number as per the questions request
      else if(start.next.equals(end))
      {
        break;
      }
      start = start.next;
      end = end.prev;
    }
    return start;
  }
}
