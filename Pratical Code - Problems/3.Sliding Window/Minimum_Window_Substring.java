/*
 * 
 *  Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window substring
 of s such that every character in t (including duplicates) is included in the window.
  If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

public class  Minimum_Window_Substring
{
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int count = t.length();
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            if (map[s.charAt(right++)]-- > 0) count--;
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                if (map[s.charAt(left++)]++ == 0) count++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
}
}