package lab_06;

import helper.Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChecker {
    public static void main(String[] args) {
        calculateTimeFromString("2 hrs and 5min");
    }
                                    /* 6.1 */
    public static int calculateTimeFromString(String text) {
//        find hours and minute string from text
        Pattern hoursPattern = Pattern.compile("(\\d)+\\s?hrs");
        Matcher hoursMatcher = hoursPattern.matcher(text);
        Pattern minPattern = Pattern.compile("(\\d+)\\s?min");
        Matcher minMatcher = minPattern.matcher(text);
//        check if it finds valid pattern
        if(hoursMatcher.find() && minMatcher.find()){
//            divide number from hour/min string
            int numberOfHours = Integer.parseInt(hoursMatcher.group(1));
            int numberOfMinutes = Integer.parseInt(minMatcher.group(1));
            int totalMin = numberOfHours*60 + numberOfMinutes;
            System.out.println("Total min is: " + totalMin);
            return totalMin;
        } else {
            System.out.println("No information");
            return -1;
        }
    }

                                    /* 6.2 */
    public static boolean checkUserPassword(String password) {
        int attemptNumber = 3;
        do {
            String userPasswordInput = Input.getStringInputValue("Enter your password: ");
            if (userPasswordInput.equals(password)) {
                System.out.println("Redirecting to index page....");
                return true;
            } else {
                System.out.println("Incorrect password. Please check your password. ");
                attemptNumber--;
            }
        } while (attemptNumber > 0);
        System.out.println("Unfortunately, you can't process further.");
        return false;
    }
                                /* Lab 6.3 */
    public static String removeCharacter(String string) {
        return string.replaceAll("[^0-9]", "");
    }

                                /* Lab 6.4*/
    public static boolean checkValidUrl(String url) {
        return url.matches("^https?.+\\.(com|net)");
    }

}
