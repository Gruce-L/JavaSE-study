package LinkList;

/**
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&&tqId=11167&rp=2&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 */

class ListNode2 {
    int val;
    ListNode2 next = null;

    ListNode2(int val) {
        this.val = val;
    }
}

public class FindKthToTail {

    public ListNode2 FindKthtoTail(ListNode2 head,int k) {
        ListNode2 fast = head;
        ListNode2 slow = head;
        int count = 0;

        /**
         * 当输出第0个，因为没有第0个，所以需要输出空
         */
        if(k <= 0){
            return null;
        }

        for(count = 0; count < k - 1; count++){

            /**
             * 当数组为空，k为正整数时
             */
            if(fast == null){
                return null;
            }else {
                fast = fast.next;
            }
        }

        /**
         * 当输入的 k 经过遍历后还超出单链表的大小，则输出空
         */

        if(fast == null){
            return null;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
