// Describe a recursive algorithm for copmuting the nth Harmonic number
// defined as Hn = n, k=1, 1/k 

// Reference code below
// Intial run ensures that I do not cause a 1/0 error or an infinite error
// where we start negative trying to go lower to 1. If either is true, we
// instantly return 0

// Our escape scenario is x == 1 where we return 1 because 1/1

// The recursive call call summation (1.0/x) + summation(x-1)

package Homework.chap5.HW7;

public class HW7 {
  public static void main(String[] args)
  {
    System.out.println(summation(3));
  }
  public static double summation(int x)
  {
    if(x < 1)
    {
      return 0; // This would be undefined because 1/0
    }
    else if(x == 1)
    {
      return 1;
    }
    else
    {
      return (1.0/x) + summation(x-1);
    }
  }
}
