package model.movement;

import model.Vector2;
import model.entity.npc.NPC;
import model.map.GameMap;
import utility.Direction;
import utility.Util;

/**
 * Created by TubbyLumpkins on 4/19/15.
 */
public class NPCMovement extends Movement {

        private NPC npc;
        private Vector2 facing_dir;

        public NPCMovement(NPC entity) {
            this(entity, Vector2.zero());
        }

        public NPCMovement(NPC entity, GameMap map, Vector2 starting_position){
            this(entity, starting_position);
            this.setMap(map);
        }

        public NPCMovement(NPC entity, Vector2 starting_position) {
            if (entity == null) {
                Util.errOut(new Exception("EntityMovement association initialized with a null entity."));
            }
            if (starting_position == null) {
                Util.errOut(new Exception("EntityMovement association initialized with a null starting position. Defaulting to ZERO vector."));
                starting_position = Vector2.zero();
            }

            initialize(entity, starting_position, Direction.SOUTH);
        }

        public void changeEntity(NPC new_ent) {
            if (new_ent == null) { Util.errOut(new Exception("EntityMovement set to null entity.")); }
            npc = new_ent;
        }

        public Vector2 getFacingDir() { return facing_dir; }

        public NPC getnpc(){
            return npc;
        }

        private void initialize(NPC ent, Vector2 pos_init, Vector2 facing_dir) {
            this.npc = ent;
            this.changePosition(pos_init);
            this.facing_dir = facing_dir;
        }

        public void reface(Vector2 new_facing) {
            this.facing_dir = new Vector2(new_facing);
           // Util.dbgOut("Entity " + npc.getName() + " facing = " + facing_dir.toString(), 4);
        }

        public void setAsset(String new_asset) {
            npc.setAssetID(new_asset);
        }

}
