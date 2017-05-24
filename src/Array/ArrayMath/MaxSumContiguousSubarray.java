package Array.ArrayMath;

import java.util.Arrays;
import java.util.List;

/**
 * Programming / Arrays / Max Sum Contiguous SubarrayBookmark Suggest Edit
 *
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 *
 * For example:
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * For this problem, return the maximum sum.
 */
public class MaxSumContiguousSubarray {
    public int maxSubArray(final List<Integer> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            sum = Math.max(sum+i, i);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(new MaxSumContiguousSubarray().maxSubArray(a));
    }
}
