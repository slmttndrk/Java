package LeetCodeSolutions;

import java.util.HashSet;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();

        int right, left = 0, max = 0;

        for (right = 0; right < s.length(); right++) {
            while(!set.add(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
}
