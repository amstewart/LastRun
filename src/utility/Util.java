package utility;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex Stewart on 15/03/31.
 */
public class Util {
    /* DEBUG LEVELS:
     * 0 : RESERVED - no output
     * 1 : Basic application-level output (application states, et c.)
     * 2 : Sublevel game and application methods
     * 3 : Sublevel key details (those which are infrequent and important)
     * 4 : Method details which are not important except for debugging and are otherwise extraneous
     * 5 : Iterator variables and other such information which is likely to fill up a log file if enabled
    */

    private static int debugLevel = 0;
    private static SimpleDateFormat errDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");

    //<editor-fold desc="ACCESSORS" default-state="collapsed">
    /**
     * Gets the current global debug print level
     * @return The current global debug print level as an int
     */
    public static int getDbgLevel() { return debugLevel; }

    /**
     * Sets the global debug print level to the given value, if the value is >= 0
     * @param value The new value (must be >= 0)
     * @return The resultant value of the global debut print level
     */
    public static int setDbgLevel(int value) {
        if (value >= 0) {
            debugLevel = value;
            Util.dbgOut("Debug level set to " + Integer.toString(debugLevel), 0);
        }
        return debugLevel;
    }
    //</editor-fold>

    //<editor-fold desc="PUBLIC METHODS" default-state="collapsed">
    /**
     * Writes a given string to the standard 'debug' output stream
     * @param s The debug message to output
     * @param mLevel The level of the debug message
     */
    public static void dbgOut(String s, int mLevel) {
        if (debugLevel > 0 && debugLevel >= mLevel) {
            System.out.println(printTime() + " (DBG|" + Integer.toString(mLevel) + ") " + s);
        }
    }

    /**
     * Prints a given exception to the standard error out, along with the print trace of the exception
     * @param e The Exception to print
     */
    public static void errOut(Exception e) {
        System.err.println(printTime() + " (ERROR) " + e.getMessage());
        e.printStackTrace(System.err);
    }

    public static void errOut(Exception e, boolean fatal) {
        errOut(e);
        if (fatal) {
            System.err.println("LAST ERROR WAS FATAL. PROGRAM ENDING.");
            System.exit(1);
        }
    }

    public static void setDbgOut(File file) {
        try {
            if (file == null) { throw new Exception("DBGOUT file is null"); }
            file.createNewFile();

            if (!file.canWrite()) { throw new Exception("Cannot write to dbgout file."); }

            setDbgOut(new PrintStream(file));
        } catch (Exception e) {
            errOut(e);
        }
    }

    public static void setDbgOut(PrintStream stream) {
        if (stream != null) {
            System.setOut(stream);
        }
    }

    public static void setDbgOut(String path) {
        try {
            if (path == null) {
                throw new Exception("DBGOUT path is null");
            }
            setDbgOut(new File(path));
        } catch (Exception e) {
            errOut(e);
        }
    }

    public static void setErrOut(File file) {
        try {
            if (file == null) { throw new Exception("ERROUT file is null"); }
            file.createNewFile(); // create the file if it does not already exist

            if (!file.canWrite()) { throw new Exception("Cannot write to errout file."); }

            setErrOut(new PrintStream(file));
        } catch (Exception e) {
            errOut(e);
        }
    }

    public static void setErrOut(PrintStream stream) {
        if (stream != null) {
            System.setErr(stream);
        }
    }

    public static void setErrOut(String path) {
        try {
            if (path == null) {
                throw new Exception("ERROUT path is null");
            }
            setErrOut(new File(path));
        } catch (Exception e) {
            errOut(e);
        }
    }
    //</editor-fold>

    private static String printTime() {
        return errDateFormat.format(new Date());
    }
}
