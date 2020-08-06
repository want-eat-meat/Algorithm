//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
package 算法集合51_100;

import source.ListNode;

/**
 * 链表
 * 0ms
 * 37.7MB
 */
public class _92_反转链表 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode index = head;
        ListNode last = new ListNode(-1);
        last.next = head;
        head = last;
        ListNode newHead = new ListNode(-1);
        ListNode afterHead = newHead;
        ListNode newLast = newHead;

        for(int i = 1; i <= n; i++){
            if(i < m){
                index = index.next;
                last = last.next;
            }else{
                if(i ==m) {
                    newLast = index;
                }
                afterHead = index;
                index = index.next;
                afterHead.next = newHead.next;
                newHead.next = afterHead;
            }
        }
        last.next = newHead.next;
        newLast.next = index;
        return head.next;
    }
}
