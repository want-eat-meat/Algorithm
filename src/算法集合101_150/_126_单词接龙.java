//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换后得到的单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回一个空列表。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
// Related Topics 广度优先搜索 数组 字符串 回溯算法
// 👍 311 👎 0
package 算法集合101_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _126_单词接龙 {
    private List<List<String>> result = new ArrayList<>();
    private Map<String, List<String>> map = new HashMap<>();
    private List<String> list = new ArrayList<>();
    private boolean isFound;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) {
            return result;
        }
        list.add(beginWord);
        map.put(beginWord, new ArrayList<>());
        for(String str : wordList){
            if(isMatch(beginWord, str)){
                map.get(beginWord).add(str);
                wordList.remove(str);
            }
        }
        //递归查找

        return result;
    }

    /**
     * 判断两个字符串能否相连
     * @param s1
     * @param s2
     * @return
     */
    private boolean isMatch(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            diff += s1.charAt(i) == s2.charAt(i) ? 0 : 1;
        }
        return  diff == 1;
    }
}
