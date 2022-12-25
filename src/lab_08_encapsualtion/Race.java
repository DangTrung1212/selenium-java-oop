package lab_08_encapsualtion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static lab_08_encapsualtion.Animal.*;

public class Race {
    public static void main(String[] args) {
//        Method chain
        Builder builder = new Builder();
        Animal tiger = builder.setHasWing(false).setName("Tiger").setSpeed(100).build();
        Animal snake = builder.setHasWing(false).setName("Snake").setSpeed(50).build();
        Animal bird = builder.setHasWing(true).setName("bird").setSpeed(100).build();
        List<Animal> animals = Arrays.asList(tiger, snake, bird);
        getWinner(animals);
    }
    public static void getWinner(List<Animal> animals) {
        List<Animal> animalsWithoutWing = removeFlyAnimal(animals);
        int max = animalsWithoutWing.get(0).getSpeed();
        String winner = animalsWithoutWing.get(0).getName();
        for (Animal animal : animalsWithoutWing) {
            if (animal.getSpeed() > max ) {
                max = animal.getSpeed();
                winner= animal.getName();
            }
        }
        System.out.printf("Winner is %s, with %d km/h", winner, max);

    }
    public static List<Animal> removeFlyAnimal(List<Animal> animals) {
        List<Animal> animalsWithoutWing = new ArrayList<>();
        for (Animal animal : animals) {
            if (!animal.isHasWing()) {
                animalsWithoutWing.add(animal);
            }
        }
        return animalsWithoutWing;
    }
}
