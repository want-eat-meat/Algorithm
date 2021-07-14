//给定一个二叉树，返回它的 后序 遍历。
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
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树
package 算法集合101_150;

import source.TreeNode;

import java.util.*;

/**
 * 1ms
 * 36.4Mb
 */
public class _145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> readed = new HashSet<>();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode index = queue.peek();
            if(index.left != null && !readed.contains(index.left)){
                queue.push(index.left);
            }else if(index.right != null&& !readed.contains(index.right)){
                queue.push(index.right);
            }else{
                queue.pop();
                result.add(index.val);
                readed.add(index);
            }
        }
        return result;
    }
}
