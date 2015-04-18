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
}
