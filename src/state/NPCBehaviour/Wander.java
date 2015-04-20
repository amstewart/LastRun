package state.NPCBehaviour;

import model.Vector2;
import model.entity.npc.NPC;
import model.map.GameMap;
import model.skill.*;

import java.util.ArrayList;

/**
 * Created by TubbyLumpkins on 4/18/15.
 */
public class Wander extends Behaviour {

    NPC self;
    int counter;
    MoveNorthSkill mu;
    MoveSouthSkill md;
    MoveNorthWestSkill mlu;
    MoveSouthWestSkill mld;
    MoveNorthEastSkill mru;
    MoveSouthEastSkill mrd;

    public Wander(NPC npc){
        this.self = npc;
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
        counter++;

        if(counter %6 == 1){
            mu.performSkill(gm, this.self);
        }
        else if(counter %6 == 2)mld.performSkill(gm, this.self);
        else if(counter %6 == 3)mru.performSkill(gm, this.self);
        else if(counter %6 == 4)mrd.performSkill(gm, this.self);
        else if(counter %6 == 5)mld.performSkill(gm, this.self);
        else if(counter %6 == 0)md.performSkill(gm, this.self);
        else counter = 0;


    }

    @Override
    public void onEnter() {

    }
}
