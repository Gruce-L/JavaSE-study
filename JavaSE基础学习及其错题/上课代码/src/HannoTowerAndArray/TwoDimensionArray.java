package HannoTowerAndArray;

import java.util.Arrays;

public class TwoDimensionArray {

    /**
     * 不规则的二维数组： C语言中必须指定列，行可以自动推导
     *                  Java中行必须指定，列不可以自动识别的，Java中数组中的数据是引用，
     *                      先指向数组的内容，而且Java中二维数组是一维数组的一维数组
     * @param args
     */

    public static void main3(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{1, 2, 3};
        array[1] = new int[]{4, 5, 6, 7, 8};


    }

    /**
     * 二维数组其实是一维数组中每个元素是一位数组，打印的三种方法
     * @param args
     */

    public static void main2(String[] args) {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}};

        //法一：
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        //法二：
        for (int[] val: array) {
            for (int x:val ) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        //法三：
        System.out.println(Arrays.deepToString(array));
    }

    /**
     *  二维数组创建的三种方式
     * @param args
     */

    public static void main1(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        int[][] array1 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = new int[2][3];

    }
}
