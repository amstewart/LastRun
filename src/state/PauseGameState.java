package state;

import controller.PauseGameController;
import model.GameBundle;
import view.viewport.CharacterSelectionViewport;
import view.viewport.PauseGameViewport;
import view.viewport.Viewport;

public class PauseGameState implements State {

    private PauseGameViewport viewPort;
    private PauseGameController controller;

    public PauseGameState(GameBundle bundle, StateMachine stateMachine) {
        viewPort = new PauseGameViewport();
        controller = new PauseGameController(bundle, stateMachine, viewPort);
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onEnter(GameBundle bundle) {

    }

    @Override
    public void render() {

    }

    @Override
    public void update() {

    }
}
