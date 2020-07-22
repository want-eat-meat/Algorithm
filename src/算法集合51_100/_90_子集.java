//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法
package 算法集合51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 * 2ms
 * 40.1 MB
 */
public class _90_子集 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums.length == 0) return result;
        Arrays.sort(nums);
        callBack(nums, result, 0, new ArrayList<>());
        return result;
    }

    private static void callBack(int[] nums, List<List<Integer>> result, int index, List<Integer> list) {
        if(index == nums.length){
            return;
        }
        for(int i = index;i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            callBack(nums, result, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
