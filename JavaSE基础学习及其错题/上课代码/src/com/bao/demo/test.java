package com.bao.demo;

class Animal{
    protected String name;

    public Animal(String name){
        this.name = name;
        System.out.println("Animal(String)");
    }

    public void eat(){
        System.out.println(this.name + "Animal::eat()");
    }
}

class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(this.name + "Bird::fly()");
    }
}

/**
 * 不写public Cat的报错原因：子类在构造的时候要先构造父类
 *      如果要是对父类进行引用，需要super方法
 */
class Cat extends Animal{

    public Cat(String name){
        //super()必须放到第一行的，显式调用父类的构造方法，不是继承
        super(name);
        System.out.println("Cat(String)");
    }
//    public String name;
//    public void eat(){
//        System.out.println(this.name + "Cat::eat()");
//    }
}

class ChineseGardenCat extends Cat{

    public ChineseGardenCat(String name) {
        super(name);
    }
}

public class test {

    public static void main(String[] args) {
        Cat cat = new Cat("mimi");
        cat.eat();

        Bird bird = new Bird("bage");
        bird.fly();     //可以访问自己的
        bird.eat();     //可以访问父类的
    }
}
