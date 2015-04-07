package testing;

/**
 * Created by diacopium on 15/04/04.
 */
public class ModelTest extends Test {

    public void run() throws NoSuchMethodException {
        report(ModelTest.class.getDeclaredMethod("ttt"), ttt());
    }

    private boolean ttt () { return true; }
}
