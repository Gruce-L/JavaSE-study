package ClassAndEncapsulation;

/**
 * 封装：用private来修饰属性或方法
 *      private只能在类当中进行访问：
 *      如果实现访问，需要用get、set方法
 *
 *    如无特殊要求，所有的属性都必须设置成私有的
 */

class Student{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //重新实现了Object类的toString()方法
    @Override   //注解：指的是这个方法是重新写的
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void fun1(){
        System.out.println("func1()");
    }
}

//以上是类的实现者写的代码，以下是类的调用者

public class Encapsulation {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("lzx");
        student.setAge(21);
        System.out.println(student.toString());
    }
}
