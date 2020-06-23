package 算法集合1_50;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 如果数组中不存在目标值，返回 [-1, -1]。
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
// Related Topics 数组 二分查找

/**
 * 二分
 * 0ms
 * 42.9MB
 */
public class _34_排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = searchLitterNumer(nums, target, true);
        if(left == 0 && nums[0] != target){
            return result;
        }
        int right = searchLitterNumer(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int searchLitterNumer(int nums[], int target, boolean left) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
