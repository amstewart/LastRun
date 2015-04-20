package state.NPCBehaviour;

import model.Vector2;
import model.gameTimer.GameTimer;
import model.map.GameMap;
import model.movement.EntityMovement;
import model.movement.NPCMovement;
import model.observer.MapObserver;
import model.skill.ExternalSkill;
import model.skill.Skill;
import state.stateMachine.NPCBehaviourMachine;

import java.util.ArrayList;


public class NPCHostile extends NPCBehaviourMachine implements MapObserver {

    ArrayList<ExternalSkill> skill;
    Vector2 target;
    NPCMovement self;
    ArrayList<Behaviour> bs;
    boolean targetSpotted = false;
    private int counter;

    public NPCHostile(NPCMovement e, GameMap gm){
        this.self = e;
        this.map = gm;
        this.gt = new GameTimer(30, true);
        gt.addGameTimerListener(this);
        //this.skill = s;

        Wander w = new Wander(e.getnpc());
        this.add("wander", w);
        this.changeToState("wander");
        //this.add("flee", w);
        //this.changeToState("flee");

    }

    //how often should the machine push/pop

    @Override
    public void trigger() {
        affectState();
    }

    private void affectState(){
        /*
        if(counter == 3){
            this.counter = 0;
        }
        else {
            counter++;
        }


        if(targetSpotted){

        }
        else{
            if(counter % 3 == 1){
                this.changeToState("observe");

            }
            else if(counter % 3 == 2 ){
                this.pop();
            }
            else{

            }
        }
        */
        doBehaviour(); //always called atm
        //2
    }

    @Override
    public void receiveMap(GameMap map) {}

    @Override
    public void receiveNonStealthAvatarPosition(Vector2 v) {

    }
}
