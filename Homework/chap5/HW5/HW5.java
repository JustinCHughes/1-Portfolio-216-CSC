// Draw the recursion trace for the execution of reverseArray(data, 0, 4),
// from Code Fragment 5.3.2, on array data = {4, 3, 6, 2, 6}.


// Intial Call
//   |
//   +----> [6,3,6,2,4]
// First recursive call
//           |
//           +----> [6,2,6,3,4]
// Third recursive call
//                  |
//                  +----> [6,2,6,3,4]
// Final recursive call
//                         |
//                         +----> Low now > high. Return data as is

package Homework.chap5.HW5;

import java.util.Arrays;

public class HW5 {
  public static void main(String[] args)
  {
    int[] data = {4, 3, 6, 2, 6};
    System.out.println(Arrays.toString(reverseArray(data, 0, 4)));
  }

  // From the book
  public static int[] reverseArray(int[] data, int low, int high)
  {
    if (low < high)
    {                           // if at least two elements in subarray
        int temp = data[low];   // swap data[low] and data[high]
        data[low] = data[high];
        data[high] = temp;
        reverseArray(data, low + 1, high - 1);  // recur on the rest
    }

    return data;
  }
}
