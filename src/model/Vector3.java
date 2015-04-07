package model;

/**
 * Created by Alex Stewart on 15/04/04.
 */
public class Vector3 implements Comparable {
    public Integer X;
    public Integer Y;
    public Integer Z;

    public Vector3() {
        this(0, 0, 0);
    }

    public Vector3 (Integer x, Integer y, Integer z) {
        X = x;
        Y = y;
        Z = z;
    }

    public Vector3 (Vector3 parent) {
        X = parent.X;
        Y = parent.Y;
        Z = parent.Z;
    }

    //<editor-fold desc="PUBLIC METHODS" defaultstate="collapsed">
    public void add (Vector3 delta) {
        if (delta == null)
            return;

        X += delta.X;
        Y += delta.Y;
        Z += delta.Z;
    }

    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(a.X + b.X, a.Y + b.Y, a.Z + b.Z);
    }

    public static double angle(Vector3 a, Vector3 b) {
        return Math.acos(dot(a, b) / (a.magnitude() * b.magnitude()));
    }

    public static Vector3 cross(Vector3 a, Vector3 b) {
        Vector3 ret = new Vector3();
        ret.X = a.Y * b.Z - a.Z * b.Y;
        ret.Y = a.Z * b.X - a.X * b.Z;
        ret.Z = a.X * b.Y - a.Y * b.X;
        return ret;
    }

    public static Long dot(Vector3 a, Vector3 b) {
        return new Long(a.X * b.X + a.Y * b.Y + a.Z * b.Z);
    }

    public double magnitude() {
        Double xs = Math.pow(X.doubleValue(), 2);
        Double ys = Math.pow(Y.doubleValue(), 2);
        Double zs = Math.pow(Z.doubleValue(), 2);
        return Math.sqrt(xs + ys + zs);
    }

    public void setValues(Vector3 values) {
        if (values == null)
            return;

        X = values.X;
        Y = values.Y;
        Z = values.Z;
    }

    public static Vector3 subtract(Vector3 a, Vector3 b) {
        return new Vector3(a.X - b.X, a.Y - b.Y, a.Z - b.Z);
    }

    public static Vector3 zero() {
        return new Vector3(0, 0, 0);
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
        double b = ((Vector3)o).magnitude();

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
