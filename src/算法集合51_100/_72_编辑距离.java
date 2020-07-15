//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
// Related Topics 字符串 动态规划
package 算法集合51_100;

public class _72_编辑距离 {
    /**
     * 动态规划
     * 6ms
     * 40.1MB
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] res = new int[len2 + 1][len1 + 1];
        for(int i = 0; i <= len2; i++){
            res[i][0] = i;
        }
        for(int i = 0; i <= len1; i++){
            res[0][i] = i;
        }
        for(int i = 1; i <= len2; i++){
            for(int j = 1; j <= len1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    res[i][j] = res[i - 1][j - 1];
                }else {
                    res[i][j] = Math.min(Math.min(res[i - 1][j - 1], res[i - 1][j]), res[i][j - 1]) + 1;
                }
            }
        }
        return res[len2][len1];
    }
}
