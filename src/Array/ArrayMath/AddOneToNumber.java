package Array.ArrayMath;

import java.util.ArrayList;

/**
 * Programming / Arrays / Add One To Number
 *
 * Given a non-negative number represented as an array of digits,
 * add 1 to the number ( increment the number represented by the digits ).
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 * If the vector has [1, 2, 3]
 * the returned vector should be [1, 2, 4], as 123 + 1 = 124.
 *
 * Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int i = a.size()-1;
        for (; i>=0; i--) {
            if (a.get(i) == 9) {
                a.set(i, 0);
            }
            else {
                a.set(i, a.get(i)+1);
                break;
            }
        }
        if (i < 0) {
            a.add(0,1);
        }
        while (a.get(0) == 0) {
            a.remove(0);
        }

        return a;
    }
}
