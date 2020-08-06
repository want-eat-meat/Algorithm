//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索
// 👍 692 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合51_100;

import source.TreeNode;

import java.util.Stack;

public class _98_验证搜索二叉树 {
    /**
     * 递归
     * 0ms
     * 39.5MB
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root,Integer lower, Integer upper){
        if (root == null) {
            return true;
        }
        if(lower != null && root.val <= lower) return false;
        if(upper !=null && root.val >= upper) return false;

        if(!isValidBST(root.left, lower, root.val)) return false;
        if(!isValidBST(root.right, root.val, upper)) return false;
        return true;
    }


    /**
     * 中序遍历
     * 2ms
     * 39.6MB
     * @param root
     * @return
     */
    /*public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double last = -Double.MAX_VALUE;
        //第一个
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
               root = stack.pop();
                if(root.val <= last){
                    return false;
                }
                last = root.val;
                root = root.right;
            }
        }
        return true;
    }*/
}
