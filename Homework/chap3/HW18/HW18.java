// Let B be an array of size n >= 2 containing integers from 1 to n - 5
// inclusive, exactly five of which are repeated. Describe an algorithm for
// finding the five integers in B that are repeated. As an example, with n = 12,
// we are given 12 integers, each from 1 to 7, and if
// B = [5,2,6,3,2,7,1,5,4,4,7,1] the goal is to identify that numbers
// [1,2,4,5,7] were the repeated ones.

// This will build upon the same logic that was used for Homework problem 17.
// Using the same HashSet logic from the previous problem, instead of simply
// returning, we are going to add the values that trip the .add function to
// an ArrayList. This ArrayList will then be returned as the duplicated items.
// This part of the answer only does one passthrough and is thus O(n)

// The answer as prompted in the question returned the list ordered. Because of
// the random nature of the inputs, quicksort would likely be the best option
// here. I, however, admittedly do not have the greatest understanding of
// quicksort. I assume this will be covered later in the class and will
// address this then. For now, I have implemented a bubble sort since the 
// list is fairly short and implementing this involved the least amount of
// work.

package Homework.chap3.HW18;

import java.util.ArrayList;
import java.util.HashSet;

public class HW18 {
  public static void main(String[] args)
  {
    int[] B = {5,2,6,3,2,7,1,5,4,4,7,1};

    System.out.println(BubbleSort.bubbleSort(findDups(B)));

  }

  public static ArrayList<Integer> findDups(int[] nums)
  {
    HashSet<Integer> set = new HashSet<>();
    ArrayList<Integer> dups = new ArrayList<>();

    for(int element : nums)
    {
      if(!set.add(element))
      {
        dups.add(element);
      }
    }

    return dups;
  }
}
