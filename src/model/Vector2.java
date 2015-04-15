package model;

/**
 * Created by Alex Stewart on 15/04/04.
 */
public class Vector2 implements Comparable {
    public Integer X;
    public Integer Y;

    public Vector2() {
        this(0, 0);
    }

    public Vector2(Integer x, Integer y) {
        X = x;
        Y = y;
    }

    public Vector2(Vector2 parent) {
        X = parent.X;
        Y = parent.Y;
    }

    public String toString(){
        return "(" + X + "," + Y + ")";
    }

    //<editor-fold desc="PUBLIC METHODS" defaultstate="collapsed">
    public void add (Vector2 delta) {
        if (delta == null)
            return;

        X += delta.X;
        Y += delta.Y;
    }

    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(a.X + b.X, a.Y + b.Y);
    }

    public static double angle(Vector2 a, Vector2 b) {
        return Math.acos(dot(a, b) / (a.magnitude() * b.magnitude()));
    }

    public static Long dot(Vector2 a, Vector2 b) {
        return new Long(a.X * b.X + a.Y * b.Y);
    }

    public double magnitude() {
        Double xs = Math.pow(X.doubleValue(), 2);
        Double ys = Math.pow(Y.doubleValue(), 2);
        return Math.sqrt(xs + ys);
    }

    public void setValues(Vector2 values) {
        if (values == null)
            return;

        X = values.X;
        Y = values.Y;
    }

    public static Vector2 subtract(Vector2 a, Vector2 b) {
        return new Vector2(a.X - b.X, a.Y - b.Y);
    }

    public static Vector2 zero() {
        return new Vector2(0, 0);
    }
    //</editor-fold>

    // <editor-fold desc="INTERFACE IMPLEMENTATIONS" defaultstate="collapsed">
    /* COMPARABLE */
    // Floating point precision to use when comparing vectors
    private static int PREC = 4;

    /**
     * Compares the magnitudes of this Vector2 object to a provided object and
     * returns the result.
     *
     * @param o The Vector2 object to compare to
     * @return <p>-1: this.MAG < o.MAG</p>
     * <p>0: this.MAG == o.MAG</p>
     * <p>1: this.MAG > o.MAG</p>
     */
    @Override
    public int compareTo(Object o) {
        double a = this.magnitude();
        double b = ((Vector2)o).magnitude();

        // round the difference to PREC number of decimal places
        a = Math.round(((a - b) * (10 * PREC)) / (10 * PREC));
        if (a < 0)
            return -1;
        else if (a == 0)
            return 0;
        else
            return 1;
    }
    // </editor-fold>
}
