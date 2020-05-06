package DuotaiAbstractInterface.Duotai;

/*
    1.子类继承了父类的除构造方法外所有的
    2.子类在构造的时候，一定要帮助父类来先进行构造。
 */

class Animal{
    public String name;

    /**
     *  子类在构造的时候，一定要帮助父类来先进行构造。
     *  因为在父类中构造，所以子类会报错，而且.Animal也不可以
     * @param name
     */
    public Animal(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println(this.name + "正在吃");
    }
}

class Cat extends Animal{
    public String huzi;

    public Cat(String name, String huzi){
        super(name);
        this.huzi = huzi;
    }

    public void func(){
        System.out.println(this.name);
    }

    public void eat(){
        System.out.println("正在吃");
    }
}

public class TestDemo {
    public static void main1(String[] args) {
        /**
         * 向上转型：父类引用，引用子类对象
         */
        Animal animal = new Cat("狗砸","胡须");

        /**
         * 运行时多态（动态绑定）：只能使用父类中的方法，不能访问子类自己的方法
         *
         * javap -c :反编译
         *      在编译的时候，确实调用的是Animal的Cat方法，但是在运行的时候，却调用
         *      的是Cat()
         */
        animal.eat();

//        Cat cat = new Cat();
//        cat.eat();
    }
}
