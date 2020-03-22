package HomeWork.lesson_3;


import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
    /*  1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
    При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).   */
        guess(5);
        word();
    }

    public static void guess(int n) {

        int number = 9;
        int guessedNumber = (int) (Math.random() * number);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сыграем в угадайку? 1 - да, 0 - нет");
        int userAnswer = scanner.nextInt();
        if (userAnswer == 1) {

            for (int i = 1; i <= n; i++) {
                System.out.println("Введи число");
                int userVersion = scanner.nextInt();

                if (userVersion == guessedNumber) {
                    System.out.println("Поздравляю, вы угадали!");

                    System.out.println("Повторить? 1- да, 0 - нет");
                    int exit = scanner.nextInt();
                    if (exit == 0)
                        System.out.println("Жаль.");
                    break;
                } else if (userVersion > guessedNumber) {
                    System.out.println("Вы ввели слишком большое число.");
                    System.out.println("Попробуй еще раз");
                } else if (userVersion < guessedNumber) {
                    System.out.println("Вы ввели слишком маленькое число.");
                    System.out.println("Попробуй еще раз");
                }
            }


        } else {
            System.out.println("Ну лан. Чао!");
        }
    }

    public static void word() {

        /*  Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
            При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
            сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
            apple – загаданное
            apricot - ответ игрока
            ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
            Для сравнения двух слов посимвольно, можно пользоваться:
            String str = "apple";
            str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
            Играем до тех пор, пока игрок не отгадает слово
            Используем только маленькие буквы   */

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        int random = (int) (Math.random() * words.length);
        String hiddenWord = words[random];
        System.out.println(hiddenWord);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Я слово загадал, а ты угадывай.");

        char[] hiddenWordArr = words[random].toCharArray();
        char[] hint = new char[hiddenWordArr.length];

        while (true) {
            String userAnswer = scanner.nextLine();
            char[] userAnswerArr = userAnswer.toCharArray();
            if (userAnswer.equals(hiddenWord)) {
                System.out.println("Угадал");
                break;
            } else {
                System.out.println("Не угадал");

                for (int i = 1; i < hiddenWordArr.length + 1; i++) {
                    System.out.println("Буквы на своих местах");
                    for (int j = 0; i < hiddenWordArr.length; i++) {
                        for (int k = 0; j < userAnswerArr.length; j++) {
                            if (hiddenWordArr[j] == userAnswerArr[j]) {
                                hint[k] = userAnswerArr[j];
                            } else if (hiddenWordArr[j] != userAnswerArr[j]) {
                                hint[k] = '#';
                            }
                            System.out.print(hint);
                        }
                    }
                }
            }
        }
    }

}