package Hashing;

import java.util.*;

/**
 * Created by shiyanch on 12/31/16.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        Collections.sort(a);
        for (int i=0; i<a.size()-3; i++) {
            for (int j=i+1; j<a.size()-2; j++) {
                int target = b-a.get(i)-a.get(j);
                int left=j+1,right=a.size()-1;
                while (left < right) {
                    int sum = a.get(left)+a.get(right);
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(a.get(i));
                        list.add(a.get(j));
                        list.add(a.get(left));
                        list.add(a.get(right));
                        if (!set.contains(list)) {
                            result.add(list);
                            set.add(list);
                        }
                        left++;
                        right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        System.out.println(new FourSum().fourSum(list, 10));

        String str = "bca";
        Arrays.sort(str.toCharArray());

    }
}
