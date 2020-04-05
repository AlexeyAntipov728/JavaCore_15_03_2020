package HomeWork.lesson_6;

public class Dog extends Animals {

    private boolean hungry;

    public Dog(String name, int appetite) {
        super(name, appetite);
        this.hungry = true;
//        System.out.println("Мы создали собаку " + name);
    }

    @Override
    public void jump(double jump) {
        if (jump <= 0.5)
            System.out.println(name + " прыгнул на " + jump + " метров");
        else
            System.out.println("Так высоко даже собаки не прыгают");
    }

    @Override
    public void swim(int swim) {
        if (swim <= 100)
            System.out.println(name + " проплыл " + swim + " метров");
        else
            System.out.println("Так долго даже собаки не плавают");
    }

    @Override
    public void run(int run) {
        if (run <= 500)
            System.out.println(name + " пробежал " + run + " метров");
        else
            System.out.println("Так долго даже собаки не бегают");
    }

    @Override
    public void eat(Plate p) {
        if (hungry && p.decreaseFood(appetite))
            System.out.println(name + " съел " + appetite);
        else {
            hungry = false;
            System.out.println("Для " + name + " пса нет еды в тарелке");
        }

    }
}
