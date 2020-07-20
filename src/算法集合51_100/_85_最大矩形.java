//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 示例:
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
/*
[1, 0, 1, 0, 0]
[1, 0, 1, 2, 3]
[1, 2, 3, 4, 5]
[1, 0, 0, 1, 0]
 */
//]
//输出: 6
// Related Topics 栈 数组 哈希表 动态规划
package 算法集合51_100;

/**
 * 动态规划
 * 6ms
 * 42.7MB
 */
public class _85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        int col = matrix.length;
        if (col == 0) return result;
        int row = matrix[0].length;
        if (row == 0) return result;
        int[][] rowLen = new int[col][row];
        for (int i = 0; i < col; i++) {
            rowLen[i][0] = matrix[i][0] == '0' ? 0 : 1;
        }
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                if (matrix[i][j] != '0') {
                    rowLen[i][j] = 1 + rowLen[i][j - 1];
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int c = i;
                int min = rowLen[i][j];
                while( c>=0 ){
                    if(rowLen[c][j] != 0){
                        min = Math.min(min, rowLen[c][j]);
                        int area = (i - c + 1) * min;
                        result = area > result ? area : result;
                        c--;
                    }else{
                        break;
                    }
                }
            }
        }
        return result;
    }
}
