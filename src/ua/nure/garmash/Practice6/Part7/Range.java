package ua.nure.garmash.Practice6.Part7;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private Integer initialArray[];

    public static void main(String[] args) {
        Range range = new Range(3, 10);
        for (Integer el : range) {
            System.out.printf("%d ", el);
        }
        System.out.println();
        range = new Range(3, 10, true);
        for (Integer el : range) {
            System.out.printf("%d ", el);
        }
        System.out.println();

    }

    public Range(int start, int end) {
        this(start, end, false);
    }

    public Range(int start, int end, boolean reverse) {
        initialArray = new Integer[end - start + 1];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = reverse ? end-- : start++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListRangeIteratorImpl();
    }

    private class RangeIteratorImpl implements Iterator<Integer> {
        int pointer = 0;
        boolean nextUsed = false;
        boolean removeUsed = false;

        // returns true if the iteration has more elements
        @Override
        public boolean hasNext() {
            return initialArray.length > pointer;
        }

        // returns the next element in the iteration
        @Override
        public Integer next() {
            nextUsed = true;
            removeUsed = false;
            new ListRangeIteratorImpl().setPrevUsed(false);

            return initialArray[pointer++];
        }

    }

    private class ListRangeIteratorImpl extends RangeIteratorImpl implements RangeIterator {
        boolean prevUsed = false;

        void setPrevUsed(boolean a) {
            prevUsed = a;
        }

        @Override
        public boolean hasPrevious() {
            return pointer > 0;
        }

        @Override
        public Integer previous() { // 1 2 3 (3) 4
            nextUsed = false;
            return initialArray[--pointer];
        }

    }
//    public String toString() {
//        System.out.print("[");
//        for (int i = 0; i < initialArray.length; i++) {
//            System.out.print(initialArray[i] + (i == initialArray.length - 1 ? "" : ", "));
//        }
//        System.out.println("]");
//
//        return "";
//    }

}
