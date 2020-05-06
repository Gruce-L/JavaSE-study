package Calculator;

class Calculator{
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add(){
        return this.num1 + this.num2;
    }

    public int sub(){
        return this.num1 - this.num2;
    }

    public int mul(){
        return this.num1 * this.num2;
    }

    public double dev(){
        return this.num1*1.0 / this.num2*1.0;
    }
}

class MyValue{
    private int myValue;

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class test {

    /**
     * 交换两个参数的值，以实参的形式变换
     * @param args
     */

    public static void swap(MyValue myValue1, MyValue myValue2){
        int temp;
        temp = myValue1.getMyValue();
        myValue1.setMyValue(myValue2.getMyValue());
        myValue2.setMyValue(temp);
    }

    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.setMyValue(12);

        MyValue myValue2 = new MyValue();
        myValue2.setMyValue(20);

        System.out.println(myValue1.getMyValue() + " " + myValue2.getMyValue());
        swap(myValue1, myValue2);
        System.out.println(myValue1.getMyValue() + " " + myValue2.getMyValue());

    }

    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(12);
        calculator.setNum2(24);
        System.out.println("加法：" + calculator.add());
        System.out.println("减法：" + calculator.sub());
        System.out.println("乘法：" + calculator.mul());
        System.out.println("除法：" + calculator.dev());
    }
}
