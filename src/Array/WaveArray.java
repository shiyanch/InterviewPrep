package Array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Programming / Arrays / Wave Array
 *
 * Given an array of integers,
 * sort the array into a wave like array and return it,
 *
 * In other words,
 * arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 */
public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        boolean down = true;
        for (int i=1; i<a.size(); i++) {
            if ((down && a.get(i) > a.get(i-1)) || (!down && a.get(i) < a.get(i-1))) {
                int tmp = a.get(i);
                a.set(i, a.get(i-1));
                a.set(i-1, tmp);
            }
            down = !down;
        }
        return a;
    }
}
