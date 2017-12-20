package ua.nure.garmash.Practice4;

import ua.nure.garmash.Practice3.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {

        System.out.println(convert(INPUT));

    }
    public static final String INPUT = "part1";

    public static String convert (String fileName) {
        String fileSource = Util.getInput(fileName);
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile("(\\w*)([\\s\\S])", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(fileSource);
        while (m.find()) {
            if (m.group(1).length()>3) {
                result.append(m.group(0).toUpperCase());
            } else {
                result.append(m.group(0));
            }
        }
        return result.toString();
    }
}
