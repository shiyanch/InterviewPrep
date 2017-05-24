package Array.ArrayMath;

import java.util.ArrayList;

/**
 * Programming / Arrays / Min Steps In Infinite Grid
 *
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points.
 * Give the minimum number of steps in which you can achieve it.
 * You start from the first point.
 */
public class MinStepsInInfiniteGrid {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if (X.size() == 0 || Y.size() == 0) {
            return 0;
        }
        int sum = 0;
        int lastX = X.get(0);
        int lastY = Y.get(0);
        for (int i=1; i<X.size(); i++) {
            sum += Math.max(Math.abs(X.get(i)-lastX), Math.abs(Y.get(i)-lastY));
            lastX = X.get(i);
            lastY = Y.get(i);
        }
        return sum;
    }
}
