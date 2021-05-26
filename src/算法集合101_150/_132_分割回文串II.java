//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//
// 返回符合要求的 最少分割次数 。
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：0
//
//
// 示例 3：
//
//
//输入：s = "ab"
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2000
// s 仅由小写英文字母组成
//
//
//
// Related Topics 动态规划
// 👍 431 👎 0
package 算法集合101_150;

import java.util.Arrays;

/**
 * 37ms
 * 39.7MB
 */
public class _132_分割回文串II {
    public int minCut(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        int len = s.length();
        boolean[][] pd = new boolean[len][len];

        for(int i = 0; i < len; i++){
            Arrays.fill(pd[i], Boolean.TRUE);
        }

        for(int i = len - 1; i >= 0; --i){
            for(int j = i + 1; j < len; ++j){
                pd[i][j] = s.charAt(i) == s.charAt(j) && pd[i + 1][j - 1];
            }
        }
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i < len; i++){
            if(pd[0][i]){
                dp[i] = 0;
            }else{
                for(int j = 0; j < i; j++){
                    if(pd[j + 1][i]){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
