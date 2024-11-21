// Describe an algorithm for concatenating two singly linked lists L and M,
// into a single list L that contains all the nodes of L followed by all
// the nodes of M.

// In the below answer, I created a merge function which traverses the
// SinglyLinkedList M and appends each value to the end of SinglyLinkedList L
// Here, I used my own LinkedList class, and it traverses the function
// by using the external variable of i to know how many times it must go
// .next and then append. After all the appends are done from M to L, it
// returns L.

package Homework.chap3.HW25;

public class HW25 {
  public static void main(String[] args)
  {
    SinglyLinkedList L = new SinglyLinkedList();
    SinglyLinkedList M = new SinglyLinkedList();

    L.append("LOne");
    L.append("LTwo");
    L.append("LThree");

    M.append("MOne");
    M.append("MTwo");
    M.append("MThree");

    merge(L,M);

    for(int i = 0; i < L.getSize(); i++)
    {
      System.out.print(L.get(i).data + " ");
    }
    System.out.print("\n");
  }

  public static SinglyLinkedList merge(SinglyLinkedList L, SinglyLinkedList M)
  {
    for(int i = 0; i < M.getSize(); i++)
    {
      L.append(M.get(i).data);
    }
    return L;
  }
}
