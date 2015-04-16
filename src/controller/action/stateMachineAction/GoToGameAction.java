
package controller.action.stateMachineAction;

import controller.action.Action2;
import state.stateMachine.RPGStateMachine;

/**
 *
 * @author ChrisMoscoso
 */
public class GoToGameAction extends Action2{

    @Override
    public void perform() {
        RPGStateMachine.getInstance().changeToGameState();
    }
    
}
