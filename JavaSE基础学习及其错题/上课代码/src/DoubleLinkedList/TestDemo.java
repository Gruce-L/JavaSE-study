package DoubleLinkedList;



public class TestDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        //头插法：
//        myLinkedList.addFirst(12);
//        myLinkedList.addFirst(15);
//        myLinkedList.addFirst(29);
//        myLinkedList.addFirst(45);
//        myLinkedList.display();

        //尾插法：
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.display();
//        System.out.println(myLinkedList.contains(29));
//        System.out.println(myLinkedList.size());
//        myLinkedList.addIndex(0,99);
//        myLinkedList.display();
//        myLinkedList.addIndex(3,199);
//        myLinkedList.display();
//        myLinkedList.addIndex(myLinkedList.size(),55);
//        myLinkedList.display();
//        myLinkedList.removeAllKey(2);
//        myLinkedList.display();
        myLinkedList.clear();

    }

}
