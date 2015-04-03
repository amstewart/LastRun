package state;

import controller.CharacterSelectionController;
import model.GameBundle;
import view.viewport.CharacterSelectionViewport;
import view.viewport.Viewport;

public class CharacterSelectionState implements State {

    private CharacterSelectionViewport viewPort;
    private CharacterSelectionController controller;

    public CharacterSelectionState(GameBundle bundle, StateMachine stateMachine) {
        viewPort = new CharacterSelectionViewport();
        controller = new CharacterSelectionController(bundle, stateMachine, viewPort);
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
