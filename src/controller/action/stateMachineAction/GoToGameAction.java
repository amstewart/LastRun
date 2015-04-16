
package controller.action.stateMachineAction;

import controller.action.Action;
import state.stateMachine.RPGStateMachine;

/**
 *
 * @author ChrisMoscoso
 */
public class GoToGameAction extends Action{

    @Override
    public void perform() {
        RPGStateMachine.getInstance().changeToGameState();
    }
    
}
