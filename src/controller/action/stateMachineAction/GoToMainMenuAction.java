
package controller.action.stateMachineAction;

import controller.action.Action;
import state.stateMachine.RPGStateMachine;

/**
 *
 * @author ChrisMoscoso
 */
public class GoToMainMenuAction extends Action{

    @Override
    public void perform() {
        RPGStateMachine.getInstance().changeToMenuState();
    }
    
}
