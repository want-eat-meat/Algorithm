//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
//
//
// 示例：
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 8
//
// Related Topics 树 动态规划
// 👍 591 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合51_100;

import source.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 * 1ms
 * 40.2MB
 */
public class _95_不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> trees= new ArrayList<>();
        if(start > end){
            trees.add(null);
            return trees;
        }
        for(int i = start; i <= end; i++){
            TreeNode now = new TreeNode(i);
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){
                    now.left = leftNode;
                    now.right = rightNode;
                    trees.add(now);
                }
            }
        }
        return trees;
    }
}
