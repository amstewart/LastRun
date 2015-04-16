
package controller2.action.action.stateMachineAction;

import controller2.action.Action2;
import state.stateMachine.RPGStateMachine;

/**
 *
 * @author ChrisMoscoso
 */
public class GoToHUDAction extends Action2{

    @Override
    public void perform() {
        RPGStateMachine.getInstance().changetoHUDState();
    }
    
}
