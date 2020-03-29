package HomeWork.lesson_5;

//        1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//        2. Конструктор класса должен заполнять эти поля при создании объекта.
//        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//        4. Создать массив из 5 сотрудников.
//           Пример:
//           Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//           persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//           persArray[1] = new Person(...);
//           ...
//           persArray[4] = new Person(...);
//        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.


public class Main {

    public static void main(String[] args) {
//        Employee employee = new Employee("Антипов Алексей Викторович", "Инженер технолог", "LiTe728@yandex.ru", 89169419490L, 140000, 53);
//        System.out.println(employee);


        // Массив сотрудников с выводом тех кому за сорок. В данном примере выводит 2, 3, 4 элементы массива.
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Test Testovich", "sucker", "qwerty@qwerty.ru", 88888888888L, 25000, 33);
        employees[1] = new Employee("Гурьева Инесса Константиновна", "маркетолог", "mailinessa@yandex.ru", 89031231212L, 800000, 27);
        employees[2] = new Employee("Подольский Дмитрий Олегович", "front-end developer", "podolskrules@yandex.ru", 89166547898L, 125000, 42);
        employees[3] = new Employee("Крестовский Кирилл Васильевич", "Водитель", "restov666@yandex.ru", 89255698973L, 69000, 53);
        employees[4] = new Employee("Авакян Нарек Родессович", "Аналитик", "avakyannr@sberbank.ru", 89264652961L, 250000, 48);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40)
                System.out.println(employees[i]);
        }

    }
}
