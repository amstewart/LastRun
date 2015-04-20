package state.NPCBehaviour;

import model.Vector2;
import model.entity.npc.NPC;
import model.map.GameMap;
import model.movement.NPCMovement;
import model.skill.*;

/**
 * Created by TubbyLumpkins on 4/19/15.
 */
public class Follow extends Behaviour {
    Vector2 avatar;
    NPC self;
    NPCMovement npcMovement;
    int counter;
    MoveNorthSkill mu;
    MoveSouthSkill md;
    MoveNorthWestSkill mlu;
    MoveSouthWestSkill mld;
    MoveNorthEastSkill mru;
    MoveSouthEastSkill mrd;


    public Follow(NPC npc, NPCMovement npcmove){
        this.self = npc;
        this.npcMovement = npcmove;
        this.counter = 0;
        mu = new MoveNorthSkill(npc);
        mru = new MoveNorthEastSkill(npc);
        mrd = new MoveSouthEastSkill(npc);
        md = new MoveSouthSkill(npc);
        mld = new MoveSouthWestSkill(npc);
        mlu = new MoveNorthWestSkill(npc);
    }

    @Override
    public void update(GameMap gm) {

        this.avatar = gm.getAvatarMovement().getPosition();
        boolean muu = false;
        boolean mruu = false;
        boolean mrdd = false;
        boolean mdd = false;
        boolean mldd= false;
        boolean mluu= false;

        if(avatar != null) {
            if ((Math.abs(avatar.Y) - Math.abs(npcMovement.getPosition().Y) + (Math.abs(avatar.X) - Math.abs(npcMovement.getPosition().X))) *
                    (Math.abs(avatar.Y) - Math.abs(npcMovement.getPosition().Y) + (Math.abs(avatar.X) - Math.abs(npcMovement.getPosition().X))) != 1) {
                if (avatar.Y <= npcMovement.getPosition().Y) {
                    if (avatar.X > npcMovement.getPosition().X) {
                        mruu = true;
                    }
                    else if (avatar.X == npcMovement.getPosition().X) {
                        //NORth
                        muu = true;
                    }
                    else if (avatar.X < npcMovement.getPosition().X) {
                        //NW
                        mluu = true;
                     }
                 }
                else if (avatar.Y > npcMovement.getPosition().Y) {
                    //avatar is south
                    if (avatar.X > npcMovement.getPosition().X) {
                        //SE
                        mrdd = true;
                    } else if (avatar.X == npcMovement.getPosition().X) {
                        //South
                        mdd = true;
                    } else if (avatar.X < npcMovement.getPosition().X) {
                        //SW
                        mldd = true;
                    }
                }

                if (muu) {
                    mu.performSkill(gm, this.self);
                } else if (mruu) {
                    mru.performSkill(gm, this.self);
                } else if (mrdd) {
                    mrd.performSkill(gm, this.self);
                } else if (mldd) {
                    mld.performSkill(gm, this.self);
                } else if (mluu) {
                    mlu.performSkill(gm, this.self);
                } else if (mdd) {
                    md.performSkill(gm, this.self);
                }
            }
        }
    }

    @Override
    public void onEnter() {

    }

}
