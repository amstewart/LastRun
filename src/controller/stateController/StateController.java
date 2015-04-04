package controller.stateController;

import model.GameBundle;
import state.stateMachine.RPGStateMachine;

/*
 * Abstract controller because all controllers work
 * with the same state machine and game bundle
 */

public class StateController {
    
    private GameBundle bundle;
    private RPGStateMachine stateMachine;
    
    public StateController(GameBundle bundle, RPGStateMachine stateMachine){
        this.stateMachine = stateMachine;
        this.bundle = bundle;
    }

    public void setBundle(GameBundle bundle) {
        this.bundle = bundle;
    }

    protected GameBundle getBundle() { return bundle; }

    protected RPGStateMachine getStateMachine() { return stateMachine; }

    public void exitGame() {
        System.exit(0);
    }

    public void startNewGame() {
        stateMachine.changeToCharSelect(bundle);
    }

    public void goToMainMenu() {
        stateMachine.changeToMainMenu(bundle);
    }

    public void goBack() {
        stateMachine.pop();
    }
}
