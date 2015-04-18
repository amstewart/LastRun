package controller.action.charSelectAction;

import controller.action.Action;
import state.stateMachine.RPGStateMachine;

public class GoToIntroAction extends Action {


    public GoToIntroAction() {
        
    }
    
    @Override
    public void perform() {
       RPGStateMachine.getInstance().changeToIntroState();
    }
}

