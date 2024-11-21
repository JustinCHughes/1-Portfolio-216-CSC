// Suppose you are given two circularly linked lists, L and M. Describe an
// algorithm for telling if L and M store the same sequence of elements
// (but perhaps with different starting points).

// Referenced code can be found below in method equal()
// Below description is just the comments pulled out of the code
// Please reference the below code for more context

// 1. Check for size equivalency
// If the two loops are of different size, it will instantly return false

// 3. Start a while loop that continues as long as all starting positions
// where the values are equivalent haven't been tested. Var int rotations
// and var boolean bool to test for equivalency and amount of rotations
// are created to keep track of if while loop should continue or be escaped
// While loop continues as long as rotations are less than the
// overall size of the list

// 4. If statement checks if items in position 0 are equivalent. If they are
// not, a rotation is done and rotations is incremented

// 5. If if statement came back true, it will iterate over a for loop
// checking if the remaining circularly linked list is equal. If it comes
// across an unequal one, it rotates, increments rotations and breaks out
// of the for loop to continue with the while loop

// 6. An if statement will check if bool has made it out of the for loop
// still true at which point it will return true. If the while loop terminates
// due to rotations not longer being less than size, function will return
// false

package Homework.chap3.HW29;

public class HW29 {
  public static void main(String[] args)
  {
    CircLinkedList list = new CircLinkedList();
    CircLinkedList list2 = new CircLinkedList();
    CircLinkedList list3 = new CircLinkedList();

    list.append("One");
    list.append("Two");
    list.append("Three");
    list.append("Four");

    // Create list2 where things are rotated once
    list2.append("Two");
    list2.append("Three");
    list2.append("Four");
    list2.append("One");

    // Create list3. Same elements, wrong order
    list3.append("One");
    list3.append("Three");
    list3.append("Two");
    list3.append("Four");

    System.out.println("Rotated once should be equal: " + equal(list, list2));

    list2.append("Five");
    System.out.println("Extra element should be false: " + equal(list, list2));
    System.out.println("Wrong order should be false: " + equal(list, list3));
  }

  public static boolean equal(CircLinkedList x, CircLinkedList y)
  {
    // If the two loops are of different size, it will instantly return false
    if(x.getSize() != y.getSize())
    {
      return false;
    }
    
    // Keeps track of how many rotations have been checked and boolean
    // initializes that will later be used to check if still equal
    int rotations = 0;
    boolean bool = false;

    // While loop continues as long as rotations are less than the
    // overall size of the list
    while(rotations < x.getSize())
    {
      // If items in position 0 are not equal, it rotates the data and
      // increments rotations
      if(!x.get(0).data.equals(y.get(0).data))
      {
        y.rotate(1);
        rotations++;
      }

      // If items are equal, it proceeds to check if remaining items are
      // equal in the order they are added
      else
      {
        bool = true;
        for(int i = 0; i < x.getSize(); i++)
        {
          // If the data does not equate each other, it rotates once
          // increments rotations, changes bool to false and breaks the
          // for loop
          if(!x.get(i).data.equals(y.get(i).data))
          {
            y.rotate(1);
            rotations++;
            bool = false;
            break;
          }
        }
      }
      // If it gets out of the for loop and is still true, it returns true
      if(bool == true)
      {
        return true;
      }
    }
    return false;
  }
}
