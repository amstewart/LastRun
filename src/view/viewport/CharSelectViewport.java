
package view.viewport;

import controller.action.stateMachineAction.GoBackAction;
import java.util.ArrayList;
import javax.swing.JButton;
import model.action.Action;

/**
 *
 * @author ChrisMoscoso
 */
public class CharSelectViewport extends Viewport{
    public CharSelectViewport(){
        initComponents();
    }

    @Override
    public void render() {
        
    }

    @Override
    public void setListeners(ArrayList<Action> a) {
        
    }

    private void initComponents() {
        JButton back = new JButton("Go Back");
        back.addActionListener(Action.getActionListener(new GoBackAction()));
        
        JButton petSelect = new JButton("Go to Pet Select");
       // petSelect.addActionListener(Controller.getActionListener());
    }
}
