package com.bao.demo;

class Base{
    public int data;
}

class Derive extends Base{
    public int data2;
}



public class test1 extends Animal{

    public test1(String name) {
        super(name);
    }

    public void func(){
        System.out.println(super.name);
    }

    public static void main1(String[] args) {
        Derive derive = new Derive();
        derive.data = 99;
    }
}
