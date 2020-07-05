//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
// 示例:
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// Related Topics 数组
package 算法集合51_100;

/**
 * 逐层递进
 * 0ms
 * 37.6MB
 */
public class _59_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                result[top][i] = num++;
            }
            for(int i = top + 1; i <= bottom; i++){
                result[i][right] = num++;
            }
            for(int i = right - 1; i > left; i--){
                result[bottom][i] = num++;
            }
            for(int i = bottom; i > top; i--){
                result[i][left] = num++;
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }
}
