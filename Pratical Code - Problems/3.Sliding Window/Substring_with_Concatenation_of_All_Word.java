 /*
 Substring with Concatenation of All Words
 # https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 Substring with Concatenation of All Words

You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, 
if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
"acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.


Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

 

Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
 
 */
import java.util.*;
public class Substring_with_Concatenation_of_All_Word{
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer>  findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        int wordlength=words[0].length();
        int concatlength=wordlength*words.length;
        Map<String,Integer> wordmap=new HashMap<>();
         for(String word:words)
            {
                wordmap.put(word,wordmap.getOrDefault(word,0)+1);
            }
        for(int i=0;i<s.length()-concatlength+1;i++)
        {
            Map<String,Integer> seenword=new HashMap<>(wordmap);
            boolean invalid=true;;
            String str=s.substring(i,i+concatlength);
            for(int j=0;j<concatlength;j+=wordlength)
            {
             String eachword=str.substring(j,j+wordlength);
             if(seenword.containsKey(eachword) && seenword.get(eachword)>0)
             {
                seenword.put(eachword,seenword.get(eachword)-1);
             }
             else{
                invalid=false;
                break;
             }
            }
            if(invalid)
            {
                result.add(i);
            }
        }
        return result;
    }
}