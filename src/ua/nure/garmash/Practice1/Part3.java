package ua.nure.garmash.Practice1;

public class Part3 {
    public static void main(String[] args) {
        int result = 0;
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[1]);
        while (firstNumber != 0 && secondNumber != 0) {

            if (firstNumber > secondNumber) {
                firstNumber = firstNumber % secondNumber;
            } else {
                secondNumber = secondNumber % firstNumber;
            }
            result = (firstNumber + secondNumber);
        }
        System.out.println("biggest common divisor for " + args[0] + " and " + args[1] + " equals " +
                result);
    }
}
