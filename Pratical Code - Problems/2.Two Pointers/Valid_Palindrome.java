/*
 * 
 * Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
class Valid_Palindrome
{
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(s);
    }
    public boolean isPalindrome(String s) {
        int i =0,j = s.length()-1;
       while(i<j){
           char a = s.charAt(i);
           char b = s.charAt(j);
           if(a>='A' && a<='Z'){
               a = (char)(a+32);
           }
           if(b>='A' && b<='Z'){
               b = (char)(b+32);
           }
           if(!(a >= '0' && a <= '9' || a>='a' && a<='z')){
               i++;
               continue;
           }
           if(!(b >= '0' && b <= '9' ||b>='a' && b<='z')){
               j--;
               continue;
           }
           if(a!=b){
               return false;
           }
           i++;
           j--;
       }
       return true;
   }
}