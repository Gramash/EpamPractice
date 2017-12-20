package ua.nure.garmash.Practice1;

public class Part5 {
    static String letters = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        System.out.println(chars2digits("AAZ"));
        System.out.println(digits2String(chars2digits("AAB")));
        prevNext("AAB");

    }

    public static int chars2digits(String letterValue) {
        int result = 0;
        int arrayEnd = letterValue.length() - 1;
        for (int i = arrayEnd; i >= 0; i--) {
            result += ((int) letterValue.charAt(i) - 'A' + 1) + (Math.pow(26, arrayEnd - i) - 1);
        }
        return result;
    }

    public static String digits2String(int number) {
        String result = "";
        number = number - 1;
        while (number >= 0) {
            int reminder = number % 26;
            result = letters.charAt(reminder) + result;
            number = (number / 26) - 1;
        }
        return result;
    }

    public static void prevNext(String value) {
        System.out.println("previous to " + value + " is " + digits2String(chars2digits(value) - 1));
        System.out.println("next to " + value + " is " + digits2String(chars2digits(value) + 1));
    }
}
