package Hashing;

import Util.MyUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanch on 12/31/16.
 */
public class Equal {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        Map<Long, Integer[]> map = new HashMap<Long, Integer[]>();

        ArrayList<Integer> result = null;

        for (int i=0; i<a.size(); i++) {
            for (int j=i+1; j<a.size(); j++) {
                long sum = a.get(i) + a.get(j);
                if (map.containsKey(sum)) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    Integer[] array = map.get(sum);
                    list.add(array[0]);
                    list.add(array[1]);
                    list.add(i);
                    list.add(j);
                    if (valid(list, a)) {
                        result = result==null?list:compare(result, list);
                    }
                }
                else {
                    Integer[] array = new Integer[] {i, j};
                    map.put(sum, array);
                }
            }
        }
        return result;
    }

    private boolean valid(ArrayList<Integer> list, ArrayList<Integer> array) {
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        int d = list.get(3);
        if (array.get(a)+array.get(b) != array.get(c) + array.get(d)) {
            return false;
        }

        return a < b && c < d && a < c && b != d && b != c;
    }

    private ArrayList<Integer> compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        for (int i=0; i<4; i++) {
            if (list1.get(i) != list2.get(i)) {
                return list1.get(i)<list2.get(i)?list1:list2;
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        System.out.println(new Equal().equal(MyUtil.makeList(new int[] {3, 4, 7, 1, 2, 9, 8})));
    }
}
