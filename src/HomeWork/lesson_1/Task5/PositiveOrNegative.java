package HomeWork.lesson_1.Task5;

public class PositiveOrNegative {
    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Число " + x + " положительное");
        } else {
            System.out.println("Число " + x + " отрицательное");
        }
    }

    public static void main(String[] args) {
        isPositiveOrNegative(10);
    }
}
