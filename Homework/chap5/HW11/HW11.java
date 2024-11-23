// Describe a recursive algorithm to compute the integer part of the
// base-two logarithm of n using only addition and integer division.

// Please see reference code below
// I made the assumption that the question really did mean integer and
// that I did not have to return a double for log2(9).

// 1. Because we are outputting only integers and intaking only integers,
//    any 1.99 values or less will truncate down to 1. log2(1.99/2) would
//    again be less than 2. To avoid an infinite recursion, we stop any
//    recursions and return 0 for any n < 2.
// 2. We then return 1 + log2(n/2). We will eventually reduce to until
//    value is under 2 and this will terminate.

package Homework.chap5.HW11;

public class HW11 {
  public static void main(String[] args)
  {
    System.out.println("Log2(8) is 3: " + log2(8));
    System.out.println("Log2(10) is 3: " + log2(10));
    System.out.println("Log2(128) is 7: " + log2(128));
    System.out.println("Log2(32) is 5: " + log2(8));
  }

  public static int log2(int n)
  {
   if(n < 2)
   {
    return 0;
   }
   else
   {
    return 1 + log2(n/2);
   }
  }
}
