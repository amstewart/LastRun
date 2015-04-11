package model.action;

import state.stateMachine.StateMachine;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by TubbyLumpkins on 4/4/15.
 */
public abstract class Action {


    public abstract void perform();
    public abstract void setActionListener(ActionListener al);
    public abstract void setKeyListener(KeyListener kl);
    public abstract ActionListener getActionListener();
    public abstract KeyListener getKeyListener();

    private StateMachine sm = new StateMachine();

    public StateMachine getStateMachine(){
        return this.sm;
    }

}
