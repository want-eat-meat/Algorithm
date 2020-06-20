//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// Related Topics 数组 回溯算法
package 算法集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2ms
 * 40.1MB
 */
public class _39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, result, target, 0, new ArrayList<>());
        return result;
    }

    private void combination(int[] candidates, List<List<Integer>> result, int target, int start,  List<Integer> now) {
        if(target == 0){
            result.add(new ArrayList<>(now));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                break;
            }
            now.add(candidates[i]);
            combination(candidates, result, target - candidates[i], i, now);
            now.remove(now.size() - 1);
        }
    }
}
