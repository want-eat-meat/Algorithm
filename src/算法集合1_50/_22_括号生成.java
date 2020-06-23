package 算法集合1_50;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法

/**
 * 深度优先搜索
 * 1ms
 * 39.7MB
 */
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        rst("", n, n, result);
        return result;
    }

    public void rst(String str, int leftNum, int rightNum, List<String> res){
        if(leftNum == 0 && rightNum == 0){
            res.add(str);
            return;
        }
        if(rightNum < leftNum){
            return;
        }
        if(leftNum > 0){
            rst(str + "(", leftNum - 1, rightNum, res);
        }
        if(rightNum > 0){
            rst(str + ")", leftNum, rightNum -1, res);
        }
    }
}
