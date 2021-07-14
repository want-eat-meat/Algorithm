//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 动态规划
package 算法集合101_150;

import java.util.List;

/**
 * 动态规划
 * 4ms
 * 38.3Mb
 */
public class _139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict.isEmpty()){
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len];
        for(int i = 0; i < len; i++){
            String now = s.substring(i, i + 1);
            if(i == 0){
                dp[i] = wordDict.contains(now);
            }else{
                dp[i] = (dp[i - 1] && wordDict.contains(now)) || wordDict.contains(s.substring(0, i + 1));
                if(!dp[i]){
                    for(int j = 0; j < i - 1; j++){
                        if(dp[j]){
                            dp[i] = wordDict.contains(s.substring(j + 1, i + 1));
                            if(dp[i]){
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[len - 1] ;
    }
}
