package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shiyanch on 12/27/16.
 */
public class NextPermutation {
    public void nextPermutation2(List<Integer> a) {
        if(a == null || a.size() <= 1) {
            return;
        }

        int index = 0;
        for(int i=a.size()-1;i>=1;i--) {
            if(a.get(i) > a.get(i-1)) {
                index = i;
                break;
            }
        }

        if(index != 0) {
            index--;
            for (int j = a.size() - 1; j > index; j--) {
                if (a.get(j) > a.get(index)) {
                    int temp = a.get(index);
                    a.set(index, a.get(j));
                    a.set(j, temp);
                    break;
                }
            }
            index++;
        }

        // reverse nums of range [i+1, nums.length-1]
        reverse(a, index);
    }

    private void reverse(List<Integer> a,int i){
        int first = i;
        int last = a.size()-1;
        while(first<last){
            int t = a.get(first);
            a.set(first, a.get(last));
            a.set(last, t);
            first ++;
            last --;
        }
    }

    public void nextPermutation(Integer[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int index = 0;
        for(int i=nums.length-1;i>=1;i--) {
            if(nums[i] > nums[i-1]) {
                index = i;
                break;
            }
        }

        if(index != 0) {
            index--;
            for (int j = nums.length - 1; j > index; j--) {
                if (nums[j] > nums[index]) {
                    int temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            index++;
        }

        // reverse nums of range [i+1, nums.length-1]
        reverse(nums, index);

    }

    private void reverse(Integer[] a,int i){
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
        List<Integer> a = Arrays.asList(nums);
        new NextPermutation().nextPermutation2(a);
//        new NextPermutation().nextPermutation(nums);
        System.out.println(a);
    }
}
