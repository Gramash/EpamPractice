package ua.nure.garmash.Practice6.Part7;

import java.util.Iterator;

public interface RangeIterator extends Iterator<Integer>{
    // returns true if this list iterator has more elements when traversing
    // the list in the reverse direction
    boolean hasPrevious();

    // returns the previous element in the list and moves the cursor
    // position backwards
    Integer previous();

}
