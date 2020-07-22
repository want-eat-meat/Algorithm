//给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
//
// 下图是字符串 s1 = "great" 的一种可能的表示形式。
//
//     great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
//
//
// 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
//
// 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
//
//     rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
//
//
// 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
//
// 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
//
//     rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
//
//
// 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
//
// 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
//
// 示例 1:
//
// 输入: s1 = "great", s2 = "rgeat"
//输出: true
//
//
// 示例 2:
//
// 输入: s1 = "abcde", s2 = "caebd"
//输出: false
// Related Topics 字符串 动态规划
package 算法集合51_100;

/**
 * 动态规划
 * 我是垃圾
 * 8ms
 * 39.9MB
 */
public class _87_扰乱字符串 {
    public boolean isScramble(String s1, String s2) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int len1 = s1.length();
            int len2 = s2.length();
            if(len1 != len2) return false;

            boolean[][][] dp = new boolean[len1][len2][len1 + 1];

            for(int i = 0; i < len1; i++){
                for(int j = 0; j < len2; j++){
                    dp[i][j][1] = c1[i] == c2[j];
                }
            }
            for(int len = 2; len <= len1; len++){
                for(int i = 0; i <= len1 - len; i++){
                    for(int j = 0; j <= len1 - len; j++){
                        for(int k = 1; k < len; k++){
                            if(dp[i][j][k] && dp[i + k][j + k][len - k]){
                                dp[i][j][len] = true;
                                break;
                            }else if(dp[i][j + len - k][k] && dp[i + k][j][len - k]){
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
        return dp[0][0][len1];
    }
}
