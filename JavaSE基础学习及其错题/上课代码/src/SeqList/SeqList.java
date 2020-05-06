package SeqList;



public class SeqList {

    public static void main1(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();
//        myArrayList1.add(0, 12);
//        myArrayList1.add(1, 23);
//        myArrayList1.add(2, 34);
//        myArrayList1.add(3, 45);
        for(int i = 0; i < 10; i++){
            myArrayList1.add(i,i);
        }
        myArrayList1.display();
        myArrayList1.add(10, 22);
        myArrayList1.display();
        System.out.println("========================");
        System.out.println(myArrayList1.binarySearch(5));
        System.out.println("========================");
        System.out.println(myArrayList1.contains(9));
        System.out.println("========================");
        System.out.println(myArrayList1.getPos(5));
        System.out.println("========================");
        System.out.println(myArrayList1.size());
        System.out.println("========================");
        myArrayList1.remove(6);
        myArrayList1.display();
        System.out.println("========================");
        myArrayList1.clear();
        myArrayList1.display();


        MyArrayList myArrayList2 = new MyArrayList();

    }

}
