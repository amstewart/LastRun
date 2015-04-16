
package controller2.action.action.stateMachineAction;

import controller2.action.Action2;
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
