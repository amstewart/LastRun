package controller.action.stateMachineAction;

import controller.action.Action;
import state.stateMachine.RPGStateMachine;

public class GoToIntroAction extends Action {
    
    @Override
    public void perform() {
       RPGStateMachine.getInstance().changeToIntroState();
    }
}

