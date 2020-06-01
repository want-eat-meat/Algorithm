package 算法集合;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        String result = "";
        if (s.length() == 0) {
            return "";
        }
        char[] c = s.toCharArray();
        int[] limit = new int[2];
        int i = 0;
        while (i < c.length) {
            i = isPal(c, i, limit);
        }
        result =  s.substring(limit[0], limit[1]);
        return result;
    }

    private static int isPal(char[] c, int start, int[] result) {
        int end = start + 1;

        while ( end < c.length && c[start] == c[end]) {
            end++;
        }
        int temp = end;
        while (start > 0 && end < c.length && c[start - 1] == c[end]) {
            start++;
            end++;
        }
        if (end - start > result[1] - result[0]) {
            result[0] = start;
            result[0] = end;
        }
        return temp;
    }

    /**
     * 自己的垃圾算法
    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        char[] c = s.toCharArray();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j > i; j--){
                if(c[i] == c[j]) {
                    int tempLengh = isPal(c, i, j);
                    if(maxLength < tempLengh){
                        maxLength = tempLengh;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }

    private static int isPal(char[] c, int start, int end){
        int size = 0;
        while(start != end && start < end){
            if (c[++start] == c[--end]) {
                size += 2;
            }else{
                return 0;
            }
        }
        return start == end ? size + 1: size;
    }
    */
}
