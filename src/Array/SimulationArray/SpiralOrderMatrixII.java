package Array.SimulationArray;

import java.util.ArrayList;

/**
 * Programming / Arrays / Spiral Order Matrix Ii
 *
 * Given an integer n,
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 * Given n = 3,
 * You should return the following matrix:
 * [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class SpiralOrderMatrixII {
    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int rows, cols;
        int row, col;

        rows = cols = n;
        int num = 1;
        int max = n * n;

        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < rows; j++) {
                res.get(i).add(0);
            }
        }

        row = col = 0;
        int dir = 0;
        int layer = 0;

        res.get(0).set(0, 1);

        for (int step = 2; step <= n * n; step++) {
            switch(dir) {
                // Go right
                case 0:
                    if (col == cols - layer - 1) {
                        row++;
                        dir = 1;
                    } else {
                        col++;
                    }
                    break;
                // Go down
                case 1:
                    if (row == rows - layer - 1) {
                        dir = 2;
                        col--;
                    } else {
                        row++;
                    }
                    break;
                // Go left
                case 2:
                    if (col == layer) {
                        row--;
                        dir = 3;
                    } else {
                        col--;
                    }
                    break;
                // Go up
                case 3:
                    if (row == layer + 1) {
                        dir = 0;
                        col++;
                        layer++;
                    } else {
                        row--;
                    }
                    break;
            }
            res.get(row).set(col, step);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralOrderMatrixII().generateMatrix(3));
    }
}
