//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划
// 👍 565 👎 0
package 算法集合101_150;
import java.util.Arrays;
import java.util.List;

/**
 * 3ms
 * 39.6MB
 */
public class _120_三角形的最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0) == null) return 0;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(List<Integer> list : triangle){
            int last = dp[0];
            for(int i = 0; i < list.size(); i++){
                if(list.size() == 1){dp[i] = list.get(i);}
                else{
                    int temp = dp[i];
                    dp[i] = list.get(i) + Math.min(dp[i], last);
                    last = temp;
                }
            }
        }
        int min = dp[0];
        for(int i = 1; i < dp.length; i++){
            min = min > dp[i] ? dp[i] : min;
        }
        return min;
    }
}
