/*
 *  Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match,
 such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false

 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space
 */

import java.util.HashMap;
import java.util.Map;

public class word_pattern
{
    public static void main(String[] args)
    {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
    public static  boolean wordPattern(String pattern, String s) {
        Map<Character, String> chartoword = new HashMap<>();
       Map<String, Character> wordtochar = new HashMap<>();
       String[] str=s.split(" ");
       if(pattern.length()!=str.length)
       {
        return false;
       }
       for(int i=0;i<pattern.length();i++)
       {
          char ch=pattern.charAt(i);
          if(!chartoword.containsKey(ch))
          {
            chartoword.put(ch,str[i]);
          }
          if(!wordtochar.containsKey(str[i]))
          {
            wordtochar.put(str[i],ch);
          }
          if(!chartoword.get(ch).equals(str[i]) || !wordtochar.get(str[i]).equals(ch))
          {
            return false;
          }
       } 
       return true;
    }
}
