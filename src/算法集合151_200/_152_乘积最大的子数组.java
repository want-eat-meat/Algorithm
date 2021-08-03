//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划
package 算法集合151_200;

/**
 * 动态规划
 *2ms
 * 38.1Mb
 */
public class _152_乘积最大的子数组 {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int lastMax = nums[0];
        int lastMin = nums[0];
        for(int i=1; i<nums.length; i++){
            int nowMax = lastMax * nums[i];
            int nowMin = lastMin * nums[i];
            lastMax = Math.max(nowMax,nums[i]);
            lastMax = Math.max(nowMin,lastMax);
            lastMin = Math.min(nowMax,nums[i]);
            lastMin = Math.min(nowMin,lastMin);
            result =Math.max(lastMax, result);
        }
        return result;
    }
}
