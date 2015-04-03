package controller;

import model.GameBundle;
import state.StateMachine;
import view.viewport.CharacterSelectionViewport;

public class CharacterSelectionController extends Controller {

    private CharacterSelectionViewport viewPort;

    public CharacterSelectionController(GameBundle bundle, StateMachine stateMachine, CharacterSelectionViewport v) {
        super(bundle, stateMachine);
        viewPort = v;
    }
}
