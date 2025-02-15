/*
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * example:1
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * 
 * example:2    
 * Input: s = 4, nums = [1,4,4]
 * Output: 1
 * 
 * example:3
 * Input: s = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= s <= 10^5
 * 
 * 
 */
public  class minimum_size_subarray_sum
{
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(right < n)
        {
            sum += nums[right];
            while(sum >= s)
            {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums));
    }
}