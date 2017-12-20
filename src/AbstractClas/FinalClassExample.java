package AbstractClas;

public class FinalClassExample {
    public final void finalMethod(int a, int b) {
    }
    public void huj (){};
}

class NonFinalMethod extends FinalClassExample {
    @Override
    public void huj() {
        super.huj();
    }

}

