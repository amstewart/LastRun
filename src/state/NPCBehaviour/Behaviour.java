package state.NPCBehaviour;

import model.map.GameMap;

/**
 * Created by TubbyLumpkins on 4/18/15.
 */
public abstract class Behaviour {

    public abstract void update(GameMap gm);

    public abstract void onEnter();
}
