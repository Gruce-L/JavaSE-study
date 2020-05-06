package SeqList;

import java.util.Arrays;

/**
 * 顺序表中需要有elem数组 - 计入数字 + usedSize - 记录元素的个数
 */

public class MyArrayList {

    public int[] elem;          //数组
    public int usedSize;        //有效的数据个数
    public static final int initCapacity = 10;      //初始容量

    /**
     * 使用构造方法对数组和数据个数进行初始化
     */
    public MyArrayList(){
        this.elem = new int[initCapacity];
        this.usedSize = 0;
    }

    /**
     * 打印顺序表
     */
    public void display(){
        for(int i = 0; i < this.usedSize; i++){
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    /**
     *  1.在pos位置新增元素    不能让原来存储的元素被挤掉，只能把别的元素往后移，再插入，usedSize+1
     *          先判断pos位置是否合法，负数或者超过usedSize都不可以
     *          判断元素的存储个数是不是满了
     *
     *  2.为什么isFull方法是私有的：因为这个方法是提供给add的
     * @param pos
     * @param data
     */
    private boolean isFull(){
//        if(elem.length == usedSize){
//            return true;
//        }
//        return false;
        return this.elem.length == this.usedSize;
    }

    public void add(int pos, int data){

        //先检查数组中的位置是否合法
        checkPos(pos);

        /**
         *  如果此时数组的长度是满的，那么把数组长度扩为2倍
         */

        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
            //return;
        }

        for(int i = this.usedSize - 1; i >= pos; i--){
            this.elem[i + 1] = this.elem[i];
        }

        this.elem[pos] = data;
        this.usedSize++;
    }

    /**
     * 判定是否包含某个元素
     * @param toFind
     * @return
     */
    public boolean contains(int toFind){
        int left = 0;
        int right = elem.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if(toFind < elem[mid]){
                right = mid - 1;
            } else if(toFind > elem[mid]){
                left = mid + 1;
            } else{
                return true;
            }
        }

        return false;

    }

    /**
     * 查找某个元素对应的位置
     * @param args
     */
    public int binarySearch(int toFind){
        int left = 0;
        int right = elem.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if(toFind < elem[mid]){
                right = mid - 1;
            } else if(toFind > elem[mid]){
                left = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    //第二种查找方法：顺序查找
    public int sequenceSearch(int toFind){
        for (int i = 0; i < this.usedSize; i++){
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    /**
     * 把固定位置的元素设置为value
     * @param pos
     * @param value
     */
    public void setPos(int pos, int value){
        checkPos(pos);
        this.elem[pos] = value;
    }

    /**
     * 获取 pos 位置的元素
     *      注意：判断pos的合法性 + 顺序表是否为空，返回 -1
     *            不能写成this.elem == null，因为在初始时已经分配一个存储10个字的数组
     * @param args
     */

    private void checkPos(int pos){
        if(pos < 0 || pos > this.usedSize){
            throw new RuntimeException("pos位置不合法");
        }
    }

    private boolean isEmpty(){
        return this.usedSize == 0;
    }

    public int getPos(int pos){
        if(isEmpty()){
            //如果数组中真的存储-1，会导致误解
            //return -1;

            //正解：手动抛出异常
            throw new RuntimeException("顺序表为空");
        }

        checkPos(pos);

        return this.elem[pos];

    }

    /**
     * 删除第一次出现的关键字key
     *      1.找这个数字在哪里，并知道他的下标
     *      2.让后面的元素覆盖掉前面的值，usedSize - 1
     * @param args
     */
    public void remove(int toRemove){
        int index = sequenceSearch(toRemove);

        if(index == -1){
            System.out.println("没有需要删除的元素");
            return;
        }

        for(int i = index; i < this.usedSize - 1; i++){
            this.elem[i] = this.elem[i + 1];
        }

        this.usedSize--;
    }

    /**
     * 获取顺序表长度
     * @param args
     */
    public int size() { return this.usedSize; }

    /**
     * 清空顺序表
     * @param args
     */
    public void clear(){
        this.usedSize = 0;
    }

}
