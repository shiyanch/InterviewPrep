package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shiyanch on 12/26/16.
 */
public class MaximumConsecutiveGap {
    public int maximumGap(final List<Integer> a) {
        if (a == null || a.size() < 2) {
            return 0;
        }
        int minEle = a.get(0);
        int maxEle = a.get(0);
        List<Integer>[] buckets = new List[a.size()-1];

        for (int i=0; i<a.size(); i++) {
            int num = a.get(i);
            if (i < a.size()-1) {
                buckets[i] = new ArrayList<>();
            }
            minEle = Math.min(minEle, num);
            maxEle = Math.max(maxEle, num);
        }

        int gap = (int) Math.ceil((double)(maxEle-minEle)/(a.size()-1));
        int[] bucketsMin = new int[a.size()-1];
        int[] bucketsMax = new int[a.size()-1];
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);

        for (int num : a) {
            if (num == maxEle || num == minEle) {
                continue;
            }

            int index = (num - minEle)/gap;
            bucketsMax[index] = Math.max(bucketsMax[index], num);
            bucketsMin[index] = Math.min(bucketsMin[index], num);
        }

        int maxGap = 0;
        int prev = minEle;

        for (int i=0; i<a.size()-1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMin[i] - prev);
            prev = bucketsMax[i];
        }

        return Math.max(maxGap, maxEle - prev);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumConsecutiveGap().maximumGap(Util.MyUtil.makeList(new int[] {0, 100})));
    }
}
