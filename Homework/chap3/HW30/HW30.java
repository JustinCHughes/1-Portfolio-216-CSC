// Given a circularly linked list L containing an even number of nodes,
// describe how to split L into two circularly linked lists of half the
// size in interleaved fashion, such that list A,B,C,D,E,F is split into
// lists A,C,E and B,D,F.

// Reference code below in method splitList for context
// 1. Ensure that the list being split is actually even. Return without
// doing anything if it is not even.
// 2. Starting at the size / 2 of list, append items to the targetList
// 3. Call method to set new tail for original list at size / 2 - 1.
// Code for setting new tail is as below:

// public void setTail(Node newTail)
//   {
//     newTail.next = this.tail.next;
//     this.tail = newTail;
//     this.size = this.size / 2;
//   }

package Homework.chap3.HW30;

public class HW30 {
  public static void main(String[] args)
  {
    CircLinkedList list = new CircLinkedList();
    CircLinkedList targetList = new CircLinkedList();

    // Create list's values
    list.append("A");
    list.append("B");
    list.append("C");
    list.append("D");
    list.append("E");
    list.append("F ");
    
    // Call function to split circularly linked list
    splitList(list, targetList);

    // Made my own little print function for this inside the linkedlist
    // class. It was getting redundant re-typing the for loops
    list.print();
    targetList.print();
  }

  public static void splitList(CircLinkedList list, CircLinkedList targetList)
  {
    // Checks if size of list is even. If not, breaks out of method
    if((list.getSize() % 2) != 0)
    {
      return;
    }

    // Appends item to targetList starting at list's size / 2 - 1 which
    // is the halfway point.
    for(int i = (list.getSize() / 2); i < list.getSize(); i++)
    {
      targetList.append(list.get(i).data);
    }

    // List's tail is now set to be list's halfway point - 1
    list.setTail(list.get((list.getSize() / 2) - 1));
  }
}
