package main;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex Stewart on 15/03/31.
 */
public class Util {
    public static int debugLevel = 0;
    private static SimpleDateFormat errDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");

    public static void dbgOut(String s) {
        if (debugLevel > 0) {
            System.out.println(printTime() + " (DBG|" + Integer.toString(debugLevel) + ") " + s);
        }
    }

    public static void errOut(Exception e) {
        System.err.println(printTime() + " (ERROR) " + e.getMessage());
        e.printStackTrace(System.err);
    }

    public static String printTime() {
        return errDateFormat.format(new Date());
    }

    public static void setDbg(File file) {
        try {
            if (file == null) { throw new Exception("DBGOUT file is null"); }
            file.createNewFile();

            if (!file.canWrite()) { throw new Exception("Cannot write to dbgout file."); }

            setDbg(new PrintStream(file));
        } catch (Exception e) {
            errOut(e);
        }
    }

    public static void setDbg(PrintStream stream) {
        if (stream != null) {
            System.setOut(stream);
        }
    }

    public static void setDbg(String path) {
        try {
            if (path == null) {
                throw new Exception("DBGOUT path is null");
            }
            setDbg(new File(path));
        } catch (Exception e) {
            errOut(e);
        }
    }

    public static void setErr(File file) {
        try {
            if (file == null) { throw new Exception("ERROUT file is null"); }
            file.createNewFile(); // create the file if it does not already exist

            if (!file.canWrite()) { throw new Exception("Cannot write to errout file."); }

            setErr(new PrintStream(file));
        } catch (Exception e) {
            errOut(e);
        }
    }

    public static void setErr(PrintStream stream) {
        if (stream != null) {
            System.setErr(stream);
        }
    }

    public static void setErr(String path) {
        try {
            if (path == null) {
                throw new Exception("ERROUT path is null");
            }
            setErr(new File(path));
        } catch (Exception e) {
            errOut(e);
        }
    }
}
