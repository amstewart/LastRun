package state;

import java.util.*;

import view.viewport.Viewport;
import view.window.GameWindow;

public class StateMachine {

    private static HashMap<String, State> states = new HashMap<String, State>();
    private static Stack<State> stateStack = new Stack<State>();
    private static GameWindow window = new GameWindow();

    /*
    public StateMachine() {

        states = new HashMap<String, State>();
        stateStack = new Stack<State>();
        window = new GameWindow();
    }
    */

    public static void add(String stateName, State i) {
        states.put(stateName, i);
    }

    public static void update() {
        State currentState = stateStack.peek();
        // TODO: Come back and integrate time into update
        currentState.update();
    }

    public static void render() {
        if (!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            
            Viewport view = currentState.getViewport();
            window.displayState(currentState.getViewport());
            currentState.render();
        }
    }

    public static void push(String state) {
        State newState = states.get(state);
        stateStack.push(newState);
        System.out.println("State pushed: " + newState);

    }

    public static State pop() {
        System.out.println("State popped: " + stateStack.peek());
        stateStack.peek().onExit();
        return stateStack.pop();
    }

     public static void changeToState(String stateName) {
        
         if(!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            currentState.onExit();
        }

        State nextState = states.get(stateName);
        nextState.onEnter();
        push(stateName);
        
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
