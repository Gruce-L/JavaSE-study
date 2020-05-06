package HannoTowerAndArray;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

    /**
     * Arrays操作数组工具类讲解
     * @param args
     */

    //自己实现数组转字符串方法
    public static String myToString(int[] array){
        String ret = "[";

        for(int i = 0; i < array.length; i++){
            ret += array[i];
            if(i != array.length - 1) {
                ret += ",";
            }
        }

        ret += "]";
        return ret;
    }

    public static void main6(String[] args) {
        int[] array = {12, 34, 1, 6, 2, 9, 21};
        Arrays.sort(array);

        //数组转字符串
        System.out.println(Arrays.toString(array));
    }

    /**
     *  将数组中的每个值扩大一倍，并未在原本的数组进行修改
     * @param args
     * @return
     */

    public static int[] func(int[] array){
        int[] temp = new int[array.length];

        for (int i = 0; i < array.length; i++){
            temp[i] = array[i] * 2;
        }
        return temp;
    }

    public static void main5(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};

        //Arrays：操作数组的工具类
        System.out.println(Arrays.toString(func(array)));
    }

    /**
     * 当初始化数组时不往里面添加数字，则需要让数组 = null，即array引用的是空对象
     *      ，不是像C语言中的0地址处
     * @param args
     */
    public static void main4(String[] args) {
        int[] array = null;
        System.out.println(array);

    }

    /**
     *  数组作为参数进行传递：传的是引用，但是这个引用其实还是值，只不过这个值是一个地址
     *                      ，变成一个引用类型
     *
     * 交换两个数字
     *
     * @param args
     */

    public static void printArray(int[] arr){
        for (int val: arr) {
            System.out.print(val + " ");
        }
    }

    public static void swap(int[] array){
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    public static void main3(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
        printArray(array);

        System.out.println();

        int[] array1 = {10, 20};
        swap(array1);
        System.out.println(array1[0] + " " + array1[1]);
    }

    /**
     * 数组长度是一个属性，使用for-each循环
     *      for-each冒号右边是数组名称，左边是数组当中的每一个元素类型
     * @param args
     */
    public static void main2(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};

        int len = array.length;         //属性
        System.out.println(len);

        //遍历数组第一种方法
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();
        
        //遍历数组第二种方法：for each

        /*
            for-each冒号右边是数组名称，左边是数组当中的每一个元素类型
         */
        for (int val: array) {
            System.out.print(val + " ");
        }

        System.out.println();

        //遍历数组第三种方法：将数组以字符串的形式输出
        System.out.println(Arrays.toString(array));

    }

    /**
     * Description：
     *      数组 - 存放相同数据类型的集合
     *      new：实例化一个对象
     *      array是引用类型，在栈上，里面存放的是数组的地址，因为数组存放在堆上，若array[0]的地址是
     *          0x99，则array中存放的地址就是0x99
     *
     * 栈上的地址是拿不到的，堆上的可以拿到但不是真实的，因为通过哈希处理，但是地址依然唯一
     *
     * @param args
     */

    public static void main1(String[] args) {
        //整体初始化，而且数组大小已经确定,数组在Java中是存储在堆上的
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};

        //无需指定数组大小，Java自动判别
        int[] array2 = new int[]{11, 22, 33, 44};

        //申请一个存放10个数的数组，且里面全都是0，即里面有10个0
        int[] array3 = new int[10];

        //地址是经过哈希处理的，直接拿拿不到
        System.out.println(array);
    }
}
