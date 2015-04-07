package testing;

/**
 * Created by Alex Stewart on 15/04/04.
 */
import main.Util;
import java.util.LinkedList;

public class Tests {

    private static LinkedList<Test> tests = new LinkedList<>();
    private static int c_total = 0;
    private static int c_succ = 0;

    public static void main(String[] args) {
        Util.setDbgLevel(1);
        runAll();
    }

    public static void runAll() {
        int c_suites = 0;

        // Add tests here:
        tests.push(new ModelTest());

        Util.dbgOut("Running All (" + tests.size() + ") Tests...", 1);

        for (Test t : tests) {
            try {
                t.run();
            } catch (Exception e) {
                Util.dbgOut("Malformed test.", 1);
                Util.errOut(e);
            }
        }

        Util.dbgOut("Testing complete...", 1);
        Util.dbgOut("> Ran " + Integer.toString(c_suites) + " test suites.", 1);
        Util.dbgOut("> Successes:\t" + Integer.toString(c_succ), 1);
        Util.dbgOut("> Failures:\t" + Integer.toString(c_total - c_succ), 1);
        Util.dbgOut("> TOTAL:\t\t" + Integer.toString(c_total), 1);

        c_succ = 0;
        c_total = 0;
    }

    public static class Reporter {
        public static void print(String s) {
            Util.dbgOut(s, 1);
        }

        public static void result(boolean res) {
            c_total++;
            if (res) { c_succ++; }
        }
    }
}
