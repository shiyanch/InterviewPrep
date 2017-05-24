package Array.Arrangement;

import java.util.ArrayList;

/**
 * Programming / Arrays / Rotate Matrix
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * You need to do this in place.
 * Note that if you end up using an additional array, you will only receive partial score.
 */
public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0) {
            return;
        }
        int n = a.size();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(i).get(n-1-j));
                a.get(i).set(n-1-j, temp);
            }
        }
    }
}
