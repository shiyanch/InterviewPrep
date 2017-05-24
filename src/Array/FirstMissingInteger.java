package Array;

import java.util.ArrayList;

/**
 * Programming / Arrays / First Missing Integer
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 * Given [1,2,0] return 3,
 * [3,4,-1,1] return 2,
 * [-8, -7, -6] returns 1
 *
 * Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return 1;
        }
        for (int i=0; i<a.size(); i++) {
            int num = a.get(i);
            while (num > 0 && num <= a.size() && a.get(num-1) != num) {
                int next = a.get(num-1);
                a.set(num-1, num);
                num = next;
            }
        }

        for (int i=0; i<a.size(); i++) {
            if (a.get(i) != i+1) {
                return i+1;
            }
        }

        return a.size()+1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(2);
        a.add(4);
        a.add(1);
        System.out.println(new FirstMissingInteger().firstMissingPositive(a));
    }
}
