package StaticPackage;

import java.util.*;

//@SuppressWarnings("ALL")
public class SeperateClass {
    public static void main(String[] args) {
        StaticClass staticRef = new StaticClass();
        StaticClass staticRef2 = new StaticClass();
        staticRef.var = 1;
        staticRef2.var = 2;
        System.out.println(staticRef.var + " " + StaticClass.staticVar);
        System.out.println(staticRef2.var + " " + StaticClass.staticVar);
        staticRef.var = 3;
        staticRef2.var = 4;

        StaticClass.staticVar = 5;
        StaticClass.staticVar = 6;
        StaticClass.staticVar = 7;

        staticRef.method();
        StaticClass.staticMethod();


        System.out.println(staticRef.var + " " + StaticClass.staticVar);
        System.out.println(staticRef2.var + " " + StaticClass.staticVar);


    }
}
