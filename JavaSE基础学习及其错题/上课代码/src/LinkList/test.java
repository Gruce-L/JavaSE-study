package LinkList;

public class test {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        //头插法：
//        sll.addFirst(10);
//        sll.addFirst(15);
//        sll.addFirst(20);
//        sll.addFirst(25);
//        sll.display();

        //尾插法:
        sll.addLast(9);
        sll.addLast(12);
        sll.addLast(12);
        sll.addLast(8);
        sll.addLast(21);
        sll.addLast(7);
        sll.addLast(13);
        sll.display();
        System.out.println();
        System.out.println("===================");
//        System.out.println(sll.contains(30));
//        System.out.println("===================");
//        System.out.println(sll.size());
//        System.out.println("===================");
//        sll.addIndex(3,12);
//        sll.display();
//        System.out.println();
//        System.out.println("===================");
//        sll.remove(30);
//        sll.display();
//        System.out.println();
//        System.out.println("===================");
//        sll.removeAllKey(12);
//        sll.display();
//        System.out.println();
//        System.out.println("===================");
//        Node ret = sll.reverseList();
//        sll.display1(ret);
//        System.out.println();
//        System.out.println("===================");
//        System.out.println(sll.middleNode().data);
//        System.out.println();
//        System.out.println("===================");
//        System.out.println(sll.findKthToTail(1).data);
//        System.out.println();
//        System.out.println("===================");
        Node ret = sll.partition(11);
        sll.display1(ret);

    }
}
