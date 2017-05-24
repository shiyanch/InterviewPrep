package Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shiyanch on 12/31/16.
 */
public class Diffk {
    public int diffPossible(final List<Integer> a, int b) {
        Set<Long> set = new HashSet<Long>();
        long target = b;
        for (int i:a) {
            if (set.contains(target+i) || set.contains(i-target)) {
                return 1;
            }
            set.add((long)i);
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[] {34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29});
        System.out.println(new Diffk().diffPossible(a, 97));
    }
}
