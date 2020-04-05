package HomeWork.lesson_6;

public abstract class Animals {
    public String name;
    public int appetite;

    public Animals(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public abstract void jump(double jump);

    public abstract void swim(int swim);

    public abstract void run(int run);

    public abstract void eat(Plate p);

}
