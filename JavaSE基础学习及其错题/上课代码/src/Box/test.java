package Box;

public class test {

    public static void main(String[] args) {
        Box<Number> box1 = new Box<Number>();
        box1.setFirst(100);
        showBox(box1);

        //虽然box中式number类型，而且integer也是用number接口，按照多态是可以的，但是
        //泛型是不能这么理解的,所以使用？ = 泛型通配符，代替具体类型的实参
        //类型通配符是类型实参，不是类型形参
        Box<Integer> box2 = new Box<Integer>();
        box2.setFirst(100);
        showBox(box2);
    }


    //类型通配符的上限，要求该泛型的类型，只能是实参类型，或实参类型的子类类型
    //语法：类/接口<? extends 实参类型>
    //通配符的上限不能使用add方法，不能添加类型
    public static void showBox(Box<? extends Number> box){
        Number first =box.getFirst();
        System.out.println(first);
    }
}
