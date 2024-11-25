// Describe a recursive algorithm for finding the maximum element in an array,
// A, of n elements. What is your running time and space usage?

// Please reference code below for reference
// 1. I would intake array and position
// 2. Check if array has a length. If not, return 0
// 3. The escape case would be defined as if position < 1, return array[0]
// 4. Recursively call using Math.max(int[x], max(array[], x - 1))
// Eventually, the return will be the max of the whole array

// Time Complexity O(n)
// Space Complexity O(n)

package Homework.chap5.HW1;

public class HW1 {
  
  public static void main(String[] args)
  {
    int[] t1 = {0, 1, 2, 3, 4, 5};
    System.out.println("Answer at end should be 5: " + max(t1, t1.length-1));

    int[] t2 = {21, 0, 1, 45, 3, 4, 5};
    System.out.println("Answer at front should be 21: " + max(t2, t2.length-1));

    int[] t3 = new int[4];
    System.out.println("List of nothing. Should be 0: " + max(t3, t3.length-1));

    int[] t4 = new int[0];
    System.out.println("No Length Array. Set to 0: " + max(t4, t4.length-1));
  }

  public static int max(int[] intArr, int position)
  {
    if(position < 0)
    {
      return 0;
    }
    else if(position < 1)
    {
      return intArr[position];
    }
    int returned = max(intArr, position -1);
    if(returned > intArr[position])
    {
      return returned;
    }
    return intArr[position];
  }
}
