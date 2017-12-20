package AbstractClas;

import java.util.HashMap;

public abstract class RandomAbstract implements Comparable<RandomAbstract> {
    public static void main(String[] args) {

        RandomAbstract abstractObject = new RandomAbstract() {
            @Override
            public void abstractMethod() {

            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
    public abstract void abstractMethod ();

    @Override
    public int compareTo(RandomAbstract o) {
        return 0;
    }
}


