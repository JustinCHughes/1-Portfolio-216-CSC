// Write a Java program for a matrix class that can add and multiply arbitrary
// two-dimensional arrays of integers.

package labs.chap3.LAB36;

import java.util.Arrays;

public class LAB36 {
  public static void main(String[] args)
  {
    int[][] matrix1 = {{1, 2, 3},{4, 5, 6}};
    int[][] matrix2 = {{0, 0, 0, 2},{0, 0, 0, 1}};

    int[][] retMatrix = add(matrix1, matrix2);

    System.out.println(Arrays.deepToString(retMatrix));
  }

  public static int[][] add(int[][] matrix1, int[][] matrix2)
  {
    int minRow = Math.min(matrix1.length, matrix2.length);
    int minCol = Math.min(matrix1[0].length, matrix2[0].length);

    int maxRow = Math.max(matrix1.length, matrix2.length);
    int maxCol = Math.max(matrix1[0].length, matrix2[0].length);

    int[][] retMatrix = new int[maxRow][maxCol];

    for(int i = 0; i < minRow; i++)
    {
      for(int j = 0; j < minCol; j++)
      {
        retMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
      }
    }
    return retMatrix;
  }
}
