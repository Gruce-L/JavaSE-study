package HannoTowerAndArray;

import java.util.Arrays;

public class HomeWork_04_14 {

    /**
     * 第一题：找出出现一次的数字
     *          ^：两个相同的数字如果进行异或，结果就是0，0异或任何数字，结果都是任何数字，
     *             相同数字异或的结果为0
     * @param nums
     * @return
     */

    //法一：异或（在主函数中）

    //法二：比较
    public static int findNum(int[] nums) {
        Arrays.sort(nums);
        int onenum=0;
        int i = 1;
        for(i=1;i<nums.length-2;i++){
            if((nums[i]!=nums[i-1])&&(nums[i]!=nums[i+1])){
                onenum= nums[i];
            }
        }
        if((nums[i] != nums[i + 1]) && (nums[i] == nums[i-1])){
            onenum = nums[i + 1];
        }
        return onenum;
    }



    public static void main1(String[] args) {
        int[] nums = new int[]{1, 3, 2, 4, 2, 1, 4};

        //法一：
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            num ^= nums[i];
        }
        System.out.println(num);

        //法二：
        int ret = findNum(nums);
        System.out.println("只出现一次的数字为" + ret);
    }



}
