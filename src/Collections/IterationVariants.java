package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class IterationVariants {
    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<>();
        col.add(1);	col.add(2);	col.add(7);	col.add(3);

        // (1)
        for (Integer x : col) { // <== iterator
            System.out.print(x + " ");
        }
        System.out.println();

        // (2)
        Iterator<Integer> it = col.iterator();
        while (it.hasNext()) {
            Integer x = it.next();
            System.out.print(x + " ");
        }
        System.out.println();

        // (3)
        for (Object x : col.toArray()) { // <== iterator
            System.out.print(x + " ");
        }
        System.out.println();

        // (4)
        for (Integer x : col.toArray(new Integer[0])) { // <== iterator
            System.out.print(x + " ");
        }
        System.out.println();

        col.forEach(new Consumer<Integer>() {
            public void accept(Integer x) {
                System.out.print(x + " ");
            }
        });
        System.out.println();

        col.forEach(System.out::print);
        System.out.println();

        col.forEach((x) -> System.out.print(x + " "));
    }

}
