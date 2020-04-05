package HomeWork.lesson_6;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {

        if (food < n) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void plateInfo() {
        System.out.println("В тарелке : " + food);
    }

    public void addFood(int food) {
        this.food += food;
    }

}
