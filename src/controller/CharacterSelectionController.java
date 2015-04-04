
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.model.entity.GameBundle;
import state.StateMachine;
import view.viewport.CharacterSelectionViewport;


public class CharacterSelectionController extends Controller{

    private CharacterSelectionViewport view;

    public CharacterSelectionController(GameBundle bundle, StateMachine stateMachine, CharacterSelectionViewport viewPort){
        super(bundle, stateMachine);
        view = viewPort;
        addActionListeners();
    }

    private void addActionListeners(){
        
        view.getGoToMenuButton().addActionListener(goToMainMenu);
        view.getGoToPetSelectionButton().addActionListener(goToPetSelection);
    }
    
     private ActionListener goToPetSelection = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getStateMachine().changeToState("petSelectionState", getBundle());
        }
    };
}
