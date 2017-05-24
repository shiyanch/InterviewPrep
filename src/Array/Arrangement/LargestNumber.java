package Array.Arrangement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Programming / Arrays / Largest Number
 * Given a list of non negative integers,
 * arrange them such that they form the largest number.
 * For example:
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 */
public class LargestNumber {
    public String largestNumber(final List<Integer> a) {
        if (a == null || a.size() == 0) {
            return "0";
        }

        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                String first = String.valueOf(o1) + String.valueOf(o2);
//                String second = String.valueOf(o2) + String.valueOf(o1);
//                return second.compareTo(first);

                String str1 = o1+"";
                String str2 = o2+"";
                int i=0;
                int j=0;
                boolean added = false;
                while(i<str1.length() || j<str2.length()) {
                    char c1 = str1.charAt(i % str1.length());
                    char c2 = str2.charAt(j % str2.length());
                    if (c1 != c2) {
                        return c2 - c1;
                    }
                    else {
                        i++;
                        j++;
                    }
                }

                // Very Important!
                // edge case : 121, 12 -> 12121;  212, 21 -> 21221
                return str2.charAt(j % str2.length())-str1.charAt(i % str1.length());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i);
        }

        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(Arrays.asList(new Integer[] {212, 21})));
    }
}
