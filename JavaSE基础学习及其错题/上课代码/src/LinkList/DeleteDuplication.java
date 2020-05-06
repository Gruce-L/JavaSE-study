package LinkList;

/**
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&&tqId=11209&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 *
 * 方法一：申请一个虚拟节点newHead作为头节点，然后把不重复的数字放到newHead后面
 *        再申请一个temp，指向newHead，如果有不重复的，tmp后移指向不重复的节点
 *        即temp.next = cur; + temp = temp.next; + cur = cur.next;
 * 方法二：类似于Partition方法，把不重复的放到一起，重复的放到一起
 */

class ListNode5 {
    int val;
    ListNode5 next = null;

    ListNode5(int val) {
        this.val = val;
    }
}

public class DeleteDuplication {

    public ListNode5 deleteDuplication(ListNode5 pHead) {
        ListNode5 newHead = new ListNode5(-1);
        ListNode5 cur = pHead;
        ListNode5 temp = pHead;

        while (cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val== cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                temp.next = cur;
                temp = temp.next;
                cur = cur.next;
            }
        }
        temp.next = null;
        return newHead.next;
    }
}
