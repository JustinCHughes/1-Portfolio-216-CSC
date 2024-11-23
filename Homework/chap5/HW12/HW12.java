// Describe an efficient recursive algorithm for solving the element
// uniqueness problem, which runs in time that is at most O(n^2) in
// the worst case without using sorting.

// Reference code below for context
// 1. Checks if position 1 is equal to last element and is position 1 and 2
//    are equal. If it has reached this point without triggering a false
//    return, it returns as true
// 2. If position 1 and 2 are equal, it doesn't check for uniqueness and 
//    iterates position 2. We know it is not the last element because it did
//    not trigger the first if statemenet so we know we won't be out of index
// 3. Check if pos2 == nums.length which is out of bounds for the array.
//    Start next process where pos1 increments and position2 goes back to 0
// 4. Check if the array elements are equal. Return false if equal
// 5. Call again with position2 incremented

package Homework.chap5.HW12;

public class HW12 {
  public static void main(String[] args)
  {
    int[] test1 = {1,2,3,4,5,6,7,8,9,10};
    System.out.println("No dupes: " + unique(test1,0,0));

    int[] test2 = {1,2,3,4,5,5,7,8,9,10};
    System.out.println("Duplicate 5: " + unique(test2,0,0));

    int[] test3 = {10};
    System.out.println("Single element: " + unique(test3,0,0));
  }

  public static boolean unique(int[] nums, int pos1, int pos2)
  {
    if(pos1 == nums.length - 1 && pos1 == pos2)
    {
      return true;
    }
    if(pos1 == pos2)
    {
      return unique(nums, pos1, pos2 + 1);
    }
    else if(pos2 == nums.length)
    {
      return unique(nums, pos1 + 1, 0);
    }
    else if(nums[pos1] == nums[pos2])
    {
      return false;
    }
    else
    {
      return unique(nums, pos1, pos2 + 1);
    }
  }
}
