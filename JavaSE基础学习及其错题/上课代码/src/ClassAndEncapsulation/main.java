package ClassAndEncapsulation;



public class main {

    public static void swap(int[] array, int[]array2){
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            temp = array[i];
            array[i] = array2[i];
            array2[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};

        swap(array1, array2);

        for (int val:array1) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val1: array2) {
            System.out.print(val1 + " ");
        }
    }
}