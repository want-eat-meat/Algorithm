//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合101_150;

import source.TreeNode;

import java.util.Stack;

/**
 * 迭代
 * 2ms
 * 39.8MB
 */
public class _106_从中序与后续遍历序列构建二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        int iLen = inorder.length - 1;
        int pLen = postorder.length - 1;
        TreeNode root = new TreeNode(postorder[pLen--]);
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while(pLen >= 0){
            if(cur.val == inorder[iLen]){
                while(!stack.isEmpty() && stack.peek().val == inorder[iLen]){
                    cur = stack.pop();
                    iLen--;
                }
                cur.left = new TreeNode(postorder[pLen--]);
                cur = cur.left;
                stack.push(cur);
            }else{
                cur.right = new TreeNode(postorder[pLen--]);
                cur = cur.right;
                stack.push(cur);
            }
        }
        return root;
    }
}
