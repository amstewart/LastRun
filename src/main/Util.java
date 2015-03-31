package main;

import java.io.File;
import java.io.PrintStream;

/**
 * Created by Alex Stewart on 15/03/31.
 */
public class Util {
    public static int debugLevel = 0;


    public static void errOut(Exception e) {
        System.err.println(printTime + " (ERROR) " + e.getMessage());
        e.printStackTrace(System.err);
    }

    public static String printTime() {
        return ""; //TODO IMPLEMENT
    }

    public static void setErr(File file) {
        try {
            if (file == null) { throw new Exception("ERROUT file is null"); }
            file.createNewFile(); // create the file if it does not already exist

            if (!file.canWrite()) { throw new Exception("Cannot write to file."); }

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
