/*
 * 
 * Questions:
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 *  representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
import java.util.*;
class MergeSortedArray
{
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int n=3;
        int m=3;
        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;;
        while(p2>=0)
        {
            if(p1>=0 && nums1[p1]>nums2[p2])
            {
                nums1[p--]=nums1[p1--];
            }
            else{
                nums1[p--]=nums2[p2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
/*
----------------------------------------------------
TC = O(m+n)
----------------------------------------------------

 * You can't start pointer from 0 here, i.e. 'mainArrayIndex = 0 ' . Because you are overwriting the values in nums1 that you have to use for comparison later on...
Let me give an example:

nums1 = [3,4,5,0,0,0] , nums2 = [2,5,6] here if index1 = 0 , index2 = 0 and mainArrind = 0.
According to your Code:
Then in first iteration we will have nums1[0] > nums2[0]
so, nums1[mainArrind ] = nums2[0] // i.e. nums1[0] = 2

After first iteration index1 = 0 , index2 =1 ,mainArrind = 1 and our nums1 = [2,4,5,0,0,0]
here we have nums1[0] = 2, and our 3 is missing and we will not be able to compare 3 to others and answer will have 3 missing , similary in following iteration whenever we overwrite any value of nums1 it will be missing in final array.

That's why to avoid this problem start storing the values from lastindex of nums1 that is n+m-1 and decrease it one by one. Because values in last of nums1 are 0 and are not of our use.
 */