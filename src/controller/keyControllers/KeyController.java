package controller.keyControllers;

import controller.action.Action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author ChrisMoscoso
 */
public class KeyController implements KeyListener {

    protected Map<Integer, Action> actionSet = new HashMap();

    public KeyController() {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (Integer keyCode : actionSet.keySet()) {
            if (e.getKeyCode() == keyCode) {
                actionSet.get(keyCode).perform();
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
