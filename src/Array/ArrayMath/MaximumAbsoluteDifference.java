package Array.ArrayMath;

import java.util.Arrays;
import java.util.List;

/**
 * Programming / Arrays / Maximum Absolute Difference
 *
 * You are given an array of N integers, A1, A2 ,…, AN.
 * Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 *
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|,
 * where |x| denotes absolute value of x.
 *
 * f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways
 * (A[i] + i) - (A[j] + j)
 * -(A[i] - i) + (A[j] - j)
 * (A[i] - i) - (A[j] - j)
 * (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
 *
 * we just have to store minimum and maximum values of expressions A[i] + i and A[i] - i for all i.
 */
public class MaximumAbsoluteDifference {
    public int maxArr(List<Integer> A) {
        int max_plusIndex = Integer.MIN_VALUE;
        int min_plusIndex = Integer.MAX_VALUE;
        int max_minusIndex = Integer.MIN_VALUE;
        int min_minusIndex = Integer.MAX_VALUE;

        for (int i=0; i<A.size(); i++) {
            int plusIndex = A.get(i)+(i+1);
            int minusIndex = A.get(i)-(i+1);
            max_plusIndex = Math.max(max_plusIndex, plusIndex);
            min_plusIndex = Math.min(min_plusIndex, plusIndex);
            max_minusIndex = Math.max(max_minusIndex, minusIndex);
            min_minusIndex = Math.min(min_minusIndex, minusIndex);
        }

        return Math.max(max_plusIndex-min_plusIndex, max_minusIndex-min_minusIndex);
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[] {1,3,-1});
        System.out.println(new MaximumAbsoluteDifference().maxArr(a));
    }
}
