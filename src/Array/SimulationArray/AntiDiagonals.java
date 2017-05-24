package Array.SimulationArray;

import java.util.ArrayList;

/**
 * Programming / Arrays / Anti Diagonals
 *
 * Give a N*N square matrix,
 * return an array of its anti-diagonals. Look at the example for more details.
 */
public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a == null || a.size() == 0) {
            return result;
        }
        int n = a.size();
        for (int i=0; i<n; i++) {
            ArrayList<Integer> currLine = new ArrayList<Integer>();
            int x=0;
            int y=i;
            while(x<n && y>=0) {
                currLine.add(a.get(x++).get(y--));
            }
            result.add(currLine);
        }

        for (int j=1; j<n; j++) {
            ArrayList<Integer> currLine = new ArrayList<Integer>();
            int x=j;
            int y=n-1;
            while (x<n && y >=0) {
                currLine.add(a.get(x++).get(y--));
            }
            result.add(currLine);
        }

        return result;
    }
}
