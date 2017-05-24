package Array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Programming / Arrays / Find Duplicate In Array
 *
 * Given a read only array of n + 1 integers between 1 and n,
 * find one number that repeats in linear time using less than O(n) space
 * and traversing the stream sequentially O(1) times.
 *
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 * If there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) {
            if (set.contains(num)) {
                return num;
            }
            else {
                set.add(num);
            }
        }
        return -1;
    }
}
