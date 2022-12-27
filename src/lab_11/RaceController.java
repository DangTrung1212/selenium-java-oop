package lab_11;


import java.util.Arrays;
import java.util.List;

public class RaceController {
    public static void main(String[] args) {
        Animal tiger = new Tiger("Tiger");
        Animal tiger2 = new Tiger("Tiger2");
        Animal bird = new Bird("Bird");
        getWinner(Arrays.asList(tiger, tiger2, bird));


    }

    public static void getWinner(List<Animal> animals) {
        int max = 0;
        String winner = "";
        for (Animal animal : animals) {
            if (!animal.flyAble.isFly()) {
                if (animal.getSpeed() > max) {
                    max = animal.getSpeed();
                    winner = animal.getName();
                }
            }
        }
        System.out.printf("Winner is %s, with %d km/h", winner, max);
    }
}
