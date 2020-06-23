package 算法集合1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法

/**
 * 1ma
 * 38.5MB
 */
public class _17_电话号码的字母组合 {
    Map<String, String> source = new HashMap<>();
    {
        source.put("2", "abc");
        source.put("3", "def");
        source.put("4", "ghi");
        source.put("5", "jkl");
        source.put("6", "mno");
        source.put("7", "pqrs");
        source.put("8", "tuv");
        source.put("9", "wxyz");
    }
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0){
            combination("", digits);
        }
        return result;
    }

    public void combination(String str, String digits){
        if(digits.length() == 0){
            result.add(str);
        }else{
            String next = digits.substring(0, 1);
            String nextWord = source.get(next);
            for(int i = 0; i < nextWord.length(); i++){
                combination(str + nextWord.substring(i, i + 1), digits.substring(1));
            }
        }

    }
}
