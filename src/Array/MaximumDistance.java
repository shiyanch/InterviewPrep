package Array;

import java.util.List;

/**
 * Programming / Arrays / Max Distance
 *
 * Given an array A of integers,
 * find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 * If there is no solution possible, return -1.
 */
public class MaximumDistance {
    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];

        minLeft[0] = A.get(0);
        maxRight[n-1] = A.get(n-1);
        for (int i=1; i<n; i++) {
            minLeft[i] = Math.min(minLeft[i-1], A.get(i));
            maxRight[n-i-1] = Math.max(maxRight[n-i], A.get(n-i));
        }

        int max = -1;
        for (int j=n-1; j>=0; j--) {
            max = Math.max(max, j-minIndex(minLeft, maxRight[j]));
        }

        return max;
    }

    private int minIndex(int[] minLeft, int num) {
        int low = 0;
        int high = minLeft.length;
        int index = -1;

        while (low <= high) {
            int mid = (high-low)/2 + low;
            int minNum = minLeft[mid];

            if (num < minNum) {
                low = mid+1;
            }
            else {
                index = mid;
                high = mid-1;
            }
        }

        return index;
    }
}
