/*
 * Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An anagram of a string is produced by rearranging all the characters of the string.
Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

public class valid_anagram
{
    public static void main(String[] args)
    {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count=new int[26];

        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        
        for(char c:t.toCharArray()){
          count[c-'a']--;
        }


        for(int val:count){
            if(val !=0){
                return false;
            }
        }

        return true;
    }
}