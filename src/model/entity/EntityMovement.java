package model.entity;

import model.Vector3;
import model.map.GameMap;
import utility.Util;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class EntityMovement {
    private Vector3 entity_pos;
    private Vector3 facing_dir;
    private GameMap map;

    public Vector3 getFacingDir() { return facing_dir; }

    public EntityMovement(GameMap gameMap) {
        if (gameMap == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null GameMap."));
        }

        initialize(gameMap, Vector3.zero(), Vector3.zero());
    }

    public EntityMovement(GameMap gameMap, Vector3 starting_position) {
        if (gameMap == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null GameMap."));
        }
        if (starting_position == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null starting position. Defaulting to ZERO vector."));
            starting_position = Vector3.zero();
        }

        initialize(gameMap, starting_position, Vector3.zero());
    }

    private void initialize(GameMap map, Vector3 spos, Vector3 facing_dir) {
        this.map = map;
        this.entity_pos = spos;
        this.facing_dir = facing_dir;
    }

    public void move(Vector3 new_position) {
        //TODO IMPLEMENT
    }
}
