// Describe a way to use recursion to compute the sum of all the elements in
// an n x n (two-dimensional) array of integers.

// Please see reference code below

// 1. arraySum intakes 2D array of ints and array.length - 1
// 2. When array length is negative, it returns 0
// 3. We iterate over the row to sum up all the values in the row
//    I made the assumption that I did not need to do recursion across a row
//    of integers.
// 4. We return the rowSum + a recursive call on the array and one row up

package Homework.chap5.HW10;

public class HW10 {
  public static void main(String[] args)
  {
    int[][] test = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
    System.out.println(arraySum(test, test.length - 1));
  }

  public static int arraySum(int[][] array, int n)
  {
    if(n < 0)
    {
      return 0;
    }
    
    int rowSum = 0;
    for (int i = 0; i < array[n].length; i++)
    {
      rowSum = rowSum + array[n][i];
    }

    return rowSum + arraySum(array, n - 1);
  }
}
