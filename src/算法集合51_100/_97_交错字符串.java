//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
//
//
// 示例 1：
//
// 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
//
//
// 示例 2：
//
// 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// Related Topics 字符串 动态规划
// 👍 314 👎 0
package 算法集合51_100;

/**
 * 动态规划
 * 5ms
 * 37.7MB
 */
public class _97_交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3){
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len1; i++){
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for(int i = 1; i <= len2; i++){
            dp[0][i] = dp[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        }
        for(int i = 2; i <= len3; i++){
            for(int j = (i > len1 ? len1 : i-1 ); j >= 1 && i-j <= len2; j--){
                dp[j][i-j] = (dp[j-1][i-j] && s1.charAt(j-1)== s3.charAt(i-1)) || (dp[j][i-j-1] && s2.charAt(i-j-1)==s3.charAt(i-1));
            }
        }
        return dp[len1][len2];
    }
}
