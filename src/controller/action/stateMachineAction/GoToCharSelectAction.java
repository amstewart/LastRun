
package controller.action.stateMachineAction;

import controller.action.Action;
import state.stateMachine.RPGStateMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ChrisMoscoso
 */
public class GoToCharSelectAction extends Action implements ActionListener{

    @Override
    public void perform() {
        RPGStateMachine.getInstance().changeToCharSelectState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        perform();
    }
}
