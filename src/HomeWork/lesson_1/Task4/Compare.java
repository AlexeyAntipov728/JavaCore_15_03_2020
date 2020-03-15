package HomeWork.lesson_1.Task4;

public class Compare {
    public static boolean compare(int a, int b) {
        if ((a + b >= 10) & (a + b <= 20)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(compare(15, 1));
    }
}

