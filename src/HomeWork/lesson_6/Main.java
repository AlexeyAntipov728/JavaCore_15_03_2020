package HomeWork.lesson_6;

import java.util.Scanner;
/*  1. Создать классы Собака и Кот с наследованием от класса Животное.
    2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
       или высоту (для прыжков).
    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
    4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
    5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м. */

public class Main {
    public static void main(String[] args) {
        System.out.println("Какое животное создаем? 1- кот, 2 - собака.");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer == 1) {
            Cat cat = new Cat("Snowball");
            cat.run(10);
            cat.jump(10);
            cat.swim(10);
        }
        if (answer == 2) {
            Dog dog = new Dog("Graf");
            dog.jump(0.3);
            dog.run(15);
            dog.swim(2);

        }

    }
}
