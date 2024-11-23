// Write a short recursive Java method that takes a character string a
// and outputs its reverse. For example, the reverse of pots&pans
// would be snap&stop.

// Refer code below for context
// We consistently reduce the string by one by inputting the substring
// back into the reverse() function starting at index 1. The character
// at index 0 is held to be appended at the end of the return statement
// so that when we reach the end of the recursions, they are all
// concatenated in reverse order

package Homework.chap5.HW18;

public class HW18 {
  public static void main(String[] args)
  {
    System.out.println(reverse("pots&pans"));
  }

  public static String reverse(String input)
  {
    if(input.length() == 0)
    {
      return input;
    }
    else
    {
      return reverse(input.substring(1)) + input.charAt(0);
    }
  }
}
