package Lab_03;

import Helper.Input;

import java.util.Arrays;
import java.util.HashMap;

public class OriginalArray {
    public static void main(String[] args) {
        int[] first = {1,8,11, 12, 19};
        int[] second = {1,8,11};
        sortTwoSortArrays(Input.getIntArrayInputValue(), Input.getIntArrayInputValue());
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

//    Solution 1: Loop through array, keep for loop from the element next to i to the last element,
//    find min number and swap with number i
    public static int[] linearSort(int[] intArr) {
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

// Solution 2: linear sort using temp arr, every time sortedArr get pushed element, temp arr tracks that element and
//              pop that element from intArr
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
            intArr = temp; // assign again to reduce intArr length
            sortArrIndex++;
        }
        System.out.println(Arrays.toString(sortedArr));
        return sortedArr;
    }

//  Solution 3:  Bubble Sort
    public static int[] bubbleSort(int[] intArr) {
        while (true) {
            int swapNumbers = 0;
            for (int i = 0; i < intArr.length - 1; i++) {
                if (intArr[i] > intArr[i + 1]) {
                    int temp = intArr[i];
                    intArr[i] = intArr[i + 1];
                    intArr[i + 1] = temp;
                    swapNumbers++;
                }
            }
            if (swapNumbers == 0) {
                break;
            }
        }
        System.out.println(Arrays.toString(intArr));
        return intArr;
    }
                                 /* 3.4 sort array of 2 sorted arrays */

//    Solution 1: compare two tracking index, push smaller value to mergedSortArr, increase its index,
//    find the array still has element, assign the left elements to mergeSortArr.
    public static int[] sortTwoSortArrays(int[] intArr1, int[] intArr2) {

        int[] mergedSortArr = new int[intArr1.length + intArr2.length];
        int i = 0;
        int j = 0;
//      while loop until 1 array done
        while (i < intArr1.length && j < intArr2.length) {
            if (intArr1[i] < intArr2[j]) {
                mergedSortArr[i+j] = intArr1[i];
                i++;

            } else {
                mergedSortArr[i+j] = intArr2[j];
                j++;
            }
        }
//        current index of mergedSortArr
        int indexAfterSort = j + i;
//        find which array has left element, while loop until finishing mergedSortArray
        if (i-j >= 0) {
            while (indexAfterSort < mergedSortArr.length) {
//
                    mergedSortArr[indexAfterSort] = intArr2[j];
                    j++;
                    indexAfterSort++;
            }
        } else {
            while (indexAfterSort < mergedSortArr.length) {
                mergedSortArr[indexAfterSort] = intArr1[i];
                i++;
                indexAfterSort++;
            }
        }
        System.out.println(Arrays.toString(mergedSortArr));
        return mergedSortArr;
    }
}
