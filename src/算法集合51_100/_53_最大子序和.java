//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
package 算法集合51_100;

/**
 * 动态规划
 *1ms
 * 39.6MB
 */
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int single = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] > single){
                single = Math.max(single, nums[i - 1]);
            }
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, Math.max(sum, single));
        }
        return result;
    }
}
