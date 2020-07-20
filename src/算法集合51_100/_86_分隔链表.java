//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。
//
// 示例:
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
//
// Related Topics 链表 双指针
package 算法集合51_100;

import source.ListNode;

/**
 * 指针
 * 0ms
 * 39MB
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode index = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode small = pre;
        head = pre;
        while(index != null){
            if(index.val < x){
                if(pre == small){
                    index = index.next;
                    pre = pre.next;
                    small = small.next;
                }else {
                    pre.next = index.next;
                    index.next = small.next;
                    small.next = index;
                    index = pre.next;
                    small = small.next;
                }
            }else{
                index = index.next;
                pre = pre.next;
            }
        }
        return head.next;
    }
}
