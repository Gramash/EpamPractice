package interfaceListener;

public class SoundPult {

    private OnSignalListener onSignalListener;

    public void setOnSignalListener(OnSignalListener onSignalListener) {
        this.onSignalListener = onSignalListener;
    }

    public void playMITOL() {
        if (onSignalListener != null) {
            int keyCode = onSignalListener.onClick();
            System.out.println("keyCode = " + keyCode);
        } else {
            System.out.println("We dont have click listener");
        }
    }
}
