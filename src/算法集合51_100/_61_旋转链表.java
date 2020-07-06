//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针
package 算法集合51_100;

import source.ListNode;

/**
 * 1ms
 * 38.9MB
 */
public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode nextHead = head;
        ListNode preNext = head;
        int len = 1;
        //成环
        while(preNext.next != null){
            preNext = preNext.next;
            len++;
        }
        preNext.next = head;
        //找头节点
        for(int i = 0; i < len - (k % len); i++){
            preNext = nextHead;
            nextHead = nextHead.next;
        }
        //断开
        preNext.next = null;
        return nextHead;
    }
}
