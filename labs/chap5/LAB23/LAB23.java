// Suppose you are given an array, A, containing n distinct integers that
// are listed in increasing order. Given a number k, describe a recursive
// algorithm to find two integers in A that sum to k, if such a pair exists.
// What is the running time of your algorithm?

// Reference code below
// 1. Check if array is large enough or if low has become larger than high.
//    If either is the case, return null
// 2. Check if target is less than the sum of the two values pulled. If so,
//    decrement high by one. It is a sorted list so you will get a smaller
//    value after decrementing
// 3. Check if target is higher than the sum of the two values puled. If so,
//    increment low by one. Again, it is a sorted list so you will get a
//    bigger value by incrementing low
// 4. If larger / smaller checks are false, you found your answer. return

// Running time should be O(n). I do not iterate over values multiple times.

package labs.chap5.LAB23;

import java.util.Arrays;

public class LAB23 {
  public static void main(String[] args)
  {
    int[] array = {0,1,2,3,4,5,6,7,8,9};
    int len = array.length - 1;

    System.out.printf("Array Used: %s\n\n", Arrays.toString(array));
    System.out.println("Target 3:  " + Arrays.toString(twoSum(array,3,0, len)));
    System.out.println("Target 8:  " + Arrays.toString(twoSum(array,8,0, len)));
    System.out.println("Target 9:  " + Arrays.toString(twoSum(array,9,0, len)));
    System.out.println("Target 19: " + Arrays.toString(twoSum(array,19,0, len)));
    System.out.println("Target 23: " + Arrays.toString(twoSum(array,23,0, len)));
    System.out.println("Target 0:  " + Arrays.toString(twoSum(array,0,0, len)));
    System.out.println("Target 13: " + Arrays.toString(twoSum(array,13,0, len)));
    System.out.println("Target 5:  " + Arrays.toString(twoSum(array,5,0, len)));
    System.out.println("Target 99: " + Arrays.toString(twoSum(array,99,0, len)));
  }

  public static int[] twoSum(int[] array, int target, int low, int high)
  {
    // Checks if array is too small to analyze or low is now higher than high
    if(array.length < 2 || low >= high)
    {
      return null;
    }
    // If target is less than sum, decrement high by one slot
    if(target < array[low] + array[high])
    {
      int[] answer = twoSum(array, target, low, high - 1);
      return answer;
    }
    // If target is larger than sum, increment low by one slot
    else if(target > array[low] + array[high])
    {
      int[] answer = twoSum(array, target, low + 1, high);
      return answer;
    }
    // Not larger or smaller. Correct answer, return
    int[] answer = {array[low], array[high]};
    return answer;
  }
}
