package interfaceListener;


public class Concert {

    public static void main(String[] args) {
       SoundPult soundPult = new SoundPult();
       HeadPhones headPhones = new HeadPhones();
       soundPult.setOnSignalListener(headPhones);
       soundPult.playMITOL();

    }

}
