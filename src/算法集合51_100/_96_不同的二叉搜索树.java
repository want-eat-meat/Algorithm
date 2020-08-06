//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例:
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// Related Topics 树 动态规划
// 👍 743 👎 0
package 算法集合51_100;

/**
 * 动态规划
 * 0ms
 * 36.3MB
 */
public class _96_不同的二叉搜索树 {
    public int numTrees(int n) {
        if(n == 0) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] += dp[i - 1] << 1;
            for(int j = 1; j <= i - 2; j++){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
