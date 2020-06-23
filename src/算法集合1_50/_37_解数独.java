package 算法集合1_50;
//编写一个程序，通过已填充的空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
// 空白格用 '.' 表示。
//
//
//
// 一个数独。
//
//
//
// 答案被标成红色。
//
// Note:
//
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表 回溯算法

/**
 * 回溯
 * 19ms
 * 39.2MB
 */
public class _37_解数独 {
    public void solveSudoku(char[][] board) {
        rollBack(board, 0, 0);
    }

    private boolean rollBack(char[][] board, int row, int col){
        int n = board.length;
        if(col == n){
            return rollBack(board, row + 1, 0);
        }
        if(row == n){
            return true;
        }
        if(board[row][col] != '.'){
            return rollBack(board, row, col + 1);
        }
        for(char i = '1'; i <= '9'; i++){
            if(isContain(board, row, col, i)){
                continue;
            }
            board[row][col] = i;
            if(rollBack(board, row, col + 1)){
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isContain(char[][] board, int row, int col, char target) {
        for (int k = 0; k < 9; k++) {
            // 同一行九个位置已出现 ch
            if (board[row][k] == target) return false;
            // 同一列九个位置中已出现 ch
            if (board[k][col] == target) return false;
            // 同一个子数独九个位置中已出现 ch
            if (board[(row / 3) * 3 + k / 3][(col / 3) * 3 + k % 3] == target) return false;
        }
        return true;
    }
}
