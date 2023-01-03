package helper;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static float getFloatInputValue(String message) {
        System.out.print(message);
        return Float.parseFloat(scanner.nextLine());
    }
    public static double getDoubleInputValue(String message) {
        System.out.print(message);
        return Double.parseDouble(scanner.nextLine());
    }

    public static String getStringInputValue(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public static int[] getIntArrayInputValue() {
//        Todo: need to use @Value to assign default value for message
        String sizeMessage = "Enter size of your array: ";
        String elementMessage = "Enter element: ";
        System.out.print(sizeMessage);
        int sizeOfArray = scanner.nextInt();
        int[] intArr = new int[sizeOfArray];
        for (int i = 0; i < intArr.length; i++) {
            System.out.printf(elementMessage);
            intArr[i] = scanner.nextInt();
        }
        return intArr;
    }

    public static int getIntInputValue(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }
}
