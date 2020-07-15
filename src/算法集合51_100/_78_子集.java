//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法
package 算法集合51_100;

import java.util.ArrayList;
import java.util.List;

public class _78_子集 {
    /**
     * 回溯
     * 1ms
     * 40.2MB
     * @param nums
     * @return
     */
    public  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        subsets(res, 0, len, nums, list);
        return res;
    }

    private void subsets(List<List<Integer>> res, int index, int len, int[] nums, List<Integer> list) {
        res.add(new ArrayList<>(list));
        if(index >= len){
            return;
        }
        for (int i = index; i < len; i++) {
            list.add(nums[i]);
            subsets(res, i + 1, len, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
