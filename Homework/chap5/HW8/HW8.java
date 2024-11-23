// Describe a recursive algorithm for converting a string of digits into the
// integer it represents. For example, '13531' represents the integer 13,531.

// Please reference below code for context
// 1. I check if input string.length() is == to 0. If so, return 0
// 2. If the value of the char I'm at in the string is a ',' do not add value
// 3. To clarify, we are starting from num.length()-1 so we are starting
//    from the smaller digit place. I resursively call so current value
//    is added to the next digit to the LEFT * 10. Multiplying by 10 before
//    adding takes care of having any number place issues. The input for the
//    new call will use a subtring of 0 to num.length() - 1.
// 4. Once we hit 0 length, the we turn 0.

package Homework.chap5.HW8;

public class HW8 {
  public static void main(String[] args)
  {
    // Standard value
    System.out.println(toInt("710"));

    // Checking if comma checking is working
    System.out.println(toInt("150,789,631"));
  }

  public static int toInt(String num)
  {
    if (num.length() == 0)
    {
      return 0;
    }
    else
    {
      char lastChar = num.charAt(num.length() - 1);
      if (lastChar == ',')
      {
        return toInt(num.substring(0, num.length() - 1));
      }
      else
      {
      return (lastChar - '0') + 10 * toInt(num.substring(0, num.length() - 1));
      }
    }
}
}
