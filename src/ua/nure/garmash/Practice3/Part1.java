package ua.nure.garmash.Practice3;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        String INPUT = Util.getInput("part1.txt");
        System.out.println(convert1(INPUT));
        System.out.println(convert2(INPUT));
        System.out.println(convert3(INPUT));
        System.out.println(convert4(INPUT));
    }

    public static String convert1(String input) {
        String regex = "(\\w+)(;\\w+\\s\\w+;)(\\w+\\@\\w+.\\w+)";
        Pattern p = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(input);
        StringBuilder resultString = new StringBuilder();
        while (m.find())
//            System.out.println(m.group(1) + " ==> " + m.group(3));
            resultString.append(m.group(1)).append(" ==> ").append(m.group(3)).append(System.lineSeparator());
        return resultString.toString();
    }

    public static String convert2(String input) {
        String regex = "(\\w+;)(\\w+\\s+\\w+)(\\W)(\\w+\\@\\w+.\\w+)";
        Pattern p = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(input);
        StringBuilder resultString = new StringBuilder();
        while (m.find())
//            System.out.println(m.group(1) + " ==> " + m.group(3));
            resultString.append(m.group(2)).append(" (email: ").append(m.group(4)).append(")").append(System.lineSeparator());
        return resultString.toString();
    }

    public static String convert3(String input) {
        List eMails = new ArrayList();
        String regex = "(\\w+)(.\\w+\\s+\\w+)(.\\w+@)(\\w+.\\w+)";
        Pattern p = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(input);
        StringBuilder resultString = new StringBuilder();
        while (m.find())
            if (!eMails.contains(m.group(4))) {
                eMails.add(m.group(4));
            }
        for (int i = 0; i < eMails.size(); i++) {
            resultString.append(eMails.get(i)).append(" ==> ");
            m = p.matcher(input);
            while (m.find()) {
                if (eMails.get(i).equals(m.group(4))) {
                    resultString.append(m.group(1)).append(" ");
                }
            }
            resultString.append(System.lineSeparator());
        }
//        System.out.println(eMails.toString());
        return resultString.toString();
    }

    public static String convert4(String input) {
        boolean isFirst = true;
        String regex = "[^\\r\\n]+";
        Pattern p = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(input);
        StringBuilder resultString = new StringBuilder();


        while (m.find()) {
            int randomPass = ThreadLocalRandom.current().nextInt(1000, 10000);
            if (isFirst) {
                isFirst = false;
                resultString.append(m.group()).append(";Password");
            } else {
                resultString.append(m.group()).append(";").append(randomPass);
            }
           resultString.append(System.lineSeparator());
        }
        return resultString.toString();
    }
}
