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

import java.util.*;

/**
 * 13ms
 * 39.2MB
 */
public class _126_单词接龙II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        if(!words.contains(endWord)){
            return result;
        }
        words.remove(beginWord);

        //建图
        //存储每个单词在第几步被用到，便于被同一步其他单词做为源
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, List<String>> from = new HashMap<>();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curWord = queue.poll();
                char[] charArray = curWord.toCharArray();
                for(int j = 0; j < wordLen; j++){
                    char origin = charArray[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if(steps.containsKey(nextWord) && step == steps.get(nextWord)){
                            from.get(nextWord).add(curWord);
                        }
                        if(!words.contains(nextWord)){
                            continue;
                        }
                        words.remove(nextWord);
                        queue.offer(nextWord);
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(curWord);
                        steps.put(nextWord, step);
                        if(nextWord.equals(endWord)){
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
            if(found){
                break;
            }
        }
        //深度优先遍历
        if(found){
            ArrayDeque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, result);
        }
        return result;
    }

    private void dfs(Map<String, List<String>> from, ArrayDeque<String> path, String beginWord, String curWord, List<List<String>> result) {
        if(curWord.equals(beginWord)){
            result.add(new ArrayList<>(path));
            return;
        }
        for(String pre : from.get(curWord)){
            path.addFirst(pre);
            dfs(from, path, beginWord, pre, result);
            path.remove(pre);
        }
    }
}
