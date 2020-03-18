package HomeWork.lesson_2.Task5;

import java.util.Arrays;

public class MinMaxElements {
    /*  ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        Про сортировку элементов и то, что по умолчанию они сортируются по возрастанию - было на уроке. */

    public static void main(String[] args) {
        int [] arr = {-2,38,-24,15,9};
        Arrays.sort(arr);
        System.out.println("Минимальный элемент: " + arr[0] + "\nМаксимальный элемент: " + arr[arr.length - 1]);
    }
}
