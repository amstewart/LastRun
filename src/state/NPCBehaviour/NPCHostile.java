package state.NPCBehaviour;

import model.Vector2;
import model.map.GameMap;
import model.observer.MapObserver;
import model.skill.Skill;
import state.stateMachine.NPCBehaviourMachine;

import java.util.ArrayList;

/**
 * Created by TubbyLumpkins on 4/18/15.
 */
public class NPCHostile extends NPCBehaviourMachine implements MapObserver {

    ArrayList<Skill> skill;
    Vector2 target;
    ArrayList<Behaviour> bs;
    boolean targetSpotted = false;
    private int counter;

    public NPCHostile(ArrayList<Skill> s){

        for(Skill skillz: s){
           // bs.add(new MoveUp)
        }

        this.skill = s;

        this.add("death", new Death());
        this.add("flee", new Flee());
        this.add("wander", new Wander());


    }

    //how often should the machine push/pop

    @Override
    public void trigger() {
        affectState();
    }

    private void affectState(){

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
        doBehaviour(); //always called atm
    }

    @Override
    public void receiveMap(GameMap map) {}

    @Override
    public void receiveNonStealthAvatarPosition(Vector2 v) {

    }
}
