package LinkList;

/**
 * https://www.nowcoder.com/practice/0e27e0b064de4eacac178676ef9c9d70?tpId=8&&tqId=11004&rp=2&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/question-ranking
 *
 * 方法：申请两个链表，一个链表放比 x小的数据，另外一个放比 x 大的数据，然后小和大连起来，最大的那个置为空
 *      小的：开始bs，结束be；
 *      大的：开始as，结束ae
 *      be和as连接起来，ae置为空
 *
 * 注意： 第一个段没有数据，返回as
 *       第二段没有数据，返回bs
 *       be和as进行拼接，be.next = as
 */

class ListNode4 {
    int val;
    ListNode4 next = null;

    ListNode4(int val) {
        this.val = val;
    }
}

public class Partition {

    public ListNode4 partition(ListNode4 pHead, int x) {
        // write code here
        ListNode4 bs = null;
        ListNode4 be = null;
        ListNode4 as = null;
        ListNode4 ae = null;
        ListNode4 cur = pHead;

        while (cur != null){
            if(cur.val < x){
                //第一次插入
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else {
                    //不是第一次插入
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null){
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }

        if(bs == null){
            return as;
        }

        if(as == null){
            return bs;
        }

        be.next = as;
        ae.next = null;
        return bs;
    }
}
