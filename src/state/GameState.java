package state;

import controller.GameController;
import src.model.entity.GameBundle;
import view.viewport.GameViewport;
import view.viewport.Viewport;

public class GameState implements State {
    
    private GameViewport viewPort;
    private GameController controller;

    public GameState(GameBundle bundle, StateMachine stateMachine){
        viewPort =  new GameViewport();
        controller = new GameController(bundle, stateMachine, viewPort);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void onEnter(GameBundle bundle) {

    }

    @Override
    public void onExit() {

    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
}
