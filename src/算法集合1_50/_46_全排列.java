//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
package 算法集合1_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *回溯
 * 3ms
 * 40.1MB
 */
public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        permute(result, nums, 0, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void permute(List<List<Integer>> result, int[] nums, int now, ArrayList<Integer> list, HashSet<Integer> set) {
        System.out.println(now);
        if(now == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                list.add(nums[i]);
                permute(result, nums, now + 1, list, set);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}
