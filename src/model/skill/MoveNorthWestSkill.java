package model.skill;

import model.Vector2;
import model.entity.npc.NPC;
import model.map.GameMap;
import model.movement.NPCMovement;

/**
 * Created by TubbyLumpkins on 4/19/15.
 */

public class MoveNorthWestSkill extends ExternalSkill {
    public MoveNorthWestSkill(NPC npc) {
        super("Move North West", 1, null, 0, false);
    }

    public void performSkill(GameMap gm, NPC npc) {
        for (NPCMovement e : gm.getNPCMovements()) {
            if (e.getnpc() == npc) {
                Vector2 dest = gm.getTileToTheNorthWest(e.getPosition()).getLocation();
                gm.moveNPCTo(dest, npc);
                break;
            }
        }
    }
}