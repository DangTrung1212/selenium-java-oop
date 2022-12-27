package lab_11;

public class Tiger extends Animal{
    public final int MAX_SPEED = 100;
    public Tiger(String name) {
        super(name);
        flyAble = new NonFly();
    }

    @Override
    protected int getMaxSpeed() {
        return MAX_SPEED;
    }

}
