
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameBundle;
import state.StateMachine;
import view.viewport.CharacterSelectionViewport;
import view.viewport.LoadSaveViewport;


public class LoadSaveController extends Controller{

    private LoadSaveViewport view;

    public LoadSaveController(GameBundle bundle, StateMachine stateMachine, LoadSaveViewport viewPort){
        super(bundle, stateMachine);
        view = viewPort;
        addActionListeners();
    }

    private void addActionListeners(){
        
        view.getBackToMenuButton().addActionListener(goToMainMenu);
        view.getresumeGameButton().addActionListener(resumeGame);
    }
}
