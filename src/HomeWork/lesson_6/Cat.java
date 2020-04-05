package HomeWork.lesson_6;

public class Cat extends Animals {
    private boolean hungry;

    public Cat(String name, int appetite) {
        super(name, appetite);
        this.hungry = true;
//        System.out.println("Мы создали кота " + name);
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

    @Override
    public void eat(Plate p) {
        if (hungry && p.decreaseFood(appetite))
            System.out.println(name + " cъел " + appetite);
        else {
            hungry = false;
            System.out.println("Для " + name + " кота не осталось еды");
        }
    }
}
