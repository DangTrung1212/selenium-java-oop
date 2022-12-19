package Lab_03;

import Helper.Input;

import java.util.Arrays;

public class OriginalArray {
    public static void main(String[] args) {
        lineNearSort(Input.getIntArrayInputValue());
    }

/* LAB 3.1 */
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

/* LAB 3.2 */
    public static void findMaxMin(int[] intArr) {
        int max = intArr[0];
        int min = intArr[0];
        for (int number : intArr) {
            if (number >= max) {
                max = number;
            }
            if (number <= min) {
                min = number;
            }
        }
        System.out.println("Max number is: " + max);
        System.out.println("Min number is: " + min);
    }
/* LAB 3.3 */
    public static int[] linearSort(int[] intArr) {
//        Loop through array, find min number and swap with number i
        for (int i = 0 ; i < intArr.length; i++ ) {
            int min = intArr[i];
            int minIndex = i;
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[j] <= min) {
                    min = intArr[j];
                    minIndex = j; //detect minIndex to swap later
                }
            }
            int temp = intArr[i];
            intArr[i] = min;
            intArr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(intArr));
        return intArr;
    }


}

