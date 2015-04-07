package testing;

import java.lang.reflect.Method;

/**
 * Created by Alex Stewart on 15/04/04.
 */
public abstract class Test {

    public abstract void run() throws NoSuchMethodException;

    public void report(Method method, boolean result) {
        Tests.Reporter.print("TEST: " + method.getName() + " = " + Boolean.toString(result));
        Tests.Reporter.result(result);
    }
}
