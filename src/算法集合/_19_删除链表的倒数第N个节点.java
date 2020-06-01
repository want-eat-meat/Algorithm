package 算法集合;

import source.ListNode;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针

/**
 * 0ms
 * 38MB
 */
public class _19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode delBefore = head;
        ListNode at = head;
        int i = 0;
        while(at!= null){
            i++;
            if(i > n + 1){delBefore = delBefore.next;}
            at = at.next;
        }
        if( i == n ){
            head = head.next;
        }else if( i > n){
            delBefore.next = delBefore.next.next;
        }
        return head;
    }
}
