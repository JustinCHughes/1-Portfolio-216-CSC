// Give a recursive algorithm to compute the product of two positive
// integers, m and n, using only addition and subtraction.

// Reference code below for context
// 1. If either n or m is 0, return 0
// 2. If n is negative subtract n twice to make it positive
// 3. When n is only 1, return m
// 4. After all checks, recursively call by doing m + function call again
//    with n - 1.

package Homework.chap5.HW13;

public class HW13 {
  public static void main(String[] args)
  {
    System.out.printf(" 3 x 2 = %3d\n", fakeMultiply(3,2));
    System.out.printf(" 8 x 8 = %3d\n", fakeMultiply(8,8));
    System.out.printf(" 0 x 2 = %3d\n", fakeMultiply(0,2));
    System.out.printf(" 7 x-5 = %3d\n", fakeMultiply(7,-5));
    System.out.printf("-7 x 5 = %3d\n", fakeMultiply(-7,5));
    System.out.printf("-7 x-5 = %3d\n", fakeMultiply(-7,-5));
    System.out.printf("-1 x-1 = %3d\n", fakeMultiply(-1,-1));
  }

  public static int fakeMultiply(int m, int  n)
  {
    if(n == 0 || m == 0)
    {
      return 0;
    }
    if(n < 0)
    {
      n = n - n - n;
    }
    if(n == 1)
    {
      return m;
    }
    else
    {
      return m + fakeMultiply(m, n - 1);
    }
  }
}
