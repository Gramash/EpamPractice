package interfaceListener;

public class HeadPhones implements OnSignalListener {
    @Override
    public int onClick() {
        System.out.println("Make KOZA");
        return 42;
    }
}
