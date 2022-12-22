package lab_06;

public class StringChecker {
    public static void main(String[] args) {
        System.out.println(removeCharacter("36"));
    }

                                /* Lab 6.3 */
    public static String removeCharacter(String string) {
        return string.replaceAll("[^0-9]", "");
    }
    public static boolean checkValidUrl(String url) {
        return url.matches("^https?.+\\.(com|net)");
    }

}
