package 算法集合1_50;
import java.util.ArrayList;
import java.util.List;
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
//
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
// string convert(string s, int numRows);
//
// 示例 1:
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//
//
// 示例 2:
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
// Related Topics 字符串

public class _6_Z型变幻 {
    /**
     * Z型变幻规则，来回赋值，慢一些，但实现简单
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows){
        if(numRows == 1) {return s;}
        List<StringBuffer> rows= new ArrayList<StringBuffer>();
        for(int i = 0; i < Math.min(s.length(), numRows); i++){
            rows.add(new StringBuffer());
        }
        int currentRow = 0;
        boolean isDown = false;
        for(char c : s.toCharArray()){
            rows.get(currentRow).append(c);
            if(currentRow == 0 || currentRow == numRows -1){
                isDown = !isDown;
            }
            currentRow += isDown ? 1 : -1;
        }
        StringBuffer resultBuffer = new StringBuffer();
        for(StringBuffer temps : rows){
            resultBuffer.append(temps);
        }
        return resultBuffer.toString();
    }
    /**
     *自己的,更快，但更麻烦
     * public static String convert(String s, int numRows) {
        String result = new String();
        char[] c = s.toCharArray();
        char[] resultArr = new char[s.length()];
        int step1 = 0;
        int step2 = 0;
        int k = 0;
        for(int i = 0; i < numRows; i++){
            int now = 0;
            int j = i;
            step1 = 2 * (numRows - i - 1);
            step2 = 2 * i;
            while(j < s.length()){
                resultArr[k++] = c[j];
                if(step1 == 0){
                    now = 1;
                    j += step2;
                }else if(step2 == 0){
                    j += step1;
                }else{
                    j += now % 2 == 0 ? step1 : step2;
                    now++;
                }
            }
        }
        result = new String(resultArr);
        return result;
    }
    */
}
