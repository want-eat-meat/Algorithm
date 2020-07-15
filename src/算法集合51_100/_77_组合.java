//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
package 算法集合51_100;

import java.util.ArrayList;
import java.util.List;
/**
 * 回溯
 * 23ms
 * 40.9MB
 */
public class _77_组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combine(res, n, k, list, 1);
        System.out.println(res);
        return res;
    }

    private void combine(List<List<Integer>> res, int n, int k, List<Integer> list, int start) {
        if(k == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            combine(res, n, k - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
