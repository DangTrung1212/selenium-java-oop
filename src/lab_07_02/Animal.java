package lab_07_02;

import java.security.SecureRandom;

public class Animal {
    private final int speed;
    private final String name;

    public Animal(int maxSpeed, String name) {
        this.speed = new SecureRandom().nextInt(maxSpeed);
        this.name = name;
        System.out.println(getName() + " " + getSpeed());
    }

    public int getSpeed() {
        return speed;
    }
    public String getName() {
        return name;
    }
}
