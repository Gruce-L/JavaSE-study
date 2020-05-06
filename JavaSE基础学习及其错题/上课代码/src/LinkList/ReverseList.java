package LinkList;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur  = head;
        ListNode prev = null;
        ListNode newHead = null;

        while (cur != null){
            ListNode curNext = cur.next;
            if (curNext == null){
                newHead = cur;
            }

            //因为是反转链表，所以先让头节点指向空
            cur.next = prev;
            //然后prev指向cur，让prev知道cur是头节点
            prev = cur;
            //cur再次指向curNext
            cur = curNext;
        }
        return newHead;
    }
}
