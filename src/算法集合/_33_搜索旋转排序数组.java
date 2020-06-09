package 算法集合;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
// 你可以假设数组中不存在重复的元素。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 示例 1:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//
//
// 示例 2:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
// Related Topics 数组 二分查找

/**
 * 1ms
 * 39.3MB
 */
public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target){
        if(nums.length == 0) return -1;
        return myBinarySearch(nums, 0, nums.length - 1, target);
    }

    private int myBinarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if(start >= end) return nums[mid] == target ? mid : -1;
        if(nums[mid] == target) return mid;
        if(nums[start] <= nums[mid]){
            if(target > nums[mid] || target < nums[start]){
                if(nums[mid] < nums[end]) {
                    return binarySearch(nums, mid + 1, end, target);
                }else{
                    return myBinarySearch(nums, mid + 1, end, target);
                }
            }else{
                return binarySearch(nums, start, mid -1, target);
            }
        }else{
            if(target > nums[mid] && target <= nums[end]){
                return binarySearch(nums, mid + 1, end, target);
            }else{
                return myBinarySearch(nums, start, mid - 1, target);
            }
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        int mid = (start + end) / 2;
        if(start == end){
            return nums[mid] == target ? mid : -1;
        }
        if(target > nums[mid]){
            return binarySearch(nums, mid + 1, end, target);
        }else{
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}
