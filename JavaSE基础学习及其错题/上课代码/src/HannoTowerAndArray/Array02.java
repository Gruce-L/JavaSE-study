package HannoTowerAndArray;

import java.util.Arrays;

public class Array02 {

    /**
     *  把偶数放到前面，奇数放到后面:
     *      定义left 和 right ，right如果为奇数则不向前进一，否则不动，left向后找偶奇数，
     *      如果left 为奇数，则left 和 right 交换
     * @param args
     */

    public static void  swap(int[] array){
        int left = 0;
        int right = array.length - 1;

        while (left < right){

            //同理下面
            while (left < right && array[right] % 2 != 0){
                right--;
            }

            //添加left<right是因为防止left一直自加导致数组越界
            while (left < right && array[left] % 2 == 0){
                left++;
            }

            if(left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 10, 5, 6};
        swap(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     *  数组逆序：定义left 和 right
     * @param args
     */

    public static void reverse(int[] array){
        int left = 0;
        int right = array.length - 1;

        while (left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main7(String[] args) {
        int[] array = {1, 2, 3, 10, 5, 6};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     *  冒泡排序
     * @param args
     */

    public static void BubbleSort(int[] array){

        //代表没有发生交换
        boolean flag = false;

        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j +1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                break;
            }
        }
    }

    public static void main6(String[] args) {
        int[] array = {1, 2, 3, 10, 5, 6};
        BubbleSort(array);

        //Arrays.toString() 是需要返回值的
        System.out.println(Arrays.toString(array));
    }

    /**
     *  判断一个数组是否是升序的
     * @param args
     */

    public static boolean isUpSequence(int[] array){
        int i = 1;

//        法一：
//        for(i = 0; i < array.length; i++){
//            if(array[i] > array[i + 1]){
//                return false;
//            }
//        }
//        return true;

        //法二：
        while (i < array.length - 1){
            if(array[i] >= array[i - 1] && array[i] <= array[i + 1]){
                i++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main5(String[] args) {
        int[] array = {1, 2, 3, 10, 5, 6};
        System.out.println(isUpSequence(array));
    }

    /**
     *  Arrays工具类当中的常用方法：
     *      toString()  binarySearch()  copyOf()    clone()
     *      fill()      copyOfRange()   equals()    sort() - 底层是
     *
     * @param args
     */

    public static void main4(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = new int[10];
        int[] array3 = new int[10];

        //在数组全局中填充元素
        Arrays.fill(array2, 8);
        //结果是放了10个8
        System.out.println(Arrays.toString(array2));

        //在数组中的局部填充元素
        Arrays.fill(array3, 2, 5, 8);
        System.out.println(Arrays.toString(array3));

        //判断两个数组是否相等
        System.out.println(Arrays.equals(array, array1));

        //拷贝数组中固定位置的数字
        int[] ret = Arrays.copyOfRange(array, 2, 5);
        System.out.println(Arrays.toString(ret));

        //从第几号位置到第几号位置寻找指定数字，区间是左闭右开
        System.out.println(Arrays.binarySearch(array, 2, 5, 4));
    }

    /**
     *  查找数组中指定的元素（顺序查找 + 二分查找）
     * @param args
     */

    //顺序查找
    public static int find(int[] array, int key){
        for (int i = 0; i < array.length; i++){
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }

    //二分查找：折半查找(必须是有序序列)
    //在主方法中写上了一个Java库中已经包含的二分查找的方法
    public static int binarySearch(int[] array, int key){
        Arrays.sort(array);
        int i = 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (left <= right){

            //>>：有符号右移运算，若参与运算的数字为正，则在高位补0，若为负则在高位补1
            //>>>:无符号右移运算，无论参与运算的数字为正数还是负数，都在高位补0
            mid = (left + right) >>> 1;
            //mid = (left + right) / 2;

            if(array[mid] < key){
                left = mid + 1;
            }else if(array[mid] > key){
                right = mid - 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    public static void main3(String[] args) {
        int[] array = {12, 2, 24, 76, 18, 13};
        System.out.println(find(array, 18));
        System.out.println(binarySearch(array, 18));

        //Java中自带的二分查找方法
        System.out.println(Arrays.binarySearch(array, 5));
    }

    /**
     * 数组拷贝的四种方式（浅拷贝）
     *      浅拷贝：数组中存放的引用类型（如地址0x999）
     *              只复制指向某个对象的指针，而不复制对象本身，新旧对象还是共享同一块内存。
     *              即复制原来数组的地址，array2中某个数组地址指向的值改了，array1也会改
     *
     *      1.for循环
     *
     *      2. Arrays.copyOf()
     *          public static int[] copyOf(int[] original, int newLength) {
     *             int[] copy = new int[newLength];
     *             System.arraycopy(original, 0, copy, 0,
     *                     Math.min(original.length, newLength));
     *             return copy;
     *         }
     *
     *       3.System.arraycopy();   ---速度最快
     *          public static native void arraycopy(Object src,  int  srcPos,
     *                                         Object dest, int destPos,
     *                                         int length);
     *          因为是native方法，所以底层方法是C/C++代码实现的，速度快
     *          src代表原数组，srcPos代表原数组中开始拷贝的位置
     *          dest代表目的地数组，destPos代表拷到哪个位置，length代表拷贝的长度
     *
     *       4.array.clone()       ---产生了这个对象的一个副本
     *
     *  深拷贝：
     *         数组中存储的简单类型（如int），通过array2修改array2自己的元素，不会影响到array1，
     *         那么浅拷贝就可以认为是深拷贝
     *
     *         在其它类型，需要在拷贝一个副本，改正这个副本的内容，从而原数组不会改动
     *
     *
     */

    public static void main2(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        //第二种方法：Arrays.copyOf()
        int[] ret = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(ret));

        //第三种方法：System.arraycopy();
        int[] temp = new int[array.length];
        System.arraycopy(array,0,temp,0,array.length);
        System.out.println(Arrays.toString(temp));

        //第四种方法：array.clone()
        int[] tmp = array.clone();
        System.out.println(Arrays.toString(tmp));
    }

    /**
     * 数组拷贝
     * @param array
     * @return
     */
    public static int[] arrayCopy(int[] array){
        int[] temp = new int[array.length];

        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }


        return temp;

    }

    public static void main1(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] temp = arrayCopy(array);
        System.out.println(Arrays.toString(temp));
    }

}
