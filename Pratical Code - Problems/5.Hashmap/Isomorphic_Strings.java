/*
 * Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

 

Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

Example 2:
Input: s = "foo", t = "bar"
Output: false
Explanation:
The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:
Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

import java.util.HashMap;

public class Isomorphic_Strings
{
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(IsIsomorphic(s, t));
    }
    public static boolean IsIsomorphic(String s, String t)
    {
        HashMap<Character,Character> map1=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++)
        {
            if(map1.containsKey(s.charAt(i)) && map1.get(s.charAt(i))!=t.charAt(i))  return false;
            map1.put(s.charAt(i),t.charAt(i));
        }
        HashMap<Character,Character> map2=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            if(map2.containsKey(t.charAt(i))&& map2.get(t.charAt(i))!=s.charAt(i)) return false;
            map2.put(t.charAt(i),s.charAt(i));
        }
        return true;
    }

}
