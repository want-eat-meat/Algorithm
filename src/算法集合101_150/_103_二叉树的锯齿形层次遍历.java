//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 238 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合101_150;

import source.TreeNode;

import java.util.*;

/**
 * 双端队列
 * 层序遍历
 * 1ms
 * 38.6MB
 */
public class _103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        boolean left = true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            List<Integer> buffList = new ArrayList<>();
            int size = list.size();
            if(left){
                for(int i = 0; i < size; i++){
                    TreeNode node = list.getFirst();
                    list.removeFirst();
                    buffList.add(node.val);
                    if(node.left != null){
                        list.addLast(node.left);
                    }
                    if(node.right != null){
                        list.addLast(node.right);
                    }
                }
            }else{
                for(int i= 0; i < size; i++){
                    TreeNode node = list.getLast();
                    list.removeLast();
                    buffList.add(node.val);
                    if(node.right != null){
                        list.addFirst(node.right);
                    }
                    if(node.left != null){
                        list.addFirst(node.left);
                    }
                }
            }
            result.add(buffList);
            left = !left;
        }
        return result;
    }
}
