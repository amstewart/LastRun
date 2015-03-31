package model.state;

import java.util.HashMap;
import java.util.Map;
import view.window.GameWindow;

/**
 *
 * @author ChrisMoscoso
 */
public class StateMachine {

    Map<String, iState> states;
    iState currentState;
    GameWindow window;

    public StateMachine() {
        states = new HashMap<>();
        window = new GameWindow();
    }

    /**
     * Adds a state to the state machine.
     *
     * @param stateName
     * @param i
     */
    public void add(String stateName, iState i) {
        states.put(stateName, i);
    }

    /**
     * PRECONDITIONS: States.size > 0
     */
    public void update() {
        currentState.update();
    }

    /**
     * PRECONDITIONS: States.size > 0
     */
    public void render() {
        currentState.render();
    }

    /**
     *
     * @param stateName
     */
    public void change(String stateName) {
        if(currentState != null){
            currentState.onExit();
        }
        setCurrentState(stateName);
    }

    private void setCurrentState(String stateName) {
        currentState = states.get(stateName);
        currentState.onEnter();
        System.out.println("Current state is " + stateName + " " + window.getContentPane());
        window.getContentPane().add(currentState.getViewport());
        window.repaint();
        System.out.println("2Current state is " + stateName);
    }
}
