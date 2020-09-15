//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是）
//
// 题目数据保证答案符合 32 位带符号整数范围。
//
//
//
// 示例 1：
//
// 输入：S = "rabbbit", T = "rabbit"
//输出：3
//解释：
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
//
//
// 示例 2：
//
// 输入：S = "babgbag", T = "bag"
//输出：5
//解释：
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
// Related Topics 字符串 动态规划
// 👍 233 👎 0
package 算法集合101_150;

import javax.sound.midi.Soundbank;

public class _115_不同的子序列 {
    /**
     * 动态规划
     * 13ms
     * 39.6MB
     * @param s
     * @param t
     * @return
     */
   /* public static int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return 0;
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen][tLen];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for(int i = 1; i < sLen; i++){
            dp[i][0] = dp[i-1][0] + (s.charAt(i)==t.charAt(0) ? 1 : 0);
        }
        for(int j = 1; j < tLen; j++){
            for(int i = j; i < sLen; i++){
                dp[i][j] = dp[i-1][j] + (s.charAt(i)==t.charAt(j) ? dp[i-1][j-1] : 0);
            }
        }
        return dp[sLen - 1][tLen - 1];
    }*/

    /**
     * 一维动态规划
     * 7ms
     * 37.5MB
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return 0;
        int sLen = s.length();
        int tLen = t.length();
        if(sLen < tLen) return 0;
        int[] dp = new int[sLen];
        dp[0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for(int i = 1; i < sLen; i++){
            dp[i] = dp[i-1] + (s.charAt(i)==t.charAt(0) ? 1 : 0);
        }
        for(int j = 1; j < tLen; j++){
            int pre = 0;
            int temp = dp[j - 1];
            for(int i = j; i < sLen; i++){
                int last = temp;
                temp = dp[i];
                dp[i] = pre + (s.charAt(i) == t.charAt(j) ? last : 0);
                pre = dp[i];
            }
        }
        return dp[sLen - 1];
    }
}
