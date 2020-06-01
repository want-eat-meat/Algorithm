package 算法集合;

import java.util.*;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：
//
// 答案中不可以包含重复的四元组。
//
// 示例：
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics 数组 哈希表 双指针

public class _18_四数之和 {
    /**
     * 27ms
     * 40.1MB
     * 双指针
     */
   /* public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList= new ArrayList<>();
        if(nums.length < 4) {return resultList;}
        Arrays.sort(nums);
        int size = nums.length;
        for(int i = 0; i < size - 3; i++){
            if(i - 1 >= 0 && nums[i - 1] == nums[i]){ continue; }
            for(int j = i + 1; j < size - 2; j++){
                if(j - 1 >= 0 && j - 1 != i && nums[j - 1] == nums[j]){ continue; }
                int left = j + 1;
                int right = size - 1 ;
                while(right > left) {
                    int result = nums[i] +nums[j] + nums[left] + nums[right];
                    if (result == target) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (result > target) {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    }
                }
            }
        }
        return resultList;
    }
    */
   /*
   public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<ArrayList<Integer>>> resultMap = new HashMap<>();
    }
    */
}
