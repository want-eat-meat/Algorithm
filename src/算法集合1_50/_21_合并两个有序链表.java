package 算法集合1_50;

import source.ListNode;

//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表

/**
 * 1ma
 * 39.6MB
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                point.next = l1;
                l1 = l1.next;
            }else{
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if(l1 == null){
            point.next = l2;
        } else if (l2 == null) {
            point.next = l1;
        }
        return head.next;
    }
}
