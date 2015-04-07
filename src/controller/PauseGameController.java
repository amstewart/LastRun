package controller;

import model.entity.GameBundle;
import state.StateMachine;
import view.viewport.PauseGameViewport;

public class PauseGameController extends Controller {

    private PauseGameViewport viewPort;

    public PauseGameController(GameBundle bundle, StateMachine stateMachine, PauseGameViewport v) {
        super(bundle, stateMachine);
        viewPort = v;
        addActionListeners();
    }
    

    private void addActionListeners(){
        
        viewPort.getLoadSaveButton().addActionListener(goToLoadSave);
        viewPort.getBackToGameButton().addActionListener(resumeGame);
        viewPort.getBackToMenuButton().addActionListener(goToMainMenu);
    }

}
