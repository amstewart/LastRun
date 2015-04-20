package model.skill;

import model.Vector2;
import model.entity.npc.NPC;
import model.map.GameMap;
import model.movement.NPCMovement;

/**
 * Created by TubbyLumpkins on 4/19/15.
 */

public class MoveSouthSkill extends ExternalSkill {
    public MoveSouthSkill(NPC npc) {
        super("Move South", 1, null, 0, false);
    }

    public void performSkill(GameMap gm, NPC npc) {
        for (NPCMovement e : gm.getNPCMovements()) {
            if (e.getnpc() == npc) {
                Vector2 dest = gm.getTileToTheSouth(e.getPosition()).getLocation();
                gm.moveNPCTo(dest, npc);
                break;
            }
        }
    }
}

