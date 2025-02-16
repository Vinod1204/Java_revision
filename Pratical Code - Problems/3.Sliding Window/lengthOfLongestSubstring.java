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