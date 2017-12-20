package ua.nure.garmash.Practice3;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.nure.garmash.Practice4.ReadFromFile.getInput;

/**
 * Created by User on 11/19/2017.
 */
public class Part2 {

    public static void main(String[] args) {

        System.out.println(minMaxFind(INPUT));

    }

    public static final String INPUT = "part2.txt";

    private static String minMaxFind(String fileName) {
        String fileSource = getInput(fileName);
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(fileSource);
        StringBuilder resultString = new StringBuilder();
        List maxString = new ArrayList();
        List minString = new ArrayList();
        m.find();
        int longest = m.group().length();
        int shortest = m.group().length();
        while (m.find()) {
            if (m.group().length() > longest) {
                longest = m.group().length();
                maxString.clear();
                maxString.add(m.group());
            }
            if (m.group().length() == longest && !maxString.contains(m.group())) {
                maxString.add(m.group());
            }
            if (m.group().length() < shortest) {
                shortest = m.group().length();
                minString.clear();
                minString.add(m.group());
            }
            if (m.group().length() == shortest && !minString.contains(m.group())) {
                minString.add(m.group());
            }
        }
        resultString.append("Min: ").append(minString).append(System.lineSeparator()).append("Max: ").append(maxString);
        return resultString.toString();
    }
}
