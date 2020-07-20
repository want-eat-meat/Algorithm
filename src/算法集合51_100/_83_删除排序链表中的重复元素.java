//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合51_100;

import source.ListNode;

public class _83_删除排序链表中的重复元素 {
    /**
     * 0ms
     * 39.4MB
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode index = head;

        while(index != null){
            if(index.val != pre.val){
                pre.next = index;
                pre = pre.next;
            }
            index = index.next;
        }
        pre.next = null;
        return head;
    }
}
