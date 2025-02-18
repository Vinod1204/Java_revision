public class  Minimum_Window_Substring
{
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int count = t.length();
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            if (map[s.charAt(right++)]-- > 0) count--;
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                if (map[s.charAt(left++)]++ == 0) count++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
}
}