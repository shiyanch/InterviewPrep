package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanch on 1/4/17.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int index = 0;
        int longest = 0;
        int low = 0;

        while (index < s.length()) {
            map.put(s.charAt(index), index++);
            if (map.size() > k) {
                int toRemove = Integer.MAX_VALUE;
                for (char c : map.keySet()) {
                    toRemove = Math.min(toRemove, map.get(c));
                }
                map.remove(s.charAt(toRemove));
                low = toRemove+1;
            }
            longest = Math.max(longest, index-low);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("abaccc", 2));
    }
}
