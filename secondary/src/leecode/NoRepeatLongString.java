package leecode;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatLongString {

    public static void main(String[] args) {
        System.out.printf("" + lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
