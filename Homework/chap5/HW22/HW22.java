// Given an unsorted array, A, of integers and an integer k, describe
// a recursive algorithm for rearranging the elements in A so that all
// elements less than or equal to k come before any elements larger than
// k. What is the running time of your algorithm on an array of n values?

// Well, the obvious choice here is to just use quicksort since I 
// believe it is the most efficient randomized list sorter and it's
// done recursively. That being said, programming quicksort is really
// really not my strength, so I'll wait until that gets covered later
// in the textbook

// Any sort function inherently accomplishes the task in question because
// it would make all things less than / greater than the k in question

// Run time of this algorithm is O(n^2).

package Homework.chap5.HW22;

import java.util.Arrays;

public class HW22 {
  // Main method to execute the program
  public static void main(String[] args)
  {
    int[] t1 = {10, 7, 8, 9, 1, 5};
    System.out.println("Original: "+Arrays.toString(t1));

    System.out.println("Sorted: "+Arrays.toString(bSort(t1, t1.length)));

    int[] t2 = {1};
    System.out.println("1 Element: "+Arrays.toString(bSort(t2,t2.length)));

    int[] t3 = new int[0];
    System.out.println("Empty: "+Arrays.toString(bSort(t3,t3.length)));
  }

  public static int[] bSort(int[] array, int n)
  {
    if (n == 1 || n == 0)
    {
      return array;
    }

    for (int i = 0; i < n - 1; i++)
    {
      if (array[i] > array[i + 1])
      {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
      }
    }

    return bSort(array, n - 1);
}
}
