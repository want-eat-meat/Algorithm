//给定一个非空二叉树，返回其最大路径和。
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
//
//
// 示例 2:
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42
// Related Topics 树 深度优先搜索
// 👍 656 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合101_150;

import source.TreeNode;

/**
 * 递归
 * 1ms
 * 41.4MB
 */
public class _124_二叉树中的最大路径和 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int leftVal = Math.max(dfs(root.left), 0);

        int rightVal = Math.max(dfs(root.right), 0);

        max = Math.max(max, root.val + leftVal + rightVal);

        return root.val + Math.max(leftVal, rightVal);
    }
}
