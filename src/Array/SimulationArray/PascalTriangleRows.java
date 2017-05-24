package Array.SimulationArray;

import java.util.ArrayList;

/**
 * Programming / Arrays / Pascal Triangle Rows
 *
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 */
public class PascalTriangleRows {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        if (a == 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for (int i=1; i<a; i++) {
            ArrayList<Integer> currRow = new ArrayList<>();
            ArrayList<Integer> lastRow = res.get(res.size()-1);

            currRow.add(1);
            for (int j=0; j<lastRow.size()-1; j++) {
                currRow.add(lastRow.get(j)+lastRow.get(j+1));
            }
            currRow.add(1);
            res.add(currRow);
        }
        return res;
    }
}
