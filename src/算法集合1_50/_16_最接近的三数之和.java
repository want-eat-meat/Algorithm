package 算法集合1_50;

import java.util.Arrays;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
//
// Related Topics 数组 双指针

/**
 * 8ms
 * 39.3MB
 * 双指针
 */
public class _16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < size; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = size - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                result = (Math.abs(target - sum) < Math.abs(target - result)) ? sum : result;
                if (sum < target) { l++; }
                else { r--; }
            }
        }
        return result;
    }
}
