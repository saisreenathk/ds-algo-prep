package com.preparation.self.matrix;

/*
count zeros in a rowwise and column wise sorted matrix
https://javabypatel.blogspot.com/2016/10/count-zeros-in-sorted-matrix.html
 */
public class CountZeros {

    /*
      0 0 1 1
      0 1 1 1
      1 1 1 1
     */
    public int countZeros(int[][] matrix) {
        int count = 0;
        int row = 0;
        int col = matrix[0].length - 1;

        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == 1) {
                col--;
            } else if (matrix[row][col] == 0) {
                count += col + 1;
                row++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountZeros c = new CountZeros();
        int[][] matrix = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        //System.out.println(c.countZeros(matrix));

        int[][] matrix2 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        c.printMatrixDiagonally(matrix2);
    }


    private void printMatrixDiagonally(int[][] matrix){

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        for (int r = 0; r < rowCount; r++) {
            for (int row = r, col = 0; row >= 0 && col < columnCount; row--, col++) {
                System.out.print("["+row+col+"]");
            }
            System.out.println();
        }

        for (int c = 1; c < columnCount; c++) {
            for (int row = rowCount-1, col = c; row >= 0 && col < columnCount; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
