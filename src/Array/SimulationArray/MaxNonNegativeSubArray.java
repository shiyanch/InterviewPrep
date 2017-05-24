package Array.SimulationArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Programming / Arrays / Max Non Negative Sub Array
 *
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous.
 * That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * Sub-array A is greater than sub-array B if sum(A) > sum(B).
 */
public class MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(List<Integer> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        long resSum = 0;
        long tempSum = 0;
        for (int i : a) {
            if (i >= 0) {
                temp.add(i);
                tempSum += i;
            }
            else {
                if (tempSum > resSum || (tempSum == resSum && temp.size() > res.size())) {
                    resSum = tempSum;
                    res = new ArrayList<Integer>(temp);
                }
                temp.clear();
                tempSum = 0;
            }
        }

        if (tempSum > resSum || (tempSum == resSum && temp.size() > res.size())) {
            resSum = tempSum;
            res = new ArrayList<Integer>(temp);
        }

        return res==null?new ArrayList<Integer>():res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNonNegativeSubArray().maxset(Arrays.asList(new Integer[] {})));
    }
}
