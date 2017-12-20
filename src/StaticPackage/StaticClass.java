package StaticPackage;

public class StaticClass {
    public static int staticVar = 1;
    public int var = 2;

    public static void staticMethod() {
//        staticVar = var;

    }

    public void method() {
        staticVar = var;
    }

}
