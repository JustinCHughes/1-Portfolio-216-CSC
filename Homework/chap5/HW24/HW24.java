// Describe a recursive algorithm that will check if an array A of integers
// contains an integer A[i] that is the sum of two integers that appear
// earlier in A, that is, such that A[i] = A[j] + A[k] for j,k < i.

// I am assuming that the list is not necessarily sorted.
// Please refer to code below for context

// 1. Initialize method with array, target at 3rd element because you need
//    at least two elements behind it to add up to the third. Lead and lag
//    are initialized at 0 and 1
// 2. Check if array.length is at least 3. As noted, you need three elements
//    for this problem. Also check if target == array.length and thus out
//    of bounds of the array. This means whole array has been checked and
//    check is false.
// 3. Check for equality and if criteria is true and needs to return true
// 4. If lead and lag take up the first two elements of the array, need to
//    push target one forward in array to check further elements. Recursively
//    call the function after making adjustments to target and setting lead
//    and lag back to the two elements before target
// 5. Check if lead is 0. Decrement lag by one and then set lead to one below
//    that and call function recursively with new parameters
// 6. No other ifs triggered, decrement lead and keep checking / calling

package Homework.chap5.HW24;

public class HW24 {
  public static void main(String[] args)
  {
    int[] t1 = {1,2,3};
    System.out.println("Should be True: " + twoSum(t1, 2, 0, 1));

    int[] t2 = {1,2,13,17,54};
    System.out.println("Should be False: " + twoSum(t2, 2, 0, 1));

    int[] t3 = {1};
    System.out.println("Should be False: " + twoSum(t3, 2, 0, 1));

    int[] t4 = {1,19,53,100,47,88,93,700,5000,66};
    System.out.println("Should be True: " + twoSum(t4, 2, 0, 1));
  }

  public static boolean twoSum(int[] array, int target, int lead, int lag)
  {
    // Array is too small or we have reached the end of checkable values
    // and there are no figures that meet criteria
    if(array.length < 3 || array.length == target)
    {
      return false;
    }
    // Check if two previous values add up to array[target]
    if(array[target] == array[lead] + array[lag])
    {
      return true;
    }
    // Lead and lag are the first two values in the array. Increase target
    // by one and move lead and lag to just below target
    else if(lead == 0 && lag == 1)
    {
      target = target + 1;
      lead = target - 2;
      lag = target - 1;
      return twoSum(array, target, lead, lag);
    }
    // Lead is 0 but lag is not yet at 1. Decrement lag by 1. Put
    // lead one below lag
    else if(lead == 0)
    {
      lag = lag - 1;
      lead = lag - 1;
      return twoSum(array, target, lead, lag);
    }
    // Lead is not yet at 0 and nothing is equal as of yet. Decrement lead
    else
    {
      return twoSum(array, target, lead - 1, lag);
    }
  }
}
