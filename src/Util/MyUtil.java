package Util;

import java.util.ArrayList;

/**
 * Created by shiyanch on 12/26/16.
 */
public class MyUtil {
    public static ArrayList<Integer> makeList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
