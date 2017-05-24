package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shiyanch on 1/1/17.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String a) {
        int left=0, right=0;
        Set<Character> set = new HashSet<Character>();
        int longest = 1;
        while (right < a.length()) {
            while (right < a.length() && !set.contains(a.charAt(right))) {
                set.add(a.charAt(right));
                right++;
            }

            longest = Math.max(longest, right-left);
            if (right == a.length()) {
                return longest;
            }
            //longest = Math.max(longest, right-left);

            while(left<right && set.contains(a.charAt(right))) {
                set.remove(a.charAt(left++));
            }
            set.add(a.charAt(right));
            right = right+1;
        }

        return longest;

    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("abcdbav"));
    }
}
