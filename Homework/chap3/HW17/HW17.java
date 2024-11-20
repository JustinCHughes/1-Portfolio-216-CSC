// Let be A an array of size n >= 2 containing integers from 1 to n-1 inclusive,
// one of which is repeated. Describe an algorithm for finding the integer
// in A that is repeated.

// I've highlighted two approaches below. findDupBruteForce uses a brute force
// method where it checks each value until it finds one that is equivalent to
// another or runs out of values to check. If it runs out of values to check,
// it returns null. O(n^2)

// findDupHashSet adds items to a HashSet. This set cannot add duplicate values.
// Because of this, it cannot add it once it runs into a duplicate and returns
// that value. It returns null if it does not find a duplicate. O(n)

package Homework.chap3.HW17;

import java.util.HashSet;

public class HW17 {
  public static void main(String[] args)
  {
    // Duplicate of 5
    int[] numbers = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
    retValue(findDupBruteForce(numbers), "brute force");
    retValue(findDupHashSet(numbers), "HashSet");

    // Duplicate of 1
    int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
    retValue(findDupBruteForce(numbers2), "brute force");
    retValue(findDupHashSet(numbers2), "HashSet");

    // No duplicate
    int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    retValue(findDupBruteForce(numbers3), "brute force");
    retValue(findDupHashSet(numbers3), "HashSet");
  }

  // This is a brute force approach. This checks every value against every
  // other value until it finds a value which is equivalent to another.
  public static Integer findDupBruteForce(int[] nums)
  {
    for(int i = 0; i < nums.length; i++)
    {
      for(int j = i + 1; j < nums.length; j++)
      {
        if(nums[i] == nums[j])
        {
          return nums[i];
        }
      }
    }
    return null;
  }

  // Adds elements to the HashSet. Because HashSet does not allow for
  // duplicate values, it will trip the if statement if it is already in the
  // set. This will be the duplicate value
  public static Integer findDupHashSet(int[] nums)
  {
    HashSet<Integer> set = new HashSet<>();

    for(Integer element : nums)
    {
      if(!set.add(element))
      {
        return element;
      }
    }
    return null;
  }

  // Outputs duplicate value if one was found. Otherwise, it prints a
  // statement to the user that no duplicate was found
  public static void retValue(Integer dup, String type)
  {
    if(dup == null)
    {
      System.out.println("Using "+type+", the duplicate was: None\n");
    }
    else
    {
      System.out.println("Using "+type+", the duplicate was: "+dup+"\n");
    }
  }
}


