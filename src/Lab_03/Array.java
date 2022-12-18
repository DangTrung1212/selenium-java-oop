package Lab_03;

import Helper.Input;

public class Array {
    public static void main(String[] args) {
        countOddEven(Input.getIntArrayInputValue());
    }

//    lab 3.1
    public static void countOddEven(int[] intArr) {
        int numbersOfOdd = 0;
        int numbersOfEven = 0;
        for (int j : intArr) {
            if (j % 2 == 0) {
                numbersOfOdd++;
            } else {
                numbersOfEven++;
            }
        }
        System.out.println("Odd Numbers: " + numbersOfOdd );
        System.out.println("Even Numbers: " + numbersOfEven );
    }
}
