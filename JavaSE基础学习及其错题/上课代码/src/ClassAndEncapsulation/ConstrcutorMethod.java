package ClassAndEncapsulation;

class Staff{
    private String name;
    private int age;
    private static int count;

    /**
     * 构造方法
     */
    public Staff(){
        this("caocao", 18);

        //这样写是错误的，构造方法中只能有一个this.func()
        //this("zhangsan ");
        System.out.println("Staff<init>");
    }

    /**
     * 实例代码块(构造代码块)
     */
    {
        this.name = "zhangsan";
        count = 99;
        System.out.println("实例代码块。。。。。。。。。。");
    }

    /**
     * 静态代码块：里面不能访问非静态的数据成员
     *
     */
    static{
        count = 99;

        //报错
        //this.name = "zhangsan";

        System.out.println("静态代码块............");
    }

    public Staff(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Staff<String, int>");
    }

    public Staff(String name){
        this.name = name;
        System.out.println("Staff<String>");
    }

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

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ConstrcutorMethod {

    /**
     * 匿名对象：没有名字的对象，只能使用一次，要调用其他方法，需要新创建对象
     * @param args
     */
    public static void main3(String[] args) {
        Staff staff = new Staff();
        staff.getAge();

        //匿名对象
        new Staff().getAge();
    }

    /**
     * 代码块：本地代码块、实例代码块（构造代码块）、静态代码块
     *
     *      打印顺序：静态代码块  实例代码块   Person<init>
     *
     *      静态的内容只会被执行一次且是最早被执行的
     *
     *      第二次打印顺序：实例代码块   Person<init>
     *
     *      如果都是静态方法，那么输出结果是后面定义的结果
     * @param args
     */
    public static void main2(String[] args) {
        Staff staff = new Staff();
        System.out.println(staff);
    }

    public static void main1(String[] args) {
        Staff staff = new Staff();
        Staff staff1 = new Staff("bit", 19);
        System.out.println(staff1);
    }
}
