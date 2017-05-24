package Array.ArrayMath;

import java.util.ArrayList;

/**
 * Programming / Arrays / Array.ArrayMath.Flip
 *
 * You are given a binary string(i.e. with characters 0 and 1) S
 * consisting of characters S1, S2, …, SN. In a single operation,
 *
 * you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N
 * and flip the characters SL, SL+1, …, SR.
 *
 * By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 * If you don’t want to perform the operation, return an empty array.
 * Else, return an array consisting of two elements denoting L and R.
 * If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * 将1->-1，0->1 转化为求最大子串和问题
 */
public class Flip {
    public ArrayList<Integer> flip(String A) {
        if (!A.contains("0")) {
            return new ArrayList<Integer>();
        }
        int max = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        int curLeft = 0;
        for (int i=0; i<A.length(); i++) {
            int curr = A.charAt(i)=='1'?-1:1;
            sum = Math.max(sum+curr, curr);
            if (sum < 0) {
                curLeft = i+1;
            }

            if (sum > max) {
                left = curLeft;
                right = i;
                max = sum;
            }
        }
        if (right < left) {
            right = A.length()-1;
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(left+1);
        res.add(right+1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Flip().flip("010101010101001"));
    }
}
