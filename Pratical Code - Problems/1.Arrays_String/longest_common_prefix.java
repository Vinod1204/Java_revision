/*
 * Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
 */


public class longest_common_prefix{
        public static String longestCommonPrefix(String[] strs) {
            if(strs.length==1)
        {
            return strs[0];
        }
        if(strs.length==0)
        {
            return "";
        }
        String base=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            while(strs[i].indexOf(base)!=0)
            {
                base=base.substring(0,base.length()-1);
                if(base.isEmpty())
                {
                    return "";
                }
            }
        }
        return base;
        }
    
        public static void main(String[] args) {
    
            String[] input1 = {"flower", "flow", "flight"};
            System.out.println("Output 1: " + longestCommonPrefix(input1)); // Expected Output: "fl"
    
            String[] input2 = {"ab", "a"};
            System.out.println("Output 2: " + longestCommonPrefix(input2)); // Expected Output: ""
        }
    }