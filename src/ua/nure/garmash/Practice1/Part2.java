package ua.nure.garmash.Practice1;

public class Part2 {
    public static void main(String[] args) {
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[1]);
        sum2(firstNumber,secondNumber);
    }
    public static void sum2 (int a, int b) {
        System.out.println(a + "+" + b + " equals " + (a+b));
    }
}
