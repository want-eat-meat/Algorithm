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

/**
 * 3ms
 * 40.1MB
 */
public class _99_恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode x = null;
        TreeNode y = null;
        TreeNode temp = null;
        TreeNode pre = null;

        while(root != null){
            if(root.left != null){
                //左节点不为空
                temp = root.left;
                //前驱节点找到当前节点下最后遍历到的节点
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }
                //前驱节点无右子节点时，其为当前节点下最后那遍历到的节点，将其右子节点指向当前节点
                if(temp.right == null){
                    temp.right = root;
                    root = root.left;
                }
                //前驱节点的右子节点指向当前节点，说明此链接以使用，断开连接，输出当前节点
                if(temp.right == root){
                    temp.right = null;
                    if(pre != null && pre.val > root.val){
                        y = root;
                        if(x == null){
                            x = pre;
                        }
                    }
                    pre = root;
                    root = root.right;
                }
            }else{
                //当前节点无左子节点，输出当前节点，
                if(pre != null && pre.val > root.val){
                    y = root;
                    if(x == null){
                        x = pre;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        if(x != null && y != null){
            int val = x.val;
            x.val = y.val;
            y.val = val;
        }
    }

}
