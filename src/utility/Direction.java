package utility;

import model.Vector2;

public class Direction {
    public static final Vector2 DELTA_ODD = new Vector2(0, -1);

    public static final Vector2 NORTH =     new Vector2(0,-1);
    public static final Vector2 NORTHEAST = new Vector2(1,0);
    public static final Vector2 NORTHWEST = new Vector2(-1,0);
    public static final Vector2 SOUTH =     new Vector2(0,1);
    public static final Vector2 SOUTHEAST = new Vector2(1,1);
    public static final Vector2 SOUTHWEST = new Vector2(-1,1);

    // TODO FIX - NOT CORRECT
    public static Vector2 getDirection(Vector2 source, Vector2 target) {
        Vector2 ret;
        Vector2 delta = Vector2.subtract(target, source);
        double ang = Vector2.angle(delta, Vector2.zero());
        if (ang < (-Math.PI / 3)) {
            if (delta.X < 0)
                ret = Direction.NORTH;
            else
                ret = Direction.SOUTH;
        } else if (ang < 0) {
            if (delta.X < 0)
                ret = Direction.NORTHWEST;
            else
                ret = Direction.SOUTHEAST;
        } else if (ang < (Math.PI / 3)) {
            if (delta.X < 0)
                ret = Direction.SOUTHWEST;
            else
                ret = Direction.NORTHEAST;
        } else {
            if (delta.X < 0)
                ret = Direction.SOUTH;
            else
                ret = Direction.NORTH;
        }

        return ret;
    }
}
