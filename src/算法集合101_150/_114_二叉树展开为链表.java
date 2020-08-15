//给定一个二叉树，原地将它展开为一个单链表。
//
//
//
// 例如，给定二叉树
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索
// 👍 510 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合101_150;

import source.TreeNode;

/**
 * 0ms
 * 39.4MB
 */
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        TreeNode rootTemp = root;
        while(rootTemp != null){
            if(rootTemp.left != null){
                TreeNode node = rootTemp.left;
                TreeNode temp = node;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = rootTemp.right;
                rootTemp.left = null;
                rootTemp.right = node;
            }
            rootTemp = rootTemp.right;
        }
    }
}
