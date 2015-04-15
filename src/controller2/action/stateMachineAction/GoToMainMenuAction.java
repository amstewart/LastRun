
package controller2.action.stateMachineAction;

import controller2.action.Action2;
import state.stateMachine.RPGStateMachine;

/**
 *
 * @author ChrisMoscoso
 */
public class GoToMainMenuAction extends Action2{

    @Override
    public void perform() {
        RPGStateMachine.getInstance().changeToMenuState();
    }
    
}
