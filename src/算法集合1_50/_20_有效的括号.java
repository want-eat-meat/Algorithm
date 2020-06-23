package 算法集合1_50;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

/**
 * 2ms
 * 28MB
 */
public class _20_有效的括号 {
    class Solution {
        public boolean isValid(String s) {
            if(s == null) {return true;}
            Map<Character, Character> brackets = new HashMap<>();
            Stack<Character> stack = new Stack<>();
            brackets.put('(', ')');
            brackets.put('[', ']');
            brackets.put('{', '}');
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);

                if(brackets.containsKey(c)){
                    stack.push(c);
                }else{
                    if(stack.empty()) {return false;}
                    char left = stack.pop();
                    if(brackets.get(left) != c){ return false; }
                }
            }
            return stack.empty();
        }
    }
}
