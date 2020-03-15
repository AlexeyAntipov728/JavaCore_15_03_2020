package HomeWork.lesson_1.Task3;


public class Calculate {

    public static int result(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static void main(String[] args) {
        System.out.println(result(2,2,2,2));
    }
}

