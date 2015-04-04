package state.stateMachine;

import java.util.*;

import model.GameBundle;
import state.State;
import view.window.GameWindow;

/**
 * This is our state machine that exists in the business domain.
 */
public class StateMachine {

    protected Map<String, State> states;
    protected Stack<State> stateStack;

    protected GameWindow window;
    protected GameBundle bundle;

    public StateMachine() {

        states = new HashMap<>();
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
        if (!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            // TODO: Come back and integrate time into update
            currentState.update();
        }
    }

    /**
     * PRECONDITIONS: States.size > 0
     */
    public void render() {
        if (!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            currentState.render();
        }
    }

    private void push(String state) {
        State newState = states.get(state);
        stateStack.push(newState);
        System.out.println("State pushed: " + newState);

    }

    /**
     * Go back a state by removing the current state from the stack
     */
    public void pop() {
        System.out.println("State popped: " + stateStack.peek());
        stateStack.pop();
        window.displayState(stateStack.peek().getViewport());
        
    }

    /**
     * Change to the new state by pushing it to the stack
     * @param stateName
     */
    public void changeToState(String stateName, GameBundle bundle) {
        if (!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            currentState.onExit();
        }

        State nextState = null;
        try {
            nextState = states.get(stateName);
            nextState.onEnter(bundle);
            window.displayState(nextState.getViewport());
            this.push(stateName);
        } catch (NullPointerException e) {
            System.out.println("There is no stack called " + stateName + " currently in the StateMachine");
            e.printStackTrace();
        }

    }
    
}
