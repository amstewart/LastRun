package state.NPCBehaviour;

import model.Vector2;
import model.gameTimer.GameTimer;
import model.map.GameMap;
import model.movement.NPCMovement;
import model.observer.MapObserver;
import model.skill.ExternalSkill;
import state.stateMachine.NPCBehaviourMachine;

import java.util.ArrayList;

/**
 * Created by TubbyLumpkins on 4/19/15.
 */
public class PetBehaviour extends NPCBehaviourMachine implements MapObserver {

    ArrayList<ExternalSkill> skill;
    Vector2 target;
    NPCMovement self;
    ArrayList<Behaviour> bs;
    boolean targetSpotted = false;
    private int counter;

    public PetBehaviour(NPCMovement p, GameMap gm){
        this.self = p;
        this.map = gm;
        this.gt = new GameTimer(20, true);
        gt.addGameTimerListener(this);
        //this.skill = s;


        this.add("follow", new Follow(p.getnpc(), self));
        this.changeToState("follow");
    }

    @Override
    public void trigger() {
        affectState();
    }

    private void affectState(){
        doBehaviour();
    }

    @Override
    public void receiveMap(GameMap map) {
    }

    @Override
    public void receiveNonStealthAvatarPosition(Vector2 v) {

    }
}
