//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
//
//
//
// 示例:
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]
// Related Topics 字符串 回溯算法
package 算法集合51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 2ms
 * 38.5MB
 */
public class _93_复原IP地址 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            return result;
        }
        rollBack(result, s, 0, new StringBuilder());
        return result;
    }

    private void rollBack(List<String> result, String s, int number, StringBuilder str) {
        if(s.length() == 0){
            if(number == 4){
                result.add(str.substring(0, str.length() - 1));
            }
            return;
        }

        for(int i = 1; i <=3 && i <= s.length(); i++){
            String t = s.substring(0, i);
            str.append(t);
            str.append(".");
            if(s.length() - i <= 3 * (3 - number) && (t.charAt(0)!='0' || t.length() == 1) && (t.charAt(0) < '3' || t.length() < 3) && Integer.parseInt(t) <= 255){
                rollBack(result, s.substring(i), number + 1, str);
            }
            str.deleteCharAt(str.length() - 1);
            str.delete(str.length() - i, str.length());
        }
    }

}
