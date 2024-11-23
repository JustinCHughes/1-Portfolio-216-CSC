// Cited sources because I did research on how to do this one

// Please reference code below for context
// Please bare with me on this explanation because I had to read an 
// explanation on this problem and it still gave me a headache

// Source One:
// Program for Tower of Hanoi Algorithm. (2024, May 9). Geeksforgeeks.
// Retrieved November 22, 2024, from
// https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/

// Source Two Kind Of. Used this website to play around with ideas:
// https://www.mathsisfun.com/games/towerofhanoi.html

// First Call 1:
// Before it does anything else, it recursively calls itself once

// Recursive Call 2:
// Again, it recursively calls itself before doing anything

// Recursive Call 3:
// n is now equal to 1. It prints out the statement saying that it is moving
// disk 1 from A to C. It then returns back to Iteration 2

// Recursive Call 2 Continued:
// We are back on iteration 2 with disk 2. It prints out saying that we are
// Moving disk 2 from A to B becuase of the order we placed our A, B, C
// pegs into the recursive call

// Recursive Call 4:
// We enter the second recursive call in recursive call 2 to enter recursive
// call 4. We have the pegs once again ordered differently in the call.
// This moves disk 1 from C to B and return

// First Call 1:
// We come back up to the first call. Disk 3 gets moved from A to C and
// then enters the recursive call at the bottom of the algorithm

// From here forward it is largely a repeat of the logic above except with
// Different movements due to the changes of the peg order inputs

// Recursive Call 5:
// We enter and are immediately moved to recursive call 6.

// Recursive Call 6:
// Disk 1 is move from B to A and then returns

// Recursive Call 5 Continued:
// Disk 2 is move from B to C. Then we enter another recursive call

// Recursive Call 7:
// Disk 1 is moved from A to C. We return all the way to the top of the method
// and terminate the method

package labs.chap5.LAB31;

public class LAB31 {
  public static void main(String[] args)
  {
    towerOfHanoi(3, 'A', 'B', 'C');
  }

  public static void towerOfHanoi(int n, char A, char B, char C)
  {
    if(n == 1)
    {
      System.out.printf("Move Disk 1 from %c to %c\n", A, C);
      return;
    }
    towerOfHanoi(n-1, A, C, B);
    System.out.printf("Move Disk %d from %c to %c\n", n, A, C);
    towerOfHanoi(n-1, B, A, C);
  }
}
