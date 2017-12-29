package ua.nure.garmash.Practice6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
    private static ArrayList arrList = new ArrayList();
    private static LinkedList linkList = new LinkedList();
    private final static int SPACING = 4;
    private final static int CAPACITY = 90_000;

    public static void main(String[] args) {
        ListForIterator listForIterator = new ListForIterator();
        listForIterator.fillList(linkList, CAPACITY);
        listForIterator.fillList(arrList, CAPACITY);
        listForIterator.removeButOne(SPACING, linkList);
        listForIterator.removeButOne(SPACING, arrList);
        listForIterator.fillList(linkList, CAPACITY);
        listForIterator.fillList(arrList, CAPACITY);
        ListIterator.removeButOneIterator(linkList, SPACING);
        ListIterator.removeButOneIterator(arrList, SPACING);


    }

    private static class ListForIterator {

        public void fillList(List<Integer> list, int capacity) {
            for (int i = 0; i < capacity; i++) {
                list.add(1);
            }
        }


        public void removeButOne(int spacing, List list) {
            long startTime = System.currentTimeMillis();
            while (list.size() >= 4) {
                for (int i = 0; i < list.size(); i = i + spacing) {
                    list.remove(i);
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println(list.getClass().getSimpleName() + " time spent by Index: " + (endTime - startTime));
        }
    }

    public static class ListIterator {

        public static void removeButOneIterator(List list, int spacing) { // 1 2 3 4 5 6 7 8 9

            long startTime = System.currentTimeMillis();
            Iterator listIt;
            while (list.size() > 1) {
                listIt = list.iterator();
                if (list.size() > spacing) {
                    for (int i = 0; i < spacing; i++) {
                        listIt.next();
                    }
                    if (!listIt.hasNext()) return;
                    listIt.remove();
                } else {
                    listIt.next();
                    listIt.remove();
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println(list.getClass().getSimpleName() + " time spent with Iterator: " + (endTime - startTime));
        }
    }
}

