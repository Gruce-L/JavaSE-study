package ShallowCopyDeepCopy;

/**
 * 实现深拷贝的方式：
 *      如果person2直接克隆person1，age可以被克隆，但是person1和person2都指向同一个money
 *      所以也需要对money进行克隆，然后再在person类中对clone方法进行改变
 */
class Money implements  Cloneable{
    double money = 12.21;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;
    Money money = new Money();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();

        //新克隆出来一个person对象
        Person p = (Person) super.clone();
        //在新克隆出来的person对象中创建一个money对象
        p.money = (Money) this.money.clone();
        return p;
    }
}

public class TestDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person1.money.money);
        System.out.println(person2.money.money);

        /**
         * 此时克隆后，person2新建了一个person对象，person中的age是浅拷贝
         *           但是person里面还有一个money，money不会改变，person1
         *           person2都指向money
         */
        System.out.println("修改");
        person2.money.money = 99.9;
        System.out.println(person1.money.money);
        System.out.println(person2.money.money);


    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();

        /**
         * 没有类似于数组的clone方法：array的类型是object类型，而对象是自定义类型
         *      如果要克隆自定义类型，步骤：1.实现接口    2.重写clone方法。
         */
        Person person2 = (Person) person1.clone();
        System.out.println(person1.age);
        System.out.println(person2.age);
        System.out.println("========================");
        person2.age = 99;

        //person1未改变原因：因为age是简单类型，所以person1不发生改变
        System.out.println(person1.age);
        System.out.println(person2.age);

    }
}
