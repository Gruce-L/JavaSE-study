package LinkList;

/**
 * https://www.nowcoder.com/practice/d281619e4b3e4a60a2cc66ea32855bfa?tpId=49&&tqId=29370&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
 *
 * 方法：把单项变成双向，后半部分方向取反
 *      定义fast和slow，fast走两步，slow走一步
 *
 *      找到单链表的中间节点，开始反转单链表，一个从尾走，一个从头走
 */

class ListNode6 {
    int val;
    ListNode6 next = null;

    ListNode6(int val) {
        this.val = val;
    }
}

public class PalindromeList {

    public boolean chkPalindrome(ListNode6 A) {
        if(A == null){
            return false;
        }

        //只有头节点自己，必然是回文结构
        if(A.next == null){
            return true;
        }

        /**
         * 1.找到单链表的中间节点
         */
        ListNode6 fast = A;
        ListNode6 slow = A;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * 2.反转单链表的后半部分，slow肯定在中间位置
         */
        ListNode6 cur = slow.next;
        //不能写成Node curNext = cur.next;  因为cur可能为空

        while (cur != null){
            ListNode6 curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        /**
         * 此时slow就是最后一个节点
         * 3.一个从尾走，一个从头走
         */
        while (slow != A){
            if(slow.val == A.val){
                return false;
            }

            //加上链表个数为偶数的情况
            if(A.next == slow){
                return true;
            }

            //适用于链表个数为奇数情况下
            slow = slow.next;
            A = A.next;
        }
        return true;
    }
}
