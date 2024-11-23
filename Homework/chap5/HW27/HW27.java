// Give a recursive definition of a singly linked list class that does
// not use any Node class.

// Please reference RecursiveLinkedList for full code

package Homework.chap5.HW27;

public class HW27 {
  public static void main(String[] args)
  {
    RecursiveLinkedList list = new RecursiveLinkedList(0);
    list.append(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);
    list.append(6);

    // Testing that print works and that all values were appended
    list.print();
    System.out.println();

    // Testing getSize()
    System.out.println("getSize() should be 7: " + list.getSize());
    System.out.println();

    // Testing search
    System.out.println("search(0): " + list.search(0));
    System.out.println("search(6): " + list.search(6));
    System.out.println("search(10): " + list.search(10));
  }
}
