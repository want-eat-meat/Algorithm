//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 264 👎 0
package 算法集合101_150;

/**
 * 双指针
 * 5ms
 * 40.4MB
 */
public class _125_验证回文串 {
    public boolean isPalindrome(String s) {
        if("".equals(s)){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i)) ){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(!s.substring(i, i + 1).equalsIgnoreCase(s.substring(j, j + 1))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
