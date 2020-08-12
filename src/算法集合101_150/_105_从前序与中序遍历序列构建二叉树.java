//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 605 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合101_150;

import source.TreeNode;

import java.util.Stack;

/**
 * 迭代
 * 2ms
 * 39.8MB
 */
public class _105_从前序与中序遍历序列构建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        if(preorder.length != inorder.length) return null;
        int pLen = preorder.length;
        int iLen = inorder.length;
        int i = 0;
        int j = 0;
        TreeNode root = new TreeNode(preorder[i++]);
        TreeNode curRoot = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curRoot);
        while(i < pLen){
            if(curRoot.val == inorder[j]){
                while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                    curRoot = stack.pop();
                    j++;
                }
                curRoot.right = new TreeNode(preorder[i++]);
                curRoot = curRoot.right;
                stack.push(curRoot);
            }else{
                curRoot.left = new TreeNode(preorder[i++]);
                curRoot = curRoot.left;
                stack.push(curRoot);
            }
        }
        return root;
    }
}
