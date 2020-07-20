//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表
package 算法集合51_100;

import source.ListNode;

public class _82_删除排序链表中的重复元素II {

    /**
     * 1ms
     * 39.3MB
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode newHead= new ListNode(0);
        ListNode last = newHead;
        boolean isRepeat = false;
        while(head.next != null){
            if(head.val == head.next.val){
                head = head.next;
                isRepeat = true;
            }else{
                if(!isRepeat){
                    last.next = head;
                    last = last.next;
                }else{
                    isRepeat = false;
                }
                head = head.next;
            }
        }
        if(isRepeat){
            last.next = null;
        }else{
            last.next = head;
        }
        return newHead.next;
    }
}
