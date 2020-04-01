package HomeWork.lesson_6;

public abstract class Animals {
    public String name;

    public Animals(String name) {
        this.name = name;
    }

    public abstract void jump(double jump);

    public abstract void swim(int swim);

    public abstract void run(int run);
}
