//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
// Related Topics 深度优先搜索 动态规划 回溯算法
// 👍 728 👎 0
package 算法集合101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 12ms
 * 51.3MB
 */
public class _131_分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s== null || s.length() == 0){
            return result;
        }
        dfs(s, result, new ArrayList<String>());

        return result;
    }

    private void dfs(String s, List<List<String>> result, ArrayList<String> strs) {
        if(s.length() == 0){
            result.add(new ArrayList<>(strs));
        }
        for(int i = 1; i <= s.length(); i++){
            String prefix = s.substring(0, i);
            if(isReverseNumber(prefix)) {
                strs.add(prefix);
                dfs(s.substring(i), result, strs);
                strs.remove(strs.size() - 1);
            }
        }
    }

    private boolean isReverseNumber(String prefix) {
        char[] chars = prefix.toCharArray();
        int len = prefix.length();

        for(int i = 0; i < len / 2; i++){
            if(chars[i] != chars[len - i - 1]){
                return false;
            }
        }
        return true;
    }
}
