package HomeWork.lesson_2.Task4;

public class DiagonalFill {
    /*  Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;   */

    public static void main(String[] args) {
        int n = 5;                              // задаем размер массивов
        int[][] diagonal = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || n - i == j + 1) {
                    diagonal[i][j] = diagonal[i][n - i - 1] = 1;
                }
                System.out.print(diagonal[i][j]);
            }
            System.out.println();
        }
    }
}

