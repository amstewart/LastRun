
package controller.action.stateMachineAction;

import controller.action.Action2;
import state.stateMachine.RPGStateMachine;


/**
 *
 * @author ChrisMoscoso
 */
public class GoBackAction extends Action2{

    public GoBackAction() {
        super();
    }
    @Override
    public void perform() {
        RPGStateMachine.getInstance().pop();
    }
    
}
