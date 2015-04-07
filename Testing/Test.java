import java.lang.reflect.Method;

/**
 * Created by Alex Stewart on 15/04/04.
 */
public abstract class Test {

    private Tests.Reporter reporter = null;

    public abstract void Run();

    public void linkReporter(Tests.Reporter rep) {
        reporter = rep;
    }

    public void report(Method method, boolean result) {
        reporter.print("TEST: " + method.getName() + " = " + Boolean.toString(result));
    }
}
