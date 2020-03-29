package HomeWork.lesson_5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    // конструктор сотрудника
    public Employee(String fullName, String position, String email, long phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", salary=" + salary + "рублей" +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }
}

