package model.action;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by TubbyLumpkins on 4/4/15.
 */
public abstract class Action {

    public abstract void perform();
    public abstract void setActionListener(ActionListener al);
    public abstract void setKeyListener(KeyListener kl);
    public abstract void setMouseListener(MouseListener ml);
    public abstract ActionListener getActionListener();
    public abstract KeyListener getKeyListener();
    public abstract MouseListener getMouseListener();
}
