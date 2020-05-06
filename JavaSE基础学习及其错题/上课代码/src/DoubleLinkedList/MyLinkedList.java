package DoubleLinkedList;

import com.sun.javafx.scene.NodeEventDispatcher;

/**
 * 双向链表
 */

class Node{
    public int data;
    public Node prev;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

public class MyLinkedList {

    //用来标志双向链表的头
    public Node head;
    //用来标志双向链表的尾巴
    public Node tail;

    /**
     * 头插法：
     * @param data
     */
    public void addFirst(int data){
        Node node = new Node(data);

        //是否为第一次插入
        if(this.head == null){
            this.head = node;
            this.tail = node;
        } else {
            //先绑next，再绑prev
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }

    }

    /**
     * 尾插法
     * @param data
     */
    public void addLast(int data){
        Node node = new Node(data);

        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
    }

    /**
     * 查找是否含有关键字key是否在单链表中
     * @param key
     * @return
     */
    public boolean contains(int key){
        Node cur = this.head;

        if(this.head == null){
            return false;
        }

        while (cur != null){
            if(cur.data == key){
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }

    /**
     * 得到单链表的长度
     * @return
     */
    public int size(){
        Node cur = this.head;
        int count = 0;

        if(this.head == null){
            return 0;
        }

        while (cur != null){
            count++;
            cur = cur.next;
        }

        return count;
    }

    /**
     * 任意位置插入，第一个数据节点为0号下标
     * @param index
     * @param data
     * @return
     */

    //检查index合法性
    private void checkIndex(int index){
        if(index < 0 || index > size()){
            throw new RuntimeException("index输入不合法");
        }
    }

    //找到具体的index对应的位置
    private Node searchIndex(int index){
        int count = 0;
        Node cur = this.head;

        while (count != index){
            count++;
            cur = cur.next;
        }

        return cur;
    }

    public void addIndex(int index, int data){
        checkIndex(index);
        Node cur = searchIndex(index);
        Node node = new Node(data);

        //若是双向链表没有数据，则为头插法
        if(index == 0){
            addFirst(data);
            return;
        }

        if(index == size()){
            addLast(data);
            return;
        }

        node.next = cur;
        node.prev = cur.prev;

        //如果先是cur.prev，那么cur.prev.next将不知道在哪里
        cur.prev.next = node;
        cur.prev = node;
    }

    /**
     * 删除第一次出现关键字为key的节点
     */
    public int remove(int key){
        Node cur = this.head;

        while (cur != null){
            if(cur.data == key){
                int oldData = cur.data;
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if(cur == this.tail){
                    cur.prev.next = null;
                    this.tail = cur.prev;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
//                    cur.next.prev = cur.prev;
//                    cur.prev.next = cur.next;
                }
                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 删除所有值为key的节点
     */
    public void removeAllKey(int key){
        Node cur = this.head;

        while (cur != null){
            if(cur.data == key){
                int oldData = cur.data;
                if(cur == this.head){
                    this.head = this.head.next;

                    //头节点不为空的情况（头节点不和尾节点重合）
                    if(this.head != null){
                        this.head.prev = null;
                    }

                }else if(cur == this.tail){
                    cur.prev.next = null;
                    this.tail = cur.prev;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
//                    cur.next.prev = cur.prev;
//                    cur.prev.next = cur.next;
                }
                //因为要删除所有的，所以就不要return了
//                return oldData;
            }
            cur = cur.next;
        }
    }

    /**
     * 打印双向链表
     */
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 清空双向链表：一个一个节点进行释放，
     */
    public void clear(){
        //这个方法看似可以清空，但实际上仍然有Node节点存在，JVM并未进行垃圾回收
        //this.head = null;
        while (this.head != null){
            Node cur = this.head.next;
            this.head.prev = null;
            this.head.next = null;
            head = cur;
        }

        //以上经历了while循环后，因为tail还在引用节点，所以堆中还有一个尾节点存在，
        //JVM也没有进行回收
        this.tail = null;
    }

}
