package 算法集合1_50;

import java.util.*;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针

/**
 * 24ms
 * 43.6MB
 * 双指针
 */
public class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList= new ArrayList<>();
        if(nums.length < 3) {return resultList;}
        Arrays.sort(nums);
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(i - 1 >= 0 && nums[i - 1] == nums[i]){ continue; }
            int left = i + 1;
            int right = size - 1 ;
            while(right > left){
                int result = nums[i] + nums[left] + nums[right];
                while(left < right && nums[left] == nums[left + 1]){ left++; }
                while(left < right && nums[right] == nums[right - 1]){ right--; }
                if(result == 0){
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                }else if(result > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return resultList;
    }
}
