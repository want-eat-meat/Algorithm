//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
// 示例 1:
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//
//
// 示例 2:
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
//
// Related Topics 数组
package 算法集合51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 0ms
 * 37.3MB
 */
public class _54_螺旋矩阵 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(a));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row;
        int col;
        int top = 0;
        int right = matrix[0].length - 1;
        int left = 0;
        int bottom = matrix.length - 1;
        while(top <= bottom && left <= right){
            for(row = left; row <= right; row++){
                result.add(matrix[top][row]);
            }
            for(col = top + 1; col <= bottom; col++){
                result.add(matrix[col][right]);
            }
            if(left < right && top < bottom) {
                for (row = right - 1; row > left; row--) {
                    result.add(matrix[bottom][row]);
                }
                for (col = bottom; col > top; col--) {
                    result.add(matrix[col][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
