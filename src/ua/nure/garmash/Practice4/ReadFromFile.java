package ua.nure.garmash.Practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by User on 11/21/2017.
 */
public class ReadFromFile {
    public static void main(String[] args) {
       String input = getInput("practice4part1");
        System.out.println(input);
    }
    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
}
