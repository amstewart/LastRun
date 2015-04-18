package view.viewport;

import controller.action.Action;
import controller.action.charSelectAction.SelectSmasherAction;
import controller.action.charSelectAction.SelectSneakAction;
import controller.action.charSelectAction.SelectSummonerAction;
import controller.action.stateMachineAction.GoBackAction;
import controller.action.stateMachineAction.GoToGameAction;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.entity.Avatar;

/**
 *
 * @author ChrisMoscoso
 */
public class CharacterSelectionViewport extends Viewport {

    public JLabel currentOccupation;

    public CharacterSelectionViewport(Avatar avatar) {
        initComponents(avatar);
    }

    @Override
    public void render() {

    }
    private void initComponents(Avatar avatar) {

        JButton back = new JButton("Go Back");
        back.addActionListener(Action.getActionListener(new GoBackAction()));

        this.add(back, BorderLayout.EAST);
        currentOccupation = new JLabel("Current Occupation: ");
        this.add(currentOccupation);

        // These buttons need to add actions that call the correct select function of occupation choose
        JButton summoner = new JButton("summoner");
        summoner.addActionListener(Action.getActionListener(new SelectSummonerAction(avatar)));

        JButton smasher = new JButton("smasher");
        smasher.addActionListener(Action.getActionListener(new SelectSmasherAction(avatar)));

        JButton sneak = new JButton("sneak"); 
        sneak.addActionListener(Action.getActionListener(new SelectSneakAction(avatar)));

        this.add(summoner);
        this.add(smasher);
        this.add(sneak);

        JButton goToGame = new JButton("Go to Game");
        goToGame.addActionListener(Action.getActionListener(new GoToGameAction()));
        this.add(goToGame, BorderLayout.WEST);
    }

    public void receiveSelection(String occupationName) {
        currentOccupation.setText("Current occupation selected: " +  occupationName);
    }
}
