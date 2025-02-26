/*
 * Ransom Note

Given two strings ransomNote and magazine,
 return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */

public class Ransom_Note
{
    public static void main(String[] args) {
        String  ransomNote = "a", magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
 
     for (char c : ransomNote.toCharArray()) {
       int i = magazine.indexOf(c, alphabet[c - 'a']);
       System.out.println(c+" "+i);
       if (i == -1) {
         return false;
       }
       alphabet[c - 'a'] = i + 1;
     }
     return true;
     }
}