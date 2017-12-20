package ua.nure.garmash.Practice4;


import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable {
    public static void main(String[] args) {
        Part4 list = new Part4();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    @Override
    public Iterator iterator() {
        return new IterableImpl();
    }

    public static final String INPUT = "Practice4Part4";

    static String fileSource = ReadFromFile.getInput(INPUT);
    static Pattern p = Pattern.compile("[\"']?[\\w][^.?!]+((?![.?!]['\"]?\\s[\"']?[\\w][^.?!]).)+[.?!'\"]+",
            Pattern.UNICODE_CHARACTER_CLASS);
    static Matcher m = p.matcher(fileSource);
    static int index = 0;

    private class IterableImpl implements Iterable, Iterator {

        @Override
        public boolean hasNext() {
            if (m.find(index)) {
                m.reset();
                return true;
            }
            m.reset();
            return false;
        }

        @Override
        public Object next() {
            m.find(index);
            index = m.end();
            return m.group();
        }

        @Override
        public void remove() throws UnsupportedOperationException {

        }

        @Override
        public Iterator iterator() {
            return null;
        }
    }
}
