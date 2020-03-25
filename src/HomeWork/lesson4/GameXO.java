package HomeWork.lesson4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameXO {
//Работает на разных размерах полей, есть проверка на выигрыш по диагоналям, столбцам и строкам, есть проверка на ничью. Сделать ИИ хоть немного умнее тапка не смог.

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';

    //|_|_|_|
    //|_|_|_|
    //|_|_|_|

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Это крестики-нолики. Введи размер поля(одна цифра): ");

        int fieldSize = sc.nextInt(); //Игрок сам задает размер поля

        if (args != null && args.length == 1) {
            new GameXO().startGame(Integer.parseInt(args[0]));
        } else {
            new GameXO().startGame(fieldSize);
        }

    }

    private void printTab(char[][] tab) {
        int counter = 1;
        System.out.print("   ");
        for (int i = 0; i < tab.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (char[] chars : tab) {
            System.out.print(counter + " ");
            counter++;
            for (char sym : chars) {
                System.out.print("|" + sym);
            }
            System.out.println("|");
        }
    }

    private void fillTab(char[][] tab) {
        for (char[] chars : tab) {
            Arrays.fill(chars, EMPTY);
        }
    }

    public void startGame(int fieldSize) {
        // TODO: 23.03.2020 *** fieldSize > 3, 4(WIN)
        char[][] tab = new char[fieldSize][fieldSize];
        fillTab(tab);
        System.out.println("Вы играете за Х");
        printTab(tab);
        System.out.println("Для того, чтобы совершить" +
                "" +
                " ход введите номер строки" +
                "и номер столбца таблицы");
        boolean inGame = true;
        Scanner in = new Scanner(System.in);
        while (inGame) {
            System.out.println("Ваш ход:");
            int x, y;
            try {
                x = in.nextInt();
                y = in.nextInt();
                x--;
                y--;
                if (isValid(x, y, tab)) {
                    tab[x][y] = DOT_X;
                    printTab(tab);
                    if (isVictory(tab, DOT_X)) {
                        System.out.println("Вы победили");
                        break;
                    }
                    System.out.print("Компьютер совершает ход");
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(300);
                        System.out.print(".");
                    }
                    System.out.println();
                    movePC(tab);
                    if (isVictory(tab, DOT_O)) {
                        System.out.println("Вы проиграли");
                        break;
                    }

                    if (isEmpty(tab)) {
                        System.out.println("Ничья");
                        break;
                    }

                } else {
                    System.out.println("Данный ход невозможен! Введите новые значения");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Вы ввели не цифры! Введите цифры");
                in.next();
                continue;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //..... game .....
    }
                        // Проверяем на наличие пустых ячеек в поле
    private boolean isEmpty(char[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {                if (tab[i][j] == EMPTY)
                    return false;
            }
        }
        return true;
    }
                         // Проверка на наличии победы
    private boolean isVictory(char[][] tab, char DOT_X) {
        //Проверка линий по диагоналям
        boolean rightDiagonal, leftDiagonal;
        rightDiagonal = true;
        leftDiagonal = true;
        for (int i = 0; i < tab.length; i++) {
            rightDiagonal &= (tab[i][i] == DOT_X);
            leftDiagonal &= (tab[tab.length - i - 1][i] == DOT_X);
        }

        if (rightDiagonal || leftDiagonal)
            return true;
                        //Проверка столбцов и строк
        boolean columns, lines;
        for (int col = 0; col < tab.length; col++) {
            columns = true;
            lines = true;
            for (int lin = 0; lin < tab.length; lin++) {
                columns &= (tab[col][lin] == DOT_X);
                lines &= (tab[lin][col] == DOT_X);
            }

            if (columns || lines)
                return true;
        }

        return false;
    }


    private void movePC(char[][] tab) {
        // TODO: 23.03.2020 smart strategy
        int len = tab.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (tab[i][j] == EMPTY) {
                    tab[i][j] = DOT_O;
                    printTab(tab);
                    return;
                }
            }
        }
    }

    private boolean isValid(int x, int y, char[][] tab) {
        int len = tab.length;
        if (x >= 0 && x < len && y >= 0 && y < len) {
            if (tab[x][y] == EMPTY) {
                return true;
            }
        }
        return false;
    }
}