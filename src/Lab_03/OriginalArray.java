package Lab_03;

import Helper.Input;

import java.util.Arrays;
import java.util.HashMap;

public class OriginalArray {
    public static void main(String[] args) {
        bubbleSort(Input.getIntArrayInputValue());
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
        System.out.println("Odd Numbers: " + numbersOfOdd);
        System.out.println("Even Numbers: " + numbersOfEven);
    }

    /* LAB 3.2 */
    public static HashMap<String, Integer> findMaxMin(int[] intArr) {
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
        HashMap<String, Integer> minMax = new HashMap<>();
        minMax.put("min", min);
        minMax.put("max", max);
        return minMax;
    }

    /* LAB 3.3 */
    public static int[] linearSort(int[] intArr) {
//        Loop through array, find min number and swap with number i
        for (int i = 0; i < intArr.length; i++) {
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

    //  linear sort using temp arr
    public static int[] linearSort2(int[] intArr) {
        int[] sortedArr = new int[intArr.length];
        int sortArrIndex = 0;
        while (intArr.length > 0) {
//           find min of temp array, assign to sort array elements
            sortedArr[sortArrIndex] = findMaxMin(intArr).get("min");
            int[] temp = new int[intArr.length - 1];
//          copy array to temp, reduce min element per time
            for (int i = 0, k = 0; i < intArr.length; i++) {
                if (intArr[i] != sortedArr[sortArrIndex]) {
                    temp[k++] = intArr[i];
                }
            }
            intArr = temp; // assign again
            sortArrIndex++;
        }
        System.out.println(Arrays.toString(sortedArr));
        return sortedArr;
    }

    //    Bubble Sort
    public static int[] bubbleSort(int[] intArr) {
        while (true) {
            int swapNumber = 0;
            for (int i = 0; i < intArr.length - 1; i++) {
                if (intArr[i] > intArr[i + 1]) {
                    int temp = intArr[i];
                    intArr[i] = intArr[i + 1];
                    intArr[i + 1] = temp;
                    swapNumber++;
                }
            }
            if (swapNumber == 0) {
                break;
            }
        }
        System.out.println(Arrays.toString(intArr));
        return intArr;
    }
/* 3.4 sort array of 2 sorted arrays
 */
//    public static int[] sortTwoSortArrays(int[] intArr1, int[] getIntArr2) {
//        int[] combinedArray = new int[intArr1.length + getIntArr2.length];
//        if (intArr1.length >= getIntArr2.length) {
//            for (int i = 0, j = 0; i < intArr1.length; i++) {
//
//
//            }
//        }
//    }
}
