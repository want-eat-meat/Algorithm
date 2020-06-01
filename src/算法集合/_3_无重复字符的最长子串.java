package 算法集合;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 ){
            return 0;
        }
        char[] windows = new char[128];
        int left = 0 , right = 0;
        int maxlength = 0;

        while(right< s.length()){
            char ch = s.charAt(right);
            windows[ch]++;
            while (windows[ch] > 1){
                char ch1 = s.charAt(left);
                windows[ch1]--;
                left++;
            }
            maxlength = Math.max(right - left+1 , maxlength);
            right++;
        }
        return maxlength;
    }
}
