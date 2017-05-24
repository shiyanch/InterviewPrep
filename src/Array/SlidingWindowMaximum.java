package Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by shiyanch on 1/5/17.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k<=0) {
            return new int[] {};
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int index = 0;
        for (int i=0;i<nums.length;i++) {
            while (!queue.isEmpty() && queue.peek()<i-k+1) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            if (i>=k-1) {
                res[index++] = nums[queue.peek()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
        for (int n : res) {
            System.out.print(n+" ");
        }
        System.out.println();

    }
}
