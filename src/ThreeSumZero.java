import Util.MyUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by shiyanch on 12/27/16.
 */
public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(a);
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for (int i=0; i<a.size()-2; i++) {
            if (i>0 && a.get(i).equals(a.get(i-1))) {
                continue;
            }

            int left = i+1;
            int right = a.size()-1;
            int target = -a.get(i);

            while (left < right) {
                long curSum = a.get(left)+a.get(right);
                if (curSum == target) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(a.get(i));
                    list.add(a.get(left));
                    list.add(a.get(right));

                    // if (!set.contains(list)) {
                    //     set.add(list);
                    //     result.add(list);
                    // }
                    result.add(list);
                    int prev = left;
                    while (left <= right && a.get(left) == a.get(prev) ) {
                        left++;
                    }
                }
                else if (curSum > target) {
                    right--;
                }
                else if (curSum < target) {
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumZero().threeSum(MyUtil.makeList(new int[] {-31013930, -31013930, 9784175, 21229755})));
    }
}
