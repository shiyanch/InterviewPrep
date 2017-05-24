package Array.ArrayMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shiyanch on 12/13/16.
 */
public class RepeatAndMissingNumberArrayBookmarkSuggestEdit {
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int xor = a.get(0) ^ 1;

        for (int i=1; i<a.size(); i++) {
            xor ^= a.get(i);
            xor ^= i+1;
        }

        int set_bit_no = (xor) & ~(xor - 1);
        int A = 0;
        int B = 0;
        for (int i=0; i<a.size(); i++) {
            if ((a.get(i) & set_bit_no) == 1 ) {
                A ^= a.get(i);
            }
            else {
                B ^= a.get(i);
            }

            if ((i+1 & set_bit_no) == 1 ) {
                A ^= i+1;
            }
            else {
                B ^= i+1;
            }
        }

        res.add(A);
        res.add(B);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[] {3,1,2,5,3});
        System.out.println(new RepeatAndMissingNumberArrayBookmarkSuggestEdit().repeatedNumber(a));
    }
}
