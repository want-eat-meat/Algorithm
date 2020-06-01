package 算法集合;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学

import source.ListNode;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nowNode = new ListNode(0);
        ListNode resultList = nowNode;
        int upToNext = 0;
        while(l1 != null || l2 != null || upToNext != 0){
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int sumValue = l1Value + l2Value + upToNext;
            upToNext = sumValue / 10;
            ListNode sumNode = new ListNode(sumValue % 10);
            nowNode.next = sumNode;
            nowNode = nowNode.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return resultList.next;
    }
}