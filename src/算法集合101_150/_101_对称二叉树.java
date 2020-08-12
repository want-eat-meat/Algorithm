//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 946 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合101_150;

import source.TreeNode;

/**
 * 0ms
 * 37.8MB
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
