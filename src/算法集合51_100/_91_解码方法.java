//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划
package 算法集合51_100;

/**
 * 动态规划
 * 1ms
 * 37.8MB
 */
public class _91_解码方法 {
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len + 1];
        if(len == 0) return 0;
        dp[0] = 1;
        if(c[0] == '0'){
            return 0;
        }
        dp[1] = 1;
        for(int i = 1; i < len; i++){
            if(c[i] == '0'){
                if(c[i-1] == '1' || c[i-1] == '2'){
                    dp[i + 1] = dp[i - 1];
                }else{
                    return 0;
                }
            }else{
                dp[i+1] = dp[i];
                if(c[i - 1] != '0' && (c[i-1] == '1' || (c[i - 1] == '2'&& c[i] <= '6'))){
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[len];
    }
}
