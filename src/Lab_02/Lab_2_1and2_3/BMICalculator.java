package Lab_02.Lab_2_1and2_3;

import java.util.Scanner;

//Exercise 2.1 & 2.3
public class BMICalculator {
    final static float UNDERWEIGHT_BMI = 18.5f;
    final static float MIN_NORMAL_WEIGHT_BMI = 18.5f;
    final static float MAX_NORMAL_WEIGHT_BMI = 25f;
    final static float MIN_OVERWEIGHT_BMI = 25f;
    final static float MAX_OVERWEIGHT_BMI = 30f;

    public static void main(String[] args) {
        System.out.println("Welcome ");
        boolean isEnded = false;
        while (!isEnded) {
            float userHeight = getInputValue("Enter your height(meter): ");
            float userWeight = getInputValue("Enter your weight(kilogram): ");
            final float BMI_INDEX = userWeight / (userHeight * 2);

            if (BMI_INDEX < UNDERWEIGHT_BMI) {
                System.out.printf("Your BMI is %f, you are underweight...", BMI_INDEX);
                suggestUserWeight(userWeight, userHeight, BMI_INDEX);
            } else if (MIN_NORMAL_WEIGHT_BMI <= BMI_INDEX && BMI_INDEX < MAX_NORMAL_WEIGHT_BMI) {
                System.out.printf("Your BMI is %f, you are OK\n", BMI_INDEX);
            } else if (MIN_OVERWEIGHT_BMI <= BMI_INDEX && BMI_INDEX < MAX_OVERWEIGHT_BMI) {
                System.out.printf("Your BMI is %f, you are overweight\n", BMI_INDEX);
                suggestUserWeight(userWeight, userHeight, BMI_INDEX);
            } else {
                System.out.printf("Your BMI is %f, you might need to go doctor...\n", BMI_INDEX);
                suggestUserWeight(userWeight, userHeight, BMI_INDEX);
            }

            isEnded = getInputValue("Press any number to re-enter. Enter 0 to quit ") == 0;
        }
    }

    public static float getInputValue(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextFloat();
    }

    public static void suggestUserWeight(float userWeight, float userHeight, float BMIIndex) {
        if (BMIIndex > MAX_NORMAL_WEIGHT_BMI) {
            float desiredWeight = MAX_NORMAL_WEIGHT_BMI * 2 * userHeight;
            System.out.printf("\n Your weight must be decreased by %.1f kilogram to be fit\n", userWeight - desiredWeight);
        }
        if (BMIIndex < MIN_NORMAL_WEIGHT_BMI) {
            float desiredWeight = MIN_NORMAL_WEIGHT_BMI * 2 * userHeight;
            System.out.printf("\n Your weight must be increased by %.1f kilogram to be fit\n", desiredWeight - userWeight);
        }
    }
}
