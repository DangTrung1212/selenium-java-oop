package Lab_02;

import java.util.Scanner;

public class BMICalculator {
        public static void main(String[] args) {
            System.out.println("Welcome ");
            boolean isEnded = false;
            while (!isEnded) {
                float userHeight = getInputValue("Enter your height(meter): ");
                float userWeight = getInputValue("Enter your weight(kilogram): ");
                final float BMIIndex = userWeight / (userHeight * 2);
                if (BMIIndex < 18.5) {
                    System.out.printf("Your BMI is %f, you are underweight...", BMIIndex);
                } else if (18.5 <= BMIIndex && BMIIndex < 25) {
                    System.out.printf("Your BMI is %f, you are OK\n", BMIIndex);
                } else if (25 <= BMIIndex && BMIIndex < 30) {
                    System.out.printf("Your BMI is %f, you are overweight\n", BMIIndex);
                } else {
                    System.out.printf("Your BMI is %f, you might need to go doctor...\n", BMIIndex);
                }
                isEnded = getInputValue("Press any number to re-enter. Enter 0 to quit ") == 0;
            }
        }

            public static float getInputValue(String message) {
                System.out.print(message);
                return  new Scanner(System.in).nextFloat();
        }
}

