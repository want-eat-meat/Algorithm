//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
//
//
// 序列中第一个单词是 beginWord 。
// 序列中最后一个单词是 endWord 。
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典 wordList 中的单词。
//
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。
//
//
// 示例 1：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
//
//
// 示例 2：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。
//
//
//
// 提示：
//
//
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord、endWord 和 wordList[i] 由小写英文字母组成
// beginWord != endWord
// wordList 中的所有字符串 互不相同
//
// Related Topics 广度优先搜索
// 👍 759 👎 0
package 算法集合101_150;

import java.util.*;

/**
 * 广度优先搜索
 * 73ms
 * 41.5MB
 */
public class _127_单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 0;
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)){
            return step;
        }
        words.remove(beginWord);

        //建图
        //存储每个单词在第几步被用到，便于被同一步其他单词做为源
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, step++);
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

                        if(!words.contains(nextWord)){
                            continue;
                        }
                        words.remove(nextWord);
                        queue.offer(nextWord);
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
        return found ? step : 0;
    }
}
