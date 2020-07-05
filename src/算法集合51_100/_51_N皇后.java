//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ）
//
// Related Topics 回溯算法
package 算法集合51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 * 4ms
 * 40MB
 */
public class _51_N皇后 {
    public List<List<String>> solveNQueens(int n) {
        char[][] plant = new char[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                plant[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        callBack(plant, n, result, 0);
        for(List list : result){
            System.out.println(list);
        }
        return result;
    }

    private void callBack(char[][] plant, int n, List<List<String>> result, int row) {
        int col = 0;
        while(col < n){
            if(canPlant(plant, row, col, n)){
                plant[row][col] = 'Q';
                if(row == n - 1){
                    List<String> list = new ArrayList();
                    for(int i = 0; i < n; i++) {
                        list.add(String.valueOf(plant[i]));
                    }
                    result.add(new ArrayList<>(list));
                }else{
                    callBack(plant, n, result, row + 1);
                }
                plant[row][col] = '.';
            }
            col++;
        }
    }

    private boolean canPlant(char[][] plant, int row, int col, int n) {
        for(int i = 0; i < n; i++){
            if(plant[i][col] == 'Q' || plant[row][i] == 'Q'){
                return false;
            }
        }
        int i = row;
        int j = col;
        while(i >= 0 && i < n && j >= 0 && j < n){
            if(plant[i--][j--] == 'Q'){
                return false;
            }
        }
        i = row;
        j = col;
        while(i >= 0 && i < n && j >= 0 && j < n){
            if(plant[i--][j++] == 'Q'){
                return false;
            }
        }
        i = row;
        j = col;
        while(i >= 0 && i < n && j >= 0 && j < n){
            if(plant[i++][j--] == 'Q'){
                return false;
            }
        }
        i = row;
        j = col;
        while(i >= 0 && i < n && j >= 0 && j < n){
            if(plant[i++][j++] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
