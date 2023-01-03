package lab_11;

import java.security.SecureRandom;

public abstract class Animal {
    protected FlyAble flyAble;
    private final int speed;
    private final String name;

    protected Animal(String name) {
        this.name = name;
        this.speed = new SecureRandom().nextInt(getMaxSpeed());
    }

    protected abstract int getMaxSpeed();

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
