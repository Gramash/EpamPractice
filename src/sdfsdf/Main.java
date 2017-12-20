package sdfsdf;

public class Main {
    public static void main(String[] args) {
        IInterface[] arr = {new B(), new C()};

        for (int i = 0; i < arr.length; i++) {
            arr[i].interfaceFoo();
        }

    }
}
