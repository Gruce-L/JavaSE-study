package DuotaiAbstractInterface.Abstract;

/**
 * 抽象类：
 *     1.抽象方法：一个方法如果被abstract修饰，那么这个方法就是抽象方法
 *                抽象方法可以没有具体的实现
 *     2.包含抽象方法的类，叫做抽象类
 *
 * 注意：
 *      1.抽象类不能被实例化
 *      2.类内的数据成员和普通类没有区别
 *      3.抽象类的主要作用就是用来被继承的
 *      4.如果一个类继承了这个抽象类，那么这个类必须重写抽象类中的抽象方法
 *      5.抽象类/抽象方法一定不能被final修饰的，因为final修饰后，此类/方法/属性不能被重写，
 *        然而抽象类在某个类中被实例化的时候，是需要被重写的
 *
 */

abstract class Shape{

    public int a;
    public abstract void show();
}

class Circle extends Shape{
    @Override
    public void show() {
        System.out.println("yuan");
    }
}

class Rectangle extends Shape{
    @Override
    public void show() {
        System.out.println("yuan");
    }
}

public class TestDemo {

    public static void show(Shape shape){
        shape.show();
    }

    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();

        show(shape1);
        show(shape2);
    }
}
