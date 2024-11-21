// Give an algorithm for concatenating two doubly linked lists L and M, with
// header and trailer sentinel nodes, into a single list L.

// This is largely the same logic that is used in the previous HW25.
// The only difference is the way the size of the doubly linked list is
// handled. In this case, I do not count the sentry nodes as part of the
// linked list when traversing it so that it doesn't get appended to the first
// list. Instead of starting at head, it starts traversing at head.next.
// The size also does not include the sentry nodes in the calculation for
// size of the doubly linked list.

package Homework.chap3.HW26;

public class HW26 {

  public static void main(String[] args)
  {
    DoublyLinkedList L = new DoublyLinkedList();
    DoublyLinkedList M = new DoublyLinkedList();

    L.append("LOne");
    L.append("LTwo");
    L.append("LThree");

    M.append("MOne");
    M.append("MTwo");
    M.append("MThree");
    M.append("MFour");

    merge(L,M);

    for(int i = 0; i < L.getSize(); i++)
    {
      System.out.print(L.get(i).data + " ");
    }
    System.out.print("\n");
  }

  public static DoublyLinkedList merge(DoublyLinkedList L, DoublyLinkedList M)
  {
    for(int i = 0; i < M.getSize(); i++)
    {
      L.append(M.get(i).data);
    }
    return L;
  }
}
