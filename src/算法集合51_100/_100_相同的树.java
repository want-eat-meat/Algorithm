//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
// Related Topics 树 深度优先搜索
// 👍 411 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合51_100;

import source.TreeNode;

/**
 * 0ms
 * 37.1MB
 */
public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
