package BinarySearch;

/**
 * Created by shiyanch on 12/30/16.
 */
public class SquareRootOfInteger {
    public int sqrt(int a) {
        int left=1,right=a;
        while (left <= right) {
            long mid = left + (right-left)/2;
            long sum = mid * mid;
            if (sum == a) {
                return (int)mid;
            }
            else if (sum < a) {
                left = (int)mid+1;
            }
            else {
                right = (int)mid-1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(new SquareRootOfInteger().sqrt(2147483647));
    }
}
