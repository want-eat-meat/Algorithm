//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。
//
// 说明：
//
//
// 分隔时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
//
//
// 示例 2：
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
//
package 算法集合101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划
 * 1ms
 * 36.1Mb
 */
public class _140_单词拆分II {
    private  boolean[][] match;
    public  List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        match = new boolean[len][len];

        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                match[i][j] = wordDict.contains(s.substring(i, j + 1));
            }
        }
        dfs(result, new StringBuilder(s),len - 1);
        return result;
    }

    private  void dfs(List<String> result, StringBuilder str, int end) {
        if(end < 0){
            result.add(str.toString().substring(1));
        }
        for(int i = end; i >= 0; i--){
            if(match[i][end]){
                str.insert(i, ' ');
                dfs(result, str, i - 1);
                str.deleteCharAt(i );
            }
        }
    }
}
