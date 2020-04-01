package HomeWork.lesson_6;

public class Cat extends Animals {

    public Cat(String name) {
        super(name);
        System.out.println("Мы создали кота " + name);
    }

    @Override
    public void jump(double jump) {
        if (jump <= 2)
            System.out.println(name + " прыгнул на " + jump + " метров");
        else
            System.out.println("Так далеко даже коты не прыгают");

    }

    @Override
    public void swim(int swim) {

        System.out.println("Котики не плавают");
    }

    @Override
    public void run(int run) {
        if (run <= 200)
            System.out.println(name + " пробежал " + run + " метров");
        else
            System.out.println("Так долго даже коты не бегают");
    }

}
