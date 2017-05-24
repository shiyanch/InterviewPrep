package Array;

import java.util.List;

/**
 * Programming / Arrays / N/3 Repeat Number
 *
 * You’re given a read only array of n integers.
 * Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
 *
 * If so, return the integer. If not, return -1.
 * If there are multiple solutions, return any one.
 */
public class N3RepeatNumber {
    public int repeatedNumber(final List<Integer> a) {
        if (a == null) {
            return -1;
        }

        if (a.size() < 3) {
            return a.get(0);
        }

        int[][] count = new int[2][2];

        for (int i=0; i<a.size(); i++) {
            int cur = a.get(i);
            if (count[0][0] == cur) {
                count[0][1]++;
            }
            else if (count[1][0] == cur) {
                count[1][1]++;
            }
            else {
                if (count[0][1] == 0) {
                    count[0][0] = cur;
                    count[0][1] = 1;
                }
                else if (count[1][1] == 0) {
                    count[1][0] = cur;
                    count[1][1] = 1;
                }
                else {
                    count[0][1]--;
                    count[1][1]--;
                }
            }
        }

        // 消除到最后要检查剩下的是否有效！
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<a.size(); i++) {
            if (count[0][1] > 0 && a.get(i) == count[0][0]) {
                count1++;
            }

            if (count[1][1] > 0 && a.get(i) == count[1][0]) {
                count2++;
            }
        }

        return (count1 > a.size()/3)?count[0][0] : (count2 > a.size()/3?count[1][0]: -1);
    }
}
