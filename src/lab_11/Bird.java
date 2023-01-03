package lab_11;

public class Bird extends Animal {

    final int MAX_SPEED = 100000;

    protected Bird(String name) {
        super(name);
        flyAble = new Fly();
    }

    @Override
    protected int getMaxSpeed() {
        return MAX_SPEED;
    }
}
