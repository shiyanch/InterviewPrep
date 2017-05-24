package Array;

import java.util.ArrayList;

/**
 * Programming / Arrays / Set Matrix ZerosBookmark Suggest Edit
 *
 * Given an m x n matrix of 0s and 1s, if an element is 0,
 * set its entire row and column to 0.
 *
 * Do it in place.
 */
public class SetMatrixZeros {

    // 可以使用每一行的行首和列首元素作为指示是否清空该行与该列
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0 || a.get(0).size() == 0) {
            return;
        }
        int m = a.size();
        int n = a.get(0).size();

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (a.get(i).get(j) == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }


        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (row[i] == true || col[j] == true) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }
}
