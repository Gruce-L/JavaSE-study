package DuotaiAbstractInterface.Duotai;

class Shape{
    public void draw(){

    }
}

class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("画一个⚪");
    }
}

class Rectangle extends Shape{
    @Override
    public void draw() {
        System.out.println("画一个◇");
    }
}

class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("画一个△");
    }
}

public class UnderstandingDuotai {
    /**
     * 为什么main方法是静态的：
     *    1.如果main方法不声明为静态的，JVM就必须创建main类的实例，
     *      因为构造器可以被重载，JVM就没法确定调用哪个main方法。
     *
     *    2.静态方法和静态数据加载到内存就可以直接调用而不需要像
     *      实例方法一样创建实例后才能调用，如果main方法是静态的，
     *      那么它就会被加载到JVM上下文中成为可执行的方法。
     * @param shape
     */

    /**
     *  什么是多态（实质上是一种思想）
     * @param shape
     */

    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {

        //向上转型
//        Shape shape1 = new Cycle();
//        Shape shape2 = new Rectangle();
//        shape1.draw();
//        shape2.draw();

        //多态
        Shape shape1 = new Cycle();
        Shape shape2 = new Rectangle();
        Shape shape3 = new Triangle();
        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);

        //多态第二种表现方法：
        Shape[] shapes = {new Cycle(), new Rectangle(), new Cycle(),
                            new Rectangle(), new Triangle()};

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
