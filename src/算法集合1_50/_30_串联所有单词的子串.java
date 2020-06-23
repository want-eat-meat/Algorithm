package 算法集合1_50;

import java.util.*;

//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
//
//
//
// 示例 1：
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//
//
// 示例 2：
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
//
// Related Topics 哈希表 双指针 字符串

/**
 * 325ms
 * 40.2MB
 */
public class _30_串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int length = s.length();
        int size = words[0].length() * words.length;
        if(length < size){return result;}
        Map<String, Integer> maps = new HashMap<>(words.length);
        for(String str : words){
            if(maps.containsKey(str)){
                maps.replace(str, maps.get(str) + 1);
            }else{
                maps.put(str, 1);
            }
        }
        System.out.println(length - size + 1);
        for(int i = 0; i < length - size + 1; i++){
            Map<String, Integer> puts = new HashMap<>(words.length);
            if(contain(s.substring(i, i + size), maps, puts,words[0].length())){
                System.out.println(s.substring(i, i + size));
                result.add(i);
            }
        }
        return result;
    }

    private boolean contain(String res, Map<String, Integer> words, Map<String, Integer> puts, int len) {
        if(res.length() == 0){
            return (words.equals(puts));
        }
        String str = res.substring(0, len);
        if(words.containsKey(str)){
            if(puts.containsKey(str)){
                puts.replace(str, puts.get(str) + 1);
            }else{
                puts.put(str, 1);
            }
        }else{
            return false;
        }
        return contain(res.substring(len), words, puts, len);
    }
}
