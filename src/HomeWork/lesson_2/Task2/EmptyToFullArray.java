package HomeWork.lesson_2.Task2;

import java.util.Arrays;

public class EmptyToFullArray {
    /*  Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;   */
    public static void main(String[] args) {

        int[] arr = new int[8];
        arr[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 3;
        }
        System.out.print(Arrays.toString(arr));
    }
}
