//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//
// 示例 1:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
//
//
// 示例 2:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false
//
// 进阶:
//
//
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
//
// Related Topics 数组 二分查找
package 算法集合51_100;

/**
 * 二分搜索
 * 1ms
 * 39.5MB
 */
public class _81_搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        return myBinarySearch(nums, target, left, right);
    }

    private boolean myBinarySearch(int[] nums, int target, int left, int right) {
        if(left > right){
            return false;
        }
        while(left < right &&nums[left] == nums[right] ){
            if(nums[left] == target){
                return true;
            }else{
                left++;
            }
        }
        int mid = left + ((right - left) >> 1);
        //中间值等于目标值
        if(target == nums[mid]){
            return true;
        }//中间值小于目标值
        else if(target > nums[mid]){
            //右边有序
            if(nums[mid] <= nums[right]){
                return binarySearch(nums, target, mid + 1, right) || myBinarySearch(nums, target, left, mid - 1);
            }else{
                return myBinarySearch(nums, target, mid + 1, right) || binarySearch(nums, target, left, mid - 1);
            }
        }//中间值大于目标值
        else{
            //左边有序
            if(nums[mid] >= nums[left]){
                return binarySearch(nums, target, left, mid -1) || myBinarySearch(nums, target, mid + 1, right);
            }else{
                return myBinarySearch(nums, target, left, mid - 1) || myBinarySearch(nums, target, mid + 1, right);
            }
        }
    }

    private boolean binarySearch(int[] nums, int target, int left, int right){
        if(left > right) return false;
        int mid = left + ((right - left) >> 1);
        if(nums[mid] == target){
            return true;
        }else if(nums[mid] > target){
            return binarySearch(nums, target, left, mid -1);
        }else{
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}
