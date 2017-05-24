package TwoPointers;

import Util.MyUtil;

import java.util.ArrayList;

/**
 * Created by shiyanch on 12/31/16.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        if (a == null) {
            return 0;
        }
        if (a.size() <= 1) {
            return a.size();
        }
        int left=0,right=1;
        while (right < a.size()) {
            if(!a.get(left).equals(a.get(right))) {
                a.set(++left, a.get(right));
            }
            right++;
        }

        return left+1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(MyUtil.makeList(new int[] {1,1,1})));
    }
}
