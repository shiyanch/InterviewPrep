package Array;

import Util.MyUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Programming / Arrays / Maximum Unsorted Subarray
 *
 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
 * Find the minimum sub array Al, Al+1 ,…, Ar
 * so if we sort(in ascending order) that sub array, then the whole array should get sorted.
 *
 * If A is already sorted, output -1.
 */
public class MaximumUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int i=0, j=A.size()-1;
        while (i < A.size()-1 && A.get(i) <= A.get(i+1)) {
            i++;
        }

        while (j > 0 && A.get(j) >= A.get(j-1)) {
            j--;
        }

        if (i == A.size()-1) {
            res.add(-1);
            return res;
        }

        int mn = A.get(i+1);
        int mx = A.get(i+1);

        for (int k=i; k<=j; k++) {
            mx = Math.max(mx, A.get(k));
            mn = Math.min(mn, A.get(k));
        }

        int l=0, r=A.size()-1;
        while (A.get(l) <= mn && l <= i) {
            l++;
        }

        while (A.get(r) >= mx && r >= j) {
            r--;
        }
        res.add(l);
        res.add(r);

        return res;
    }


    // Sort
    public ArrayList<Integer> subUnsort_sort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> copy = new ArrayList<>(A);
        Collections.sort(copy);
        int i=0, j=A.size()-1;
        boolean first = false;
        boolean second = false;
        while (i < j) {
            if (!first && A.get(i) != copy.get(i)) {
                res.add(0,i);
                first = true;
            }

            if (!second && A.get(j) != copy.get(j)) {
                res.add(j);
                second = true;
            }

            if (!first) {
                i++;
            }
            if (!second) {
                j--;
            }

            if (res.size() == 2) {
                return res;
            }
        }

        res.add(-1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumUnsortedSubarray().subUnsort(MyUtil.makeList(new int[] {2,1,4,3})));
    }
}
