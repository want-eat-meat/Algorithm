//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
package 算法集合51_100;

/**
 * 回溯
 * 5ms
 * 42.1MB
 */
public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        int cLen = board.length;
        if(cLen == 0) return false;
        int rLen = board[0].length;
        if(cLen * rLen < word.length()){
            return false;
        }
        boolean[][] road = new boolean[cLen][rLen];
        int col = 0;
        int row = 0;
        while(col < cLen){
            row = 0;
            while(row < rLen){
                if (board[col][row] == word.charAt(0)) {
                    if(word.length() == 1)
                        return true;
                    road[col][row] = true;
                    if (isExsist(board, road, col, row, cLen, rLen, word, 1)) {
                        return true;
                    } else {
                        road[col][row] = false;
                    }
                }
                row++;
            }
            col++;
        }
        return false;
    }

    /**
     *
     * @param board
     * @param road  路径数组
     * @param col   当前列
     * @param row   当前行
     * @param cLen  每列长
     * @param rLen  每行长
     * @param word  目标字符串
     * @param at    当前对应字符串位置
     * @return
     */
    private static boolean isExsist(char[][] board, boolean[][] road, int col, int row, int cLen, int rLen, String word, int at) {
        if(at >= word.length()){
            return true;
        }
        //向上走
        if(col - 1 >= 0 && !road[col - 1][row] && board[col - 1][row] == word.charAt(at)){
            road[col - 1][row] = true;
            if(isExsist(board, road, col - 1, row, cLen, rLen, word, at + 1)){
                return true;
            }else {
                road[col - 1][row] = false;
            }
        }
        //向下走
        if(col + 1 < cLen && !road[col + 1][row] && board[col + 1][row] == word.charAt(at)){
            road[col + 1][row] = true;
            if(isExsist(board, road, col + 1, row, cLen, rLen, word, at + 1)){
                return true;
            }else {
                road[col + 1][row] = false;
            }
        }
        //向左走
        if(row - 1 >= 0 && !road[col ][row - 1] && board[col][row - 1] == word.charAt(at)){
            road[col][row - 1] = true;
            if(isExsist(board, road, col, row - 1, cLen, rLen, word, at + 1)){
                return true;
            }else {
                road[col][row - 1] = false;
            }
        }
        //向右走
        if(row + 1 < rLen && !road[col ][row + 1] && board[col][row + 1] == word.charAt(at)){
            road[col][row + 1] = true;
            if(isExsist(board, road, col, row + 1, cLen, rLen, word, at + 1)){
                return true;
            }else{
                road[col][row + 1] = false;
            }
        }

        return false;
    }
}
