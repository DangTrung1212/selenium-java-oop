package Lab_02;

import static Lab_02.BMICalculator.getInputValue;
// Exercise 2.2
public class OddEvenIdentifier {
    public static void main(String[] args) {
        System.out.println("Welcome to Odd or Even Identifier ");
        float userInput = getInputValue("Enter your number ");
        if (userInput % 2 == 0) {
            System.out.println("Odd number");
        } else {
            System.out.println("Even number");
        }
    }
}
