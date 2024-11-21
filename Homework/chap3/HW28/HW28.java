// Describe in detail an algorithm for reversing a singly linked list
// using only a constant amount of additional space.

// Here, we reverse the SinglyLinkedList by using three Node variables.
// We have prev, current, and nextNode. prev holds the Node in the prev
// position before we traverse, current holds current position, and
// nextNode holds the pointer to the next node so we can move to it after
// we change current.next.

// In the while loop in the code, we first traverse nextNode to current.next
// to ensure that we do not lose that node. Then, we set current.next to prev.
// prev is then set to current because this will be the prev node in the next
// while loop iteration. current is set to nextNode where we saved the old
// current.next pointer's node. Assuming current still does not equal null,
// this process repeats until the whole linked list is reversed.

package Homework.chap3.HW28;

public class HW28 {
  public static void main(String[] args)
  {
    SinglyLinkedList list = new SinglyLinkedList();

    list.append("One");
    list.append("Two");
    list.append("Three");
    list.append("Four");
    list.append("Five");

    reverse(list);
    
    for(int i = 0; i < list.getSize(); i++)
    {
      System.out.println(list.get(i).data);
    }
  }

  public static void reverse(SinglyLinkedList list)
  {
    // Create three pointers
    // Prev will hold the previous pointer, current will hold where we will
    // be adjusting the .next pointer. nextNode will hold the place of the
    // .next before we change the pointer
    Node prev = new Node();
    Node current = list.getHead();
    Node nextNode;

    while(current != null)
    {
      nextNode = current.next;
      current.next = prev;
      prev = current;
      current = nextNode;
    }
    list.setHead(prev);
  }
}
