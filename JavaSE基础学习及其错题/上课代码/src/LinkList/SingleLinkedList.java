package LinkList;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

}

public class SingleLinkedList {
    public Node head;   //保存单链表的头节点的引用,是SingleLinkedList的成员属性

    /**
     * 头插法
     * @param data
     */
    public void addFirst(int data){
        Node node = new Node(data);

        if(this.head == null){
            //第一次插入
            this.head = node;
            return;
        }
        //此节点的下一个节点指向新创建的节点head
        node.next = this.head;
        //head的引用变成node，那么node将成为head，等待下一个新节点
        this.head = node;

    }

    /**
     * 尾插法
     * @param data
     */
    public void addLast(int data){
        Node node = new Node(data);

        if(this.head == null){
            this.head = node;
            return;
        }

        Node cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }

        cur.next = node;
        node.next = null;

    }

    /**
     * 任意位置插入，第一个数据节点为0号下标
     * @param index
     * @param data
     * @return
     */

    private Node searchIndex(int index){

        //对index进行合法性检查
        if(index < 0 || index > this.size()){
            throw new RuntimeException("index位置不合法");
        }

        Node cur = this.head;        //index - 1

        while (index - 1 != 0){
            cur = cur.next;
            index--;
        }

        return cur;
    }

    public void addIndex(int index, int data){

        //index == 0,相当于头插法
        if(index == 0){
            addFirst(data);
            return;
        }

        //index == this.size(),相当于尾插法
        if(index == this.size()){
            addLast(data);
            return;
        }

        Node node = new Node(data);

        //先找到index - 1的位置节点地址，
        Node cur = searchIndex(index);

        //进行插入
        node.next = cur.next;
        cur.next = node;

    }

    /**
     * 查找是否包含关键字key在单链表中
     * @param key
     * @return
     */
    public boolean contains(int key){
        Node cur = this.head;

        while (cur != null){
            if(cur.data != key){
                cur = cur.next;
            }else {
                return true;
            }
        }

        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点
     * @param key
     */

    private Node searchPrev(int key){
        Node prev = this.head;
        while (prev.next != null){
            if(prev.next.data == key){
                return prev;
            }else {
                prev = prev.next;
            }
        }
        return null;
    }

    public void remove(int key){


        int count = 0;
        Node cur = this.head;

        //如果头节点为空
        if(this.head == null){
            return;
        }

        //如果删除的是头节点
        if(cur.data == key){
            this.head = this.head.next;
            return;
        }

        /**
         * 方法一：设置一个cur，通过cur找prev，让prev.next = cur.next
         */
        while(cur.data != key){
            cur = cur.next;
            count++;
        }
        Node prev = searchIndex(count);
        prev.next = cur.next;

        /**
         * 方法二：直接定义prev，通过prev.next.data找数据
         */

//        Node prev = searchPrev(key);
//        if(prev == null){
//            System.out.println("根本没有这个节点");
//            return;
//        }
//        Node del = prev.next;
//        prev.next = del.next;

    }

    /**
     * 删除所有值为key的节点
     * @param key
     */
    public void removeAllKey(int key){
        /**
         * 方法一：
         */

        if(this.head == null){
            return;
        }

        int count = 1;
        Node cur = this.head.next;

        /**
         * 把while放到前面，if放到后面的原因：如果头节点及其下面皆是同一个且是要删除的数字，那么把头节点删除后，下一个节点
         * 自动设置为frontcur，第二个节点将会被删除，否则先if后while，下一个节点将不会被删除。
         */
        while (cur != null){
            if(cur.data == key){
                Node frontcur = searchIndex(count);
                frontcur.next = cur.next;

            }else {
                count++;
            }
            cur = cur.next;
        }

        if(this.head.data == key){
            this.head = this.head.next;
        }

        /**
         * 方法二：同remove的定义一样
         */
//        Node prev = this.head;
//
//        //代表要删除的节点
//        Node cur = this.head.next;
//        if(this.head == null){
//            return;
//        }
//        while (cur != null){
//            if(cur.data == key){
//                prev.next = cur.next;
//                cur = cur.next;
//            }else {
//                prev = cur;
//                cur = cur.next;
//            }
//        }
//
//        if(this.head.data == key){
//            this.head = this.head.next;
//        }
    }

    /**
     * 得到单链表的长度
     * @return
     */
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }

        return count;
    }

    /**
     * 打印单链表
     */
    public void display(){

        //这样写法是错误的，因为head为成员变量，指的是头节点，否则head节点一直向后移动，
        //将找不到单链表的头节点
//        if(this.head.next != null){
//
//        }

        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    /**
     * 清空单链表：释放内存的：让头节点不被引用，被JVM回收，那么其他的都不被引用，
     */
    public void clear(){
        this.head = null;
    }

    /**
     * 反转单链表:
     */

    public Node reverseList(){
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;

        while (cur != null){
            Node curNext = cur.next;

            if(curNext == null){
                newHead = cur;
            }

            cur.next = prev;
            prev = cur;
            cur = curNext;
        }

        return newHead;
    }

    /**
     * 打印反转后的单链表
     * @param newHead
     */
    public void display1(Node newHead){
        Node cur = newHead;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    /**
     * 输出单链表中的中间位置数字
     */

    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 寻找第k个节点 ，同理于上面，之间差（k-1）个节点
     * @param k
     * @return
     */

    public Node findKthToTail(int k) {
        int count = 0;
        Node fast = this.head;
        Node slow = this.head;

        if(k < 0 || k > size()){
            return null;
        }

        while (count < k - 1){
            fast = fast.next;
            count++;
        }

        while (fast.next != null ){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node partition(int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;

        while (cur != null){
            if(cur.data < x){

                //第一次插入
                if(bs == null){
                    bs = cur;
                    be = cur;
                }

                //不是第一次插入
                else {
                    be.next = cur;
                    be = be.next;
                }

            }else {

                //第一次插入
                if(as == null){
                    as = cur;
                    ae = cur;
                }

                //不是第一次插入
                else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }

            cur = cur.next;
        }

        //判断bs是否为空，如果为空，返回as，反之返回bs
        if(bs == null){
            return as;
        }

        if(as == null){
            be.next = null;
            return bs;
        }

        //如果bs，as都不为空，bs.next; = as + as.next = null;
        be.next = as;
        ae.next = null;
        return bs;
    }

    public Node deleteDuplication(){
        Node newHead = new Node(-1);
        Node cur = this.head;
        Node temp = newHead;

        while (cur != null){
            if(cur.next != null && cur.data == cur.next.data){
                while (cur.next != null && cur.data == cur.next.data){
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

    public boolean chkPalindrome(ListNode A) {
        // write code here

        if(this.head == null){
            return false;
        }

        //只有头节点自己，必然是回文结构
        if(this.head.next == null){
            return true;
        }

        /**
         * 1.找到单链表的中间节点
         */
        Node fast = this.head;
        Node slow = this.head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * 2.反转单链表的后半部分，slow肯定在中间位置
         */
        Node cur = slow.next;
        //不能写成Node curNext = cur.next;  因为cur可能为空

        while (cur != null){
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        /**
         * 此时slow就是最后一个节点
         * 3.一个从尾走，一个从头走
         */
        while (slow != this.head){
            if(slow.data != this.head.data){
                return false;
            }

            //加上链表个数为偶数的情况
            if(this.head.next == slow){
                return true;
            }

            //适用于链表个数为奇数情况下
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

}