package DuotaiAbstractInterface.Interface;

/**
 *  接口：是抽象类更进一步的抽象
 *        1.接口当中的方法都是抽象方法
 *        2.接口当中可以有具体实现的方法，这个方法是被default修饰的（JDK1.8开始）
 *        3.接口当中定义的成员变量默认是常量
 *        4.接口当中的成员变量默认是public static final，成员方法默认是public abstract
 *        5.接口不能用来被实例化的，抽象类都不行      Shape shape = new Shape()
 *        6.接口和类之间的关系：implements
 *     ※ 7.接口是为了解决Java的特性 —— 单继承的问题,可以实现多个接口
 *        8.只要这个类实现了该接口，就可以进行向上转型
 */

interface Shape{
    int a = 10;
    void show();

//    default void func1(){
//        System.out.println("a");
//    }
}

interface A{

}

class Circle implements Shape, A{
    @Override
    public void show() {
        System.out.println("画一个圆");
    }
}

class Rectangle implements Shape{
    @Override
    public void show() {
        System.out.println("画一个矩形");
    }
}

public class TestInterface {
    public static void drawMap(Shape shape){
        shape.show();
    }

    public static void main4(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        drawMap(shape1);
        drawMap(shape2);

    }
}
