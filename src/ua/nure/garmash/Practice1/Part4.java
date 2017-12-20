package ua.nure.garmash.Practice1;

public class Part4 {
    public static void main(String[] args) {
        int givenNumber = Integer.parseInt(args[0]);
        int result = 0;
        while (givenNumber > 0) {
            result = result + givenNumber % 10;
            givenNumber = givenNumber / 10;
        }
        System.out.println("The sum of all numbers in " + args[0] + " equals " + result);
    }
}
