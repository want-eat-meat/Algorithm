//二叉搜索树中的两个节点被错误地交换。
//
// 请在不改变其结构的情况下，恢复这棵树。
//
// 示例 1:
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
//
//
// 示例 2:
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
//
// 进阶:
//
//
// 使用 O(n) 空间复杂度的解法很容易实现。
// 你能想出一个只使用常数空间的解决方案吗？
//
// Related Topics 树 深度优先搜索
// 👍 259 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合51_100;

import source.TreeNode;

public class _99_恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode x = null;
        TreeNode y = null;
        TreeNode temp = null;
        TreeNode pre = null;

        while(root != null){
            if(root.left != null){
                temp = root.left;
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }
            }else{

            }
        }
    }

    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
