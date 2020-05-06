package ClassAndEncapsulation;

/**
 * 类名一定使用大驼峰格式、
 *  面向对象:创建一个class  public、private、protected:访问修饰限定符
 *
 */
class Person{
    //字段 -> 成员变量  定义在方法 外边， 类 的里面
    //实例成员变量：对象里面
    //Person存储在栈中，里面的对象存储在堆中
    //实例成员没有初始化，String的为null，简单类型的为0
    //char -> '\u0000'  boolean -> false
    public String name;
    public int age;
    public char ch;
    public boolean flag;

    //静态成员变量：静态成员变量不属于对象
    //只有一份，存储在方法区中
    public static int size = 10;

    //方法 -> 行为      实例成员方法的调用
    public void eat(){
        System.out.println("eat()!");
    }

    public void sleep(){
        System.out.println("sleep()!");
    }

    public static void func1(){
        System.out.println("static::func1");
        size = 99;

        //静态方法内部，不能够访问非静态的数据成员
        //age = 3;
    }

}

class Test{
    public int a;
    public static int count;
}

public class Class {

    /**
     *  static 关键字
     * @param args
     */
    public static void main4(String[] args) {
        Test t1 = new Test();
        t1.a++;
        Test.count++;
        System.out.println(t1.a);
        System.out.println(Test.count);
        System.out.println("-----------------------");

        Test t2 = new Test();
        t2.a++;
        Test.count++;
        System.out.println(t2.a);
        System.out.println(Test.count);
    }

    /**
     * 实例成员方法的调用
     * @param args
     */
    public static void main3(String[] args) {
        Person person = new Person();
        person.eat();
        person.sleep();

        //访问静态成员方法
        Person.func1();
    }

    /**
     * 如何访问静态的数据成员：类名.静态成员变量
     * @param args
     */
    public static void main2(String[] args) {
        System.out.println(Person.size);
    }

    public static void main1(String[] args) {

        //实例化一个对象   通过关键字new
        Person person = new Person();
        Person person1 = new Person();

        //如何访问对象当中的实例化成员变量
        person.name = "lzx";
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.ch);
        System.out.println(person.flag);
    }
}
