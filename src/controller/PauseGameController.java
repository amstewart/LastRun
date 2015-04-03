package controller;

import model.GameBundle;
import state.StateMachine;
import view.viewport.PauseGameViewport;

public class PauseGameController extends Controller {

    private PauseGameViewport viewPort;

    public PauseGameController(GameBundle bundle, StateMachine stateMachine, PauseGameViewport v) {
        super(bundle, stateMachine);
        viewPort = v;
    }
}
