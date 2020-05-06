package LinkList;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/description/
 *
 * 方法：只能遍历一遍 - 双指针，一个走一步，一个走两步，当两步的那个.next为空，走一步的那个
 *      一定在中间
 */

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}

public class MiddleNode {
    public ListNode1 middleNode(ListNode1 head1) {
        ListNode1 slow = head1;
        ListNode1 fast = head1;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
