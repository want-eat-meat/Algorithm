//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
//
//
// 两个字符串完全匹配才算匹配成功。
//
// 说明:
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
//
//
// 示例 3:
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//
//
// 示例 4:
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
//
//
// 示例 5:
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false
// Related Topics 贪心算法 字符串 动态规划 回溯算法
package 算法集合;

public class _44_通配符匹配 {
    /**
     * 动态规划
     * 19ms
     * 40.2MB
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if(p.equals("*") || s.equals(p)){
            return true;
        }
        if(p == null || s == null){
            return false;
        }
        boolean[][] match = new boolean[pLen + 1][sLen + 1];
        match[0][0] = true;
        for(int pi = 1; pi <= pLen; pi++){
            int si = 1;
            if(p.charAt(pi - 1) == '*'){
                while((!match[pi - 1][si - 1]) && si <= sLen){
                    si++;
                }
                match[pi][si - 1] = match[pi - 1][si - 1];
                while(si <= sLen){
                    match[pi][si++] = true;
                }
            } else if(p.charAt(pi - 1) == '?'){
                while(si <= sLen){
                    match[pi][si] = match[pi - 1][si - 1];
                    si++;
                }
            } else{
                while(si <= sLen){
                    match[pi][si] = match[pi - 1][si - 1] && p.charAt(pi - 1) == s.charAt(si - 1);
                }
            }
        }
        return match[pLen][sLen];
    }

    /**
     * 递归
     * 超时，用HashSet记录'*'出现的位置，出现连续的'*'时去重
     * @param s
     * @param p
     * @return
     */
    /*
    public static boolean isMatch(String s, String p) {
        if(s.length() == 0){
            if(p.length() == 0){
                return true;
            }else{
                for(int i = 0; i < p.length(); i++){
                    if(p.charAt(i) != '*'){
                        return false;
                    }
                }
                return true;
            }
        }
        if(p.length() == 0 && s.length() > 0){
            return false;
        }
        int c1 = s.charAt(0);
        int c2 = p.charAt(0);
        if(c1 == c2 || c2 == '?'){
            return isMatch(s.substring(1), p.substring(1));
        }else if(c2 == '*'){
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        }else{
            return false;
        }
    }
    */
}
