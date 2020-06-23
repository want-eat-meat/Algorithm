package 算法集合1_50;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法

public class _4_两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenght1 = nums1.length;
        int lenght2 = nums2.length;
        int left = (lenght1 + lenght2 + 1) / 2;
        int right = (lenght1 + lenght2 + 2) / 2;
        return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int findK(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if(start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int midValue1 = (start1 + k/2 - 1) < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int midValue2 = (start2 + k/2 - 1) < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        if(midValue1 < midValue2)
            return findK(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        else
            return findK(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
}
