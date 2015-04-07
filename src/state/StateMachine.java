package state;

import java.util.*;

import model.entity.GameBundle;
import view.viewport.Viewport;
import view.window.GameWindow;

public class StateMachine {

    private Map<String, State> states;
    private Stack<State> stateStack;

    private GameWindow window;
    private GameBundle bundle;

    public StateMachine() {
        
        states = new HashMap<String, State>();
        stateStack = new Stack<State>();
        window = new GameWindow();
    }

    /**
     * Adds a state to the state machine.
     *
     * @param stateName
     * @param i
     */
    public void add(String stateName, State i) {
        states.put(stateName, i);
    }

    /**
     * PRECONDITIONS: States.size > 0
     */
    public void update() {
        State currentState = stateStack.peek();
        // TODO: Come back and integrate time into update
        currentState.update();
    }

    /**
     * PRECONDITIONS: States.size > 0
     */
    public void render() {
        if (!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            
            Viewport view = currentState.getViewport();
            window.displayState(currentState.getViewport());
            currentState.render();
        }
    }

    public void push(String state) {
        State newState = states.get(state);
        stateStack.push(newState);
        System.out.println("State pushed: " + newState);

    }

    public State pop() {
        System.out.println("State popped: " + stateStack.peek());
        return stateStack.pop();
    }
    /**
     *
     * @param stateName
     */
    /*
    public void changeToState(String stateName, GameBundle bundle) {
        if(!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            currentState.onExit();
        }

        State nextState = states.get(stateName);
        nextState.onEnter(bundle);
        this.push(stateName);
        
    }
    */
     public void changeToState(String stateName, GameBundle bundle) {
        
         if(!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            currentState.onExit();
        }

        State nextState = states.get(stateName);
        nextState.onEnter(bundle);
        this.push(stateName);
        
    }
/*
    private void setCurrentState(String stateName) {
       
        currentState = states.get(stateName);
        currentState.onEnter();
        window.displayState( currentState.getViewport());
    }
    
    public void setCurrentState(State state){
        
        currentState = state;
        currentState.onEnter();
       
        window.displayState(currentState.getViewport());
    }
*/
}
