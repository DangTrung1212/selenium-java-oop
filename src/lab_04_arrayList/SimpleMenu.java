package lab_04_arrayList;

import helper.Input;
import lab_03_array.OriginalArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleMenu {
    static List<Integer> arrayList = new ArrayList<>();
    static boolean isContinued = true;

    public static void main(String[] args) {
        do {
            printMenuOption();
            int optionNumber = Input.getIntInputValue("Enter your option number: ");
            handleUserOption(optionNumber);
        } while (isContinued);
    }

    public static void printMenuOption() {
        System.out.println(
                "=====MENU======\n" +
                        "0. Exit\n" +
                        "1. Add number into ArrayList\n" +
                        "2. Print numbers\n" +
                        "3. Get maximum number\n" +
                        "4. Get minimum number\n" +
                        "5. Search number"
        );
    }

    public static void handleUserOption(int optionNumber) {
        switch (optionNumber) {
            case 0:
                System.out.println("Thank you for joining. ");
                isContinued = false;
                break;
            case 1:
                addNumberToArrayList(arrayList);
                break;
            case 2:
                printNumbersOfArrayList(arrayList);
                break;
            case 3:
                System.out.println(getMinMaxInArrayList(arrayList).get("max"));
                break;
            case 4:
                System.out.println(getMinMaxInArrayList(arrayList).get("min"));
                break;
            case 5:
                int index = getIndexOfInputNumber(arrayList);
                if (index != -1) {
                    System.out.println("Index of your number is: " + index);
                } else {
                    System.out.println("Your number is not in ArrayList...");
                }
                break;
            default:
                System.out.println("Please enter valid number ");
        }
    }

    public static void addNumberToArrayList(List<Integer> arrayList) {
        int number = Input.getIntInputValue("Enter number you want to add into ArrayList: ");
        arrayList.add(number);
    }

    public static void printNumbersOfArrayList(List<Integer> arrayList) {
        System.out.println("This is numbers of ArrayList: ");
        try {
            for (int integer : arrayList) {
                System.out.println(integer);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is no number in ArrayList.");
        }
    }

    public static HashMap<String, Integer> getMinMaxInArrayList(List<Integer> arrayList) {
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return OriginalArray.findMaxMin(array);
    }

    public static int getIndexOfInputNumber(List<Integer> arrayList) {
        int number = Input.getIntInputValue("Enter number you want to search: ");
        return arrayList.indexOf(number);
    }
}
