package lab_08_encapsualtion;

import java.security.SecureRandom;

public class Animal {
    private boolean hasWing;
    private int speed;
    private String name;
//    public AnimalWithBuilder() {
//    }

    public boolean isHasWing() {
        return hasWing;
    }

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    //    exclusive constructor for inner class, no one can access directly
    protected Animal(Builder builder) {
        hasWing = builder.hasWing;
        speed = builder.speed;
        name = builder.name;
    }
//    inner class for constructor data, only call AnimalWithBuilder when Builder class call method build
    public static class Builder {
        private boolean hasWing;
        private int speed;
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setHasWing(boolean hasWing) {
            this.hasWing = hasWing;
            return this;
        }

        public Builder setSpeed(int maxSpeed) {
            this.speed = new SecureRandom().nextInt(maxSpeed);
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}
