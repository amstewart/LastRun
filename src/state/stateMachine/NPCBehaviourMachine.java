package state.stateMachine;

import model.Vector2;
import model.gameTimer.GameTimer;
import model.gameTimer.GameTimerListener;
import model.map.GameMap;
import state.NPCBehaviour.Behaviour;
import utility.Util;

import java.util.HashMap;
import java.util.Stack;


public abstract class NPCBehaviourMachine implements GameTimerListener {

    protected HashMap<String, Behaviour> behaviour = new HashMap<String, Behaviour>();
    protected Stack<Behaviour> behaveStack = new Stack<Behaviour>();
    protected GameMap map;
    protected GameTimer gt;


    public void add(String stateName, Behaviour i) {
        behaviour.put(stateName, i);
    }


    public void push(String state) {
        Behaviour newBehaviour = behaviour.get(state);
        behaveStack.push(newBehaviour);

    }

    public void pop() {
        Util.dbgOut("State popped: " + behaveStack.peek(), 1);
        behaveStack.pop();
    }

    protected void doBehaviour(){

        behaveStack.peek().update(map);
        System.out.println(behaveStack.peek().toString());
    }

    protected void changeToState(String behaviourName) {

        if(!behaveStack.isEmpty()) {
            Behaviour currentBehaviour = behaveStack.peek();
        }

        Behaviour nextBehaviour = behaviour.get(behaviourName);
        nextBehaviour.onEnter();
        push(behaviourName);
        //gt.addGameTimerListener(this);
    }

    @Override
    public abstract void trigger();
}
