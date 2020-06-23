package 算法集合1_50;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串

/**
 * 0ms
 * 37.8MB
 */
public class _14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) {return "";}
        String result = strs[0];
        int i = result.length() - 1;
        for(String str : strs){
            while(str.indexOf(result) != 0){
                result = result.substring(0, i--);
            }
        }
        return result;
    }
}
