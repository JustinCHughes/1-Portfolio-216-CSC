package Homework.chap3.HW18;

import java.util.ArrayList;

public class BubbleSort {
  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list)
  {
    Integer temp;
    for(int i = 0; i < list.size(); i++)
    {
      for(int j = 0; j < list.size() - i - 1; j++)
      {
        if(list.get(j) > list.get(j+1))
        {
          temp = list.get(j+1);
          list.set(j+1, list.get(j));
          list.set(j,temp);
        }
      }
    }

    return list;
  }
}
