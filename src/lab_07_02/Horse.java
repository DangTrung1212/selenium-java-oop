package lab_07_02;

import lab_07_02.Animal;

public class Horse extends Animal {
    final public static int MAX_SPEED = 75;

    public Horse(String name) {
        super(MAX_SPEED, name);
    }
}
