//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//
// 示例 1:
//
// 输入:
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出:
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//
//
// 示例 2:
//
// 输入:
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出:
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
// 进阶:
//
//
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
// 你能想出一个常数空间的解决方案吗？
//
// Related Topics 数组
package 算法集合51_100;

/**
 * 利用第一行和第一列存储状态
 * 1ms
 * 41.1MB
 */
public class _73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int len1 = matrix.length;
        if (len1 == 0) return;
        int len2 = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < len1; i++) {
            if (matrix[i][0] == 0) {
                col = true;
            }
        }
        for (int i = 0; i < len2; i++) {
            if (matrix[0][i] == 0) {
                row = true;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < len1; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < len2; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < len2; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < len1; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int i = 0; i < len2; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < len1; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
