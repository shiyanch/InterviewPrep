package Array.SimulationArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Programming / Arrays / Spiral Order Matrix I
 *
 * Given a matrix of m * n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 */
public class SpiralOrderMatrixI {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(a == null || a.size() == 0 || a.get(0) == null)
            return res;

        int status = 1;
        int count = 1;
        int i=0,j=0;
        int m = a.size();
        int n = a.get(0).size();

        int[][] visited = new int[m][];
        for(int t=0;t<m;t++) {
            visited[t] = new int[n];
        }

        res.add(a.get(0).get(0));
        visited[0][0] = 1;
        while (count < m*n && i>=0 && i<m && j>=0 && j<n) {
            switch (status) {
                case 1:
                    if(j<n-1 && visited[i][j+1] == 0) {
                        res.add(a.get(i).get(++j));
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 2;
                    break;
                case 2:
                    if(i<m-1 && visited[i+1][j] == 0) {
                        res.add(a.get(++i).get(j));
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 3;
                    break;
                case 3:
                    if(j>0 && visited[i][j-1] == 0) {
                        res.add(a.get(i).get(--j));
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 4;
                    break;
                case 4:
                    if(i>0 && visited[i-1][j] == 0) {
                        res.add(a.get(--i).get(j));
                        count++;
                        visited[i][j] = 1;
                    }
                    else
                        status = 1;
                    break;
                default:
                    break;
            }
        }

        return res;
    }
}
