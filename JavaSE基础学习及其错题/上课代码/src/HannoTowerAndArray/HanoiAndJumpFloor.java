package HannoTowerAndArray;

import java.util.Scanner;

public class HanoiAndJumpFloor {

    /**
     * 变态跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * @param target
     * @return
     */

    public static int JumpFloor1(int target){
        if(target == 1){
            return 1;
        } else if(target > 1) {
            return JumpFloor1(target - 1) * 2;
        } else {
            return -1;
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int step = scanner.nextInt();

        int num = JumpFloor1(step);
        System.out.println(num);
    }

    /*
    Jump Step：可以跳一级或二级台阶
     */
    public static int JumpFloor(int target){
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int step = scanner.nextInt();

        int num = JumpFloor(step);
        System.out.println(num);
    }

    /*
     * Hanoi Tower
     */
    public static void move(char pos1, char pos2){
        //模拟移动过程
        System.out.println(pos1 + "->" + pos2 + " ");
    }

    /**
     *
     * @param n         n为要移动的盘子个数
     * @param pos1      pos1 为起始位置
     * @param pos2      pos2 为中途位置
     * @param pos3      pos3 为目的地位置
     */
    public static void Hanoi(int n, char pos1, char pos2, char pos3){
        if(n == 1){
            move(pos1, pos3);
        }else {
            //先通过pos3把盘子移动到pos2
            Hanoi(n - 1, pos1,pos3, pos2);
            //当把盘子都移动过来，最大盘在pos3上，需要将把其余盘子移动到1上，然后再到3
            Hanoi(n-1, pos2, pos1, pos3);
        }
    }

    public static void main1(String[] args) {
        Hanoi(1, 'A','B','C');
        System.out.println();
        Hanoi(4, 'A','B','C');
        System.out.println();
    }
}
