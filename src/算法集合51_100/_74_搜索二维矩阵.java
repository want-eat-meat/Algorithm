//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
// 示例 1:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//
//
// 示例 2:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false
// Related Topics 数组 二分查找
package 算法集合51_100;

/**
 * 二分查找
 * 0ms
 * 39.6MB
 */
public class _74_搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }
        int start = 0;
        int n = matrix[0].length;
        int end = matrix.length * matrix[0].length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int val = matrix[mid / n][mid % n];
            if(val == target){
                return true;
            }else if(val > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
}
