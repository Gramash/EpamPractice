package ua.nure.garmash.Practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Part4 {
    private static byte[] hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest;
        digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        if (digest != null) {
            return digest.digest();
        } else {
            return null;
        }
    }

    public static String getHexString(byte[] inputArray) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < inputArray.length; i++) {
            resultString.append(String.format("%02X ", inputArray[i]));
        }
        return resultString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getHexString(hash("password", "SHA-256")));
        getHexString(hash("passwort", "SHA-256"));
    }

}
