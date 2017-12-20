package ua.nure.garmash.Practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {


    public static void main(String[] args) throws IOException {
        filterString(INPUT);
    }

    public static final String INPUT = "practice4part3.txt";
    public static final String STOP_WORD = "stop";

    public static void filterString(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        String fileSource = ReadFromFile.getInput(fileName);
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile("", Pattern.UNICODE_CHARACTER_CLASS);
        while ((s = reader.readLine()) != null) {
            if (s.equals(STOP_WORD)) {
                break;
            }
            if (s.equals("double")) {
                p = Pattern.compile("(\\d*\\.\\d*)", Pattern.UNICODE_CHARACTER_CLASS);
            }
            if (s.equals("char")) {
                p = Pattern.compile("(\\b\\w\\b)", Pattern.UNICODE_CHARACTER_CLASS);
            }
            if (s.equals("String")) {
                p = Pattern.compile("(\\b[^\\d\\W]{2,}\\b)", Pattern.UNICODE_CHARACTER_CLASS);
            }
            if (s.equals("int")) {
                p = Pattern.compile("(?:\\s)(\\d+)(\\s)", Pattern.UNICODE_CHARACTER_CLASS);
            }
            Matcher m = p.matcher(fileSource);
            while (m.find()) {
                result.append(m.group(1)).append(" ");
            }
            System.out.println(result.toString());
            result.setLength(0);
        }
        System.out.println("You entire life is BDSM, and you've forgotten the Stop-word");
    }

}

