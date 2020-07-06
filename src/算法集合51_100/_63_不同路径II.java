//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 说明：m 和 n 的值均不超过 100。
//
// 示例 1:
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
// Related Topics 数组 动态规划
package 算法集合51_100;

/**
 * 动态规划
 * 0ms
 * 39.4MB
 */
public class _63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;

        int[][] res = new int[m][n];
        int fillFlag = 1;
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                fillFlag = 0;
            }
            res[i][0] = fillFlag;
        }
        fillFlag = 1;
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                fillFlag = 0;
            }
            res[0][i] = fillFlag;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++ ){
                if(obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                }else{
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
}
