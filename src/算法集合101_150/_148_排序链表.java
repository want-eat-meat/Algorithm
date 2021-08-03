//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 链表 双指针 分治 排序 归并排序
package 算法集合101_150;

import source.ListNode;

/**
 * 分治
 * 8ms
 * 47.2Mb
 */
public class _148_排序链表 {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;

        int size = 0;
        ListNode index = head;
        while(index != null){
            index = index.next;
            size++;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        for(int step = 1; step < size; step <<= 1){
            ListNode pre = preHead;
            ListNode cur = preHead.next;
            while(cur != null){
                ListNode head1 = cur;
                for(int i = 1; i < step && cur.next != null; i++){
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for(int i = 1; i < step && cur != null && cur.next != null; i++){
                    cur = cur.next;
                }
                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = merge(head1, head2);
                while(pre.next != null){
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return preHead.next;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode index = head;
        while(head1 != null && head2 != null){
            if(head1.val > head2.val){
                index.next = head2;
                head2 = head2.next;
            }else{
                index.next = head1;
                head1 = head1.next;
            }
            index = index.next;
        }
        if(head1 != null){
            index.next = head1;
        }
        if(head2 != null){
            index.next = head2;
        }
        return head.next;
    }
}
