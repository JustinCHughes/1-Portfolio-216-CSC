// Describe a fast recursive algorithm for reversing a singly linked list
// L, so that the ordering of the nodes becomes opposite of what it was before.

// Reference code below for context
// 1. Our base case is if head.next is null. Here, we will call the
//    list.setHead(head) function so that the last item becomes the new head.
// 2. We hold the head.next in a tempNode.
// 3. We call recursively down to the end of the linkedlist until the new
//    head is set and we return.
// 4. The tempNode where we held the reference to the next node has its
//    .next pointer set to current node.
// 5. We then set the current node to the tail. This will eventually go back
//    up to the top call and the first node is set to the tail finishing
//    up reversing the linked list

package Homework.chap5.HW26;

public class HW26 {
  public static void main(String[] args)
  {
    SinglyLinkedList list = new SinglyLinkedList();

    list.append("One");
    list.append("Two");
    list.append("Three");
    list.append("Four");
    list.append("Five");
    list.append("Six");

    System.out.println("Print Forwards: ");
    list.print();
    reverse(list, list.getHead());
    System.out.println("Print Backwards: ");
    list.print();
  }

  public static void reverse(SinglyLinkedList list, Node head)
  {
    if(head.next == null)
    {
      list.setHead(head);
      return;
    }
    Node tempNode = head.next;
    head.next = null;
    reverse(list, tempNode);
    tempNode.next = head;
    list.setTail(head);
  }
}
