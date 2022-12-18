package Helper;

import java.util.Scanner;

public class Input {
    public static float getFloatInputValue(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextFloat();
    }
    public static String getStringInputValue(String message) {
        System.out.print(message);
        return new Scanner(System.in).next();
    }
    public static int[] getIntArrayInputValue() {
//        Todo: need to use @Value to assign default value for message
        String sizeMessage = "Enter size of your array: ";
        String elementMessage = "Enter element: ";
        System.out.print(sizeMessage);
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int[] intArr = new int[sizeOfArray];
        for (int i = 0; i < intArr.length; i++) {
            System.out.printf(elementMessage);
            intArr[i] = scanner.nextInt();
        }
        scanner.close();
        return intArr;

    }
}
