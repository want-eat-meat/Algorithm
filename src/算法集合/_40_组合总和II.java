//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法
package 算法集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3ms
 * 40.1MB
 */
public class _40_组合总和II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > start && candidates[i] == candidates[i -1]){
                continue;
            }
            now.add(candidates[i]);
            combination(candidates, result, target - candidates[i], i + 1, now);
            now.remove(now.size() - 1);
        }
    }
}
