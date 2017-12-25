package ua.nure.garmash.Practice6;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Part1 {
    public static final String INPUT = "asdf asd asd asdf asdf 43 43 asdasd 43 43 434 stop";

    public static void main(String[] args) throws IOException {
        WordContainer wc = new WordContainer();
        System.setIn(new
                ByteArrayInputStream(INPUT.getBytes("cp1251")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String srtArr[] = s.split(" ");
        int i = 0;
        while (!"stop".equals(srtArr[i])) {
            wc.add(new Word(srtArr[i]));
            i++;
        }
        wc.sort();
        wc.toString();
    }

    public static class Word implements Comparable<Word> {

        private int frequency;
        private String content;

        public Word(String s) {
            content = s;
        }

        @Override
        public String toString() {
            return content + " : " + frequency;
        }

        public String getContent() {
            return content;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public int getFrequency() {
            return frequency;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            return content != null ? content.equals(word.content) : word.content == null;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + (content != null ? content.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(Word o) {
            if (this.frequency == o.frequency) {
                return this.content.compareTo(o.getContent());
            } else if (this.frequency < o.frequency) {
                return 1;
            } else return -1;
        }
    }

    public static class WordContainer {

        public static List<Word> wc = new ArrayList<>();

        public boolean add(Word word) {
            int temp;
            if (wc.contains(word)) {
                temp = wc.indexOf(word);
                wc.get(temp).setFrequency(wc.get(temp).getFrequency() + 1);
            } else {
                wc.add(word);
                word.setFrequency(1);
            }
            return false;
        }

        @Override
        public String toString() {
            for (Word x : wc) {
                System.out.println(x + " ");
            }
            System.out.println();
            return null;
        }

        public void sort() {
            wc.sort(Word::compareTo);
        }

    }

    public static class WordComparator implements Comparator<Word> {
        @Override
        public int compare(Word o1, Word o2) {
            return o1.getContent().compareTo(o2.getContent());
        }
    }

    public static class WordQuantityComparator implements Comparator<Word> {
        @Override
        public int compare(Word o1, Word o2) {
            if (o1.getFrequency() > o2.getFrequency()) {
                return 1;
            } else if (o1.getFrequency() < o2.getFrequency()) {
                return -1;
            } else {
                return 0;
            }
        }
    }


}
