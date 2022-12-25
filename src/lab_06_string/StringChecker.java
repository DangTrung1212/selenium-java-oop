package lab_06_string;

import helper.Input;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChecker {

    public static void main(String[] args) {
        checkValidUrl(Input.getStringInputValue("Enter your string: "));
    }
                                    /* 6.1 */
    public static int calculateTimeFromString(String text) {
//        find hours and minute string from text
        Pattern hoursPattern = Pattern.compile("(\\d)+\\s?(hrs|hours)");
        Matcher hoursMatcher = hoursPattern.matcher(text);
        Pattern minPattern = Pattern.compile("(\\d+)\\s?(min|minutes)");
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
        List<Character> arrayOfNumbers = new ArrayList<>();
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                arrayOfNumbers.add(c);
            }
        }
        return arrayOfNumbers.toString();
    }

                                /* Lab 6.4*/
//    Group start at group 1
    public static boolean checkValidUrl(String url) {
        Pattern pattern = Pattern.compile("(^https?)://(.+)\\.(com|net)");
        Matcher matcher = pattern.matcher(url);
        boolean match = matcher.find();
        if (match) {
            System.out.println("Protocol is: " + matcher.group(1));
            System.out.println("Domain is: " + matcher.group(2));
            System.out.println("Extension is: " + matcher.group(3));
            return true;
        } else {
            System.out.println("Not Valid url");
            return false;
        }
    }

}
