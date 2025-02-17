/*
 * 
 *  Longest Substring Without Repeating Characters
Given a string s, find the length of the longest 
substring without duplicate characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */


import java.util.HashSet;
public class lengthOfLongestSubstring {
public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
}
public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int left = 0;
    int right = 0;  
    int max = 0;
    HashSet<Character> set = new HashSet<>();
    while (right < n) {
        if (!set.contains(s.charAt(right))) {
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
            right++;
        } else {
            set.remove(s.charAt(left));
            left++;
        }
    }
    return max;   
}
}