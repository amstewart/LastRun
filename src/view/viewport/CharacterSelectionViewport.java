
package view.viewport;

import controller2.action.Action2;
import controller2.action.stateMachineAction.GoBackAction;
import controller2.action.stateMachineAction.GoToGameAction;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.action.Action;
import model.entity.occupation.Occupation;

/**
 *
 * @author ChrisMoscoso
 */
public class CharacterSelectionViewport extends Viewport{
    
    public JLabel currentOccupation;
    
    public CharacterSelectionViewport(){
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
        back.addActionListener(Action2.getActionListener(new GoBackAction()));
        
        this.add(back, BorderLayout.EAST);

         currentOccupation = new JLabel("Current Occupation: ");
    this.add(currentOccupation);
        JButton summoner = new JButton("summoner");
        JButton smasher = new JButton("smasher");
        JButton sneak = new JButton("sneak");
        
        this.add(summoner);
        this.add(smasher);
        this.add(sneak);
        
        JButton goToGame = new JButton("Go to Game");
        goToGame.addActionListener(Action2.getActionListener(new GoToGameAction()));
        this.add(goToGame, BorderLayout.WEST);
    }

    

    public void receiveSelection(Occupation occupation) {
        currentOccupation.setText(occupation.toString());
    }

    
}
