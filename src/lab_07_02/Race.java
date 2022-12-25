package lab_07_02;

import java.util.Arrays;
import java.util.List;

public class Race {

    public static void main(String[] args) {
        Animal dog = new Dog("dog");
        Animal tiger= new Tiger("tiger");
        Animal horse = new Horse("horse");
        List<Animal> animals = Arrays.asList(dog,tiger,horse);
        getWinner(animals);
    }

    public static void getWinner(List<Animal> animals){
        int max = animals.get(0).getSpeed();
        String winner = "";
        for (Animal animal : animals) {
            if (animal.getSpeed() > max) {
                max = animal.getSpeed();
                winner = animal.getName();
            }
        }
        System.out.printf("Winner is %s, with %d km/h", winner, max);
    }
}
