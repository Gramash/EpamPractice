package interfaceListener;

public class RecordingDevice implements OnSignalListener {

    @Override
    public int onClick() {
        System.out.println("RecordingDevice has been used");
        return 43;
    }
}
