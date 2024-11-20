// Give an algorithm for finding the second-to-last node in a singly linked list
// in which the last node is indicated by a null next reference.

// I have provided two options:
// 1. Assuming the built in Java LinkedList object, there is no inherent next()
//    functionality. But, there is an inherent .size() functionality. This
//    allows me to find the second to last item just using .size() - 2.
// 2. If the built in functions are not allowed, I've also added a second set
//    of logic which uses a LinkedList class that was manually generated as
//    opposed to the built in functionality.
//    I have imported the code I used in the homework assignment for CSC 214
//    for linked lists to use this as the basis of the adjusted code.
//    This functionality allows for .next functionality. This one will check
//    if .next.next is null. When that occurs, it will output that the current
//    value is the second to last one.
//
// Note: I did not include functionality to check if these items had enough
//       elements to determine if utilize .next.next functionality as this
//       was not part of the question.

package Homework.chap3.HW6;
import java.util.LinkedList;

public class HW3116 {
  public static void main(String[] args)
  {
    LinkedList<String> list = new LinkedList<String>();

    list.add("One");
    list.add("Two");
    list.add("Three");
    list.add("Four");
    list.add("Five");

    System.out.println("Built in Functions: " + secondToLastBuiltIn(list));

    ManLinkedList manList = new ManLinkedList();
    
    ChainLink linkOne = new ChainLink("red");
    ChainLink linkTwo = new ChainLink("blue");
    ChainLink linkThree = new ChainLink("green");

    manList.append(linkOne);
    manList.append(linkTwo);
    manList.append(linkThree);

    System.out.println("Manual Linked List: " + secondtoLastManual(manList));
  }

  public static String secondToLastBuiltIn(LinkedList<String> list)
  {
    String secondToL = list.get(list.size() - 2);
    return secondToL;
  }

  public static String secondtoLastManual(ManLinkedList listed)
  {
    int i = 0;
    while(listed.get(i).next.next != null)
    {
      i++;
    }
    return listed.get(i).data.color;
  }
}