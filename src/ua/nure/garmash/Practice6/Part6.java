package ua.nure.garmash.Practice6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Part6 {

    private static final String FREQUENCY_REQUEST = "frequency";
    private static final String LENGTH = "length";
    private static final String DUPLICATES = "duplicates";
    private static final String INPUT = "--input";
    private static final String TASK = "--task";
    private static final String CONSOLE_INPUT = "--input part6.txt --task frequency";

    public static void main(String[] args) throws IOException {
        System.setIn(new
                ByteArrayInputStream(CONSOLE_INPUT.getBytes("cp1251")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] input = s.split(" ");
        input = args;

        String fileName = "";
        String task = "";
        if (input.length != 4) {
            System.out.println("please specify correct query if the form of --input + fileName + --task " +
                    "+ frequency/length/duplicates" +
                    "Your input is ");
        }
        for (int i = 0; i < input.length; i++) {
            if (INPUT.equalsIgnoreCase(input[i]) && i + 1 < input.length && !input[i + 1].equalsIgnoreCase(TASK)) {
                fileName = input[i + 1];
                if ("".equalsIgnoreCase(fileName)) {
                    System.out.println("please specify correct file name");
                    return;
                }
            } else if (TASK.equalsIgnoreCase(input[i]) && i + 1 < input.length && !input[i + 1].equalsIgnoreCase(INPUT)) {
                task = input[i + 1];
                if (!task.equalsIgnoreCase(FREQUENCY_REQUEST) &&
                        !task.equalsIgnoreCase(DUPLICATES) &&
                        !task.equalsIgnoreCase(LENGTH)) {
                    System.out.println("please specify correct task");
                    return;
                }
            }
        }

        String fileInput = ReadFromFile.getInput(fileName);
        String arrOfWords[] = fileInput.split("[\\W\\r\\n]");
        WordContainer wc = new WordContainer();
        for (int i = 0; i < arrOfWords.length; i++) {
            wc.addToWordList(new Word(arrOfWords[i]));
        }

        switch (task) {
            case FREQUENCY_REQUEST:
                wc.mostFrequentWord();
                break;
            case LENGTH:
                wc.findMaxWord();
                break;
            case DUPLICATES:
                System.out.println(wc.getInvertedDuplicates());
                break;
        }
//        wc.findMaxWord();
//        System.out.println();
//        wc.mostFrequentWord();
//        System.out.println();
//        System.out.println(wc.getInvertedDuplicates());
    }

    private static class Word implements Comparable<Word> {
        String content;
        int frequency;
        int length;
        boolean duplicate = false;

        public Word(String s) {
            content = s;
            frequency = 1;
            length = s.length();
        }

        public Word() {
        }

        @Override
        public String toString() {
            return content;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Word word = (Word) obj;

            return content != null ? content.equals(word.content) : word.content == null;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + (content != null ? content.hashCode() : 0);
            result = 31 * result + frequency;
            result = 31 * result + length;
            result = 31 * result + (duplicate ? 0 : 1);
            return result;
        }

        @Override
        public int compareTo(Word o) {
            return content.compareTo(o.content) * -1;
        }
    }

    private static class WordContainer {
        private List<Word> wordList = new ArrayList<>();

        public void addToWordList(Word word) {
            if (wordList.contains(word)) {
                wordList.get(wordList.indexOf(word)).frequency++;
                wordList.get(wordList.indexOf(word)).duplicate = true;
            }
            wordList.add(word);
        }

        @Override
        public String toString() {
            for (Word x : wordList) {
                System.out.print(x + " ");
            }
            System.out.println();
            return "";
        }

        private void findMaxWord() {
            List<String> longestThree = new ArrayList<>();
            while (longestThree.size() < 3) {
                String currentLongest = "";
                for (Word word : wordList) {
                    if (word.length > currentLongest.length() && !longestThree.contains(word.content)) {
                        currentLongest = word.content;
                    }
                }
                longestThree.add(currentLongest);
            }
            for (String s : longestThree) {
                System.out.println(s + " ==> " + s.length());
            }
        }

        private List mostFrequentWord() {
            List<Word> mostFrequentThree = new ArrayList<>();
            while (mostFrequentThree.size() < 3) {
                Word currentMostFrequent = new Word();
                for (Word word : wordList) {
                    if (word.frequency > currentMostFrequent.frequency &&
                            !mostFrequentThree.contains(word) &&
                            !word.content.equals("")) {
                        currentMostFrequent = word;
                    }
                }
                mostFrequentThree.add(currentMostFrequent);
            }
            mostFrequentThree.sort(null);
            for (Word word : mostFrequentThree) {
                System.out.println(word.content + " ==> " + word.frequency);
            }
            return mostFrequentThree;
        }

        private List<Word> getDuplicates() {
            List<Word> threeDuplicates = new ArrayList<>();
            for (Word word : wordList) {
                if (word.duplicate &&
                        !threeDuplicates.contains(word) &&
                        !word.content.equals("")) {
                    threeDuplicates.add(word);
                }
            }
            return threeDuplicates.subList(0, 3);
        }

        private String invertWord(String s) {
            StringBuilder reversedWord = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                reversedWord.append(s.charAt(i));
            }
            return reversedWord.toString().toUpperCase();
        }

        public StringBuilder getInvertedDuplicates() {
            StringBuilder result = new StringBuilder();
            List<Word> invertedDuplicatesList = new ArrayList<>();
            for (Word word : getDuplicates()) {
                result.append(invertWord(word.content)).append(System.lineSeparator());
            }
            return result;
        }
    }
}
