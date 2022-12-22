package lab_02;
import helper.Input;

public class BMICalculator {
    final static float UNDERWEIGHT_BMI = 18.5f;
    final static float MIN_NORMAL_WEIGHT_BMI = 18.5f;
    final static float MAX_NORMAL_WEIGHT_BMI = 25f;
    final static float MIN_OVERWEIGHT_BMI = 25f;
    final static float MAX_OVERWEIGHT_BMI = 30f;

//LAB 2.1

    public static void main(String[] args) {
        System.out.println("Welcome ");
        boolean isEnded = false;
        while (!isEnded) {
            float userHeight = Input.getFloatInputValue("Enter your height(meter): ");
            float userWeight = Input.getFloatInputValue("Enter your weight(kilogram): ");
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

            isEnded = Input.getFloatInputValue("Press any number to re-enter. Enter 0 to quit ") == 0;
        }
    }

//lAB 2.3
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
