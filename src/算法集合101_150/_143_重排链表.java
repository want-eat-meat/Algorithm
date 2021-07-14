//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例 1:
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//
// 示例 2:
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
// Related Topics 栈 递归 链表 双指针
package 算法集合101_150;

import source.ListNode;

/**
 * 找中心，反转拼接
 * 1ms
 * 40.6Mb
 */
public class _143_重排链表 {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        link(l1, l2);
    }

    private void link(ListNode index1, ListNode index2) {
        ListNode temp1 = null;
        ListNode temp2 = null;
        while(index1 != null && index2 !=null) {
            temp1 = index1.next;
            temp2 = index2.next;
            index1.next = index2;
            index1 = temp1;

            index2.next = index1;
            index2 = temp2;
        }
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
