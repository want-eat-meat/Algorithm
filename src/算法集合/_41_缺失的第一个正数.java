//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//
//
//
// 示例 1:
//
// 输入: [1,2,0]
//输出: 3
//
//
// 示例 2:
//
// 输入: [3,4,-1,1]
//输出: 2
//
//
// 示例 3:
//
// 输入: [7,8,9,11,12]
//输出: 1
//
//
//
//
// 提示：
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
// Related Topics 数组
package 算法集合;

/**
 * 1ms
 * 37.7MB
 */
public class _41_缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int i = 0;
        while(i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length ) {
                if (i != nums[i] - 1 && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    i++;
                }
            }else{
                nums[i] = 0;
                i++;
            }
        }
        i = 0;
        while(i < nums.length){
            if(nums[i] != ++i){
                break;
            }
        }
        if(i == nums.length && i == nums[nums.length - 1]){
            i++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
