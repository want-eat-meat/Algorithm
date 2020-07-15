//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
//
// 示例：
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//
// 说明：
//
//
// 如果 S 中不存这样的子串，则返回空字符串 ""。
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
package 算法集合51_100;

/**
 * 双指针
 * 4ms
 * 40.1MB
 */
public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 == 0 || len1 < len2){
            return "";
        }
        int[] need = new int[128];
        int[] has = new int[128];
        for(char c : t.toCharArray()){
            need[c]++;
        }
        int min_size = len1 + 1;
        int left = 0;
        int right = 0;
        int count = 0;
        String res = "";
        while(right < len1){
            char c = s.charAt(right);
            has[c]++;
            if(need[c] > 0 && need[c] >= has[c]){
                count++;
            }
            while(count == len2){
                char lc = s.charAt(left);
                if(need[lc] > 0 && need[lc] >= has[lc]){
                    count--;
                }
                if(right - left + 1 < min_size){
                    min_size = right - left + 1;
                    res = s.substring(left, min_size + left);
                }
                has[lc]--;
                left++;
            }
            right++;
        }
        return res;
    }
}
