package ua.nure.garmash.Practice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) throws IOException {
        createFile(toString(createRandomArr(arrOfRandoms)), "arrOfInts.txt");
        String input = ReadFromFile.getInput("arrOfInts.txt");
        System.out.println("Input ==>" + "\t" + input);
        createFile(toString(sortArr(convert(input))), "sorted_Ints");
        String output = ua.nure.garmash.Practice4.ReadFromFile.getInput("sorted_Ints");
        System.out.println("Output ==>" + "\t" + output);

    }


    private static int[] arrOfRandoms = new int[10];

    public static void createFile(String str, String fileName) throws IOException {
        List<String> lines = Arrays.asList(str);
        Path file = Paths.get(fileName);
        Files.write(file, lines);
    }

    public static int[] createRandomArr(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50) + 1;
        }
        return arr;
    }

    public static int[] convert(String input) {
        int[] arrFromFile = new int[10];
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(input);
        int i = 0;
        while (m.find()) {
            arrFromFile[i++] = Integer.valueOf(m.group(0));

        }
        return arrFromFile;
    }


    public static int[] sortArr(int[] unsortedArr) {
        int length = unsortedArr.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (unsortedArr[j - 1] > unsortedArr[j]) {
                    temp = unsortedArr[j - 1];
                    unsortedArr[j - 1] = unsortedArr[j];
                    unsortedArr[j] = temp;
                }
            }
        }
        return unsortedArr;
    }


    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        return sb.toString();
    }
}
