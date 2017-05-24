package Array.SimulationArray;

import java.util.ArrayList;

/**
 * Programming / Arrays / Kth Row Of Pascal's Triangle
 *
 * Given an index k, return the kth row of the Pascal’s triangle.
 * Pascal’s triangle : To generate A[C] in row R,
 * sum up A’[C] and A’[C-1] from previous row R - 1.
 */
public class KthRowOfPascalTriangle {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i=1; i<=a; i++) {
            int size = res.size();

            res.add(1);
            for (int j=0; j<size-1; j++) {
                res.add(res.get(j)+res.get(j+1));
            }
            res.add(1);

            while(size-- > 0) {
                res.remove(0);
            }
        }

        return res;
    }
}
