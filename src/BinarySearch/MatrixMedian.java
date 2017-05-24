package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shiyanch on 12/26/16.
 */
public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = 0, high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high-low)/2 + low;
            int count = countLessThanK(A, mid);
            if (count == A.size() * A.get(0).size()/2) {
                return mid;
            }
            else if (count < A.size() * A.get(0).size()/2) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return high;
    }

    private int countLessThanK(ArrayList<ArrayList<Integer>> A, int k) {
        int count = 0;
        for (ArrayList<Integer> list : A) {
            count += binarySearch(list, k);
        }
        return count;
    }

    private int binarySearch(ArrayList<Integer> list, int k) {
        int left=0, right=list.size()-1;

        while (left <= right) {
            int mid = (right-left)/2 + left;
            if (list.get(mid) >= k) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list2.add(2);
        list2.add(6);
        list2.add(9);
        list3.add(3);
        list3.add(6);
        list3.add(9);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        System.out.println(new MatrixMedian().findMedian(lists));
    }
}
