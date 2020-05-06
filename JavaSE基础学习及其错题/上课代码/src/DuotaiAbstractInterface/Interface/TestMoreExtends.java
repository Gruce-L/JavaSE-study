package DuotaiAbstractInterface.Interface;

import javax.jws.soap.SOAPBinding;

class Animal{
    protected String name;

    public Animal(String name){
        this.name = name;
    }
}

interface IFlying{
    void fly();
}

interface IRunning{
    void run();
}

interface ISwimming{
    void swim();
}

/**
 *  1.一个类可以继承一个普通类/抽象类，并且可以同时实现多个接口
 */

class Cat extends Animal implements IRunning{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("正在用四条腿跑");
    }
}

class Fish extends Animal implements ISwimming{
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("正在水里游");
    }
}

class Frog extends Animal implements IRunning, ISwimming{
    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在用两条腿蹦");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在水里游泳");
    }
}

public class TestMoreExtends {

    public static void walk(IRunning iRunning){
        System.out.println("正在跑步");
        iRunning.run();
    }

    public static void main2(String[] args) {
        IRunning iRunning1 = new Frog("青青");
        walk(iRunning1);
    }
}
