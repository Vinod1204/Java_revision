/*
 * Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams
{
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
      if(strs==null || strs.length==0)
        {
            return null;
        }
        List<List<String>> result=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs)
        {
            char[] chararray=s.toCharArray();
            Arrays.sort(chararray); 
            String key=new String(chararray);
            if(!map.containsKey(key))
            {
                map.put(key,new ArrayList<>());
            }
                map.get(key).add(s);
        }
        for(List<String> s:map.values())
        {
            result.add(s);
        }
        return result;
    }
}