package state.stateMachine;

import java.util.*;
import state.State;
import utility.Util;

public abstract class StateMachine {

    protected HashMap<String, State> states = new HashMap<String, State>();
    protected Stack<State> stateStack = new Stack<State>();
    

    public void add(String stateName, State i) {
        states.put(stateName, i);
    }

    public void update() {
        State currentState = stateStack.peek();
        // TODO: Come back and integrate time into update
        currentState.update();
    }

    public void push(String state) {
        State newState = states.get(state);
        stateStack.push(newState);
        
    }

    public void pop() {
        Util.dbgOut("State popped: " + stateStack.peek(), 1);
        stateStack.peek().onExit();
        stateStack.pop();
    }

    protected void changeToState(String stateName) {
        
         if(!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            currentState.onExit();
        }

        State nextState = states.get(stateName);
        nextState.onEnter();
        push(stateName);
    }
}
