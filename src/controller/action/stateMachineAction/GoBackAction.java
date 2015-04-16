
package controller.action.stateMachineAction;

import controller.action.Action;
import state.stateMachine.RPGStateMachine;


/**
 *
 * @author ChrisMoscoso
 */
public class GoBackAction extends Action{

    public GoBackAction() {
        super();
    }
    @Override
    public void perform() {
        RPGStateMachine.getInstance().pop();
    }
    
}
