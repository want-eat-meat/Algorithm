//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 深度优先搜索 链表
// 👍 277 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package 算法集合101_150;

import source.ListNode;
import source.TreeNode;

/**
 * 快慢指针
 * 0ms
 * 40.7MB
 */
public class _109_有序链表转换为二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        //保存根节点的上一个节点
        ListNode before = head;
        //保存根节点
        ListNode root = before.next;
        //用于遍历
        ListNode node = root.next;

        while(node != null && node.next != null){
            node = node.next.next;
            root = root.next;
            before = before.next;
        }
        before.next = null;
        TreeNode treeNode = new TreeNode(root.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(root.next);
        return treeNode;
    }
}
