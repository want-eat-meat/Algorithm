//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 607 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合51_100;

import source.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        listTree(root, result);
        return result;
    }

    /**
     * 迭代
     * 1ms
     * 37.8MB
     * @param root
     * @param result
     */
    private void listTree(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
    }

    /**
     * 递归
     * 0ms
     * 38MB
     * @param root
     * @param result
     */
    /*private void listTree(TreeNode root, List<Integer> result) {
        if(root.left != null){
            listTree(root.left, result);
        }
        result.add(root.val);
        if(root.right != null){
            listTree(root.right, result);
        }
    }*/
}
