package controller.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ChrisMoscoso
 */
public abstract class Action {

    public abstract void perform();

    public static ActionListener getActionListener(final Action action) {

        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                action.perform();
            }

        };
    }

    
}
