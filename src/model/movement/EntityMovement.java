package model.movement;

import model.Vector3;
import model.entity.Entity;
import utility.Util;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class EntityMovement extends Movement {

    private Entity entity;
    private Vector3 facing_dir;

    public EntityMovement(Entity entity) {
        if (entity == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null entity."));
        }

        initialize(entity, Vector3.zero(), Vector3.zero());
    }

    public EntityMovement(Entity entity, Vector3 starting_position) {
        if (entity == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null entity."));
        }
        if (starting_position == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null starting position. Defaulting to ZERO vector."));
            starting_position = Vector3.zero();
        }

        initialize(entity, starting_position, Vector3.zero());
    }

    public void changeEntity(Entity new_ent) {
        if (new_ent == null) { Util.errOut(new Exception("EntityMovement set to null entity.")); }
        entity = new_ent;
    }

    public Vector3 getFacingDir() { return facing_dir; }

    private void initialize(Entity ent, Vector3 pos_init, Vector3 facing_dir) {
        this.entity = ent;
        this.changePosition(pos_init);
        this.facing_dir = facing_dir;
    }
    
    public Entity getEntity(){
        return entity;
    }
}
