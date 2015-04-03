package controller;

import model.GameBundle;
import state.StateMachine;
import view.viewport.MerchantViewport;

public class MerchantController extends Controller {

    private MerchantViewport viewPort;
    // TODO: Set all buttons with view
    public MerchantController(GameBundle bundle, StateMachine stateMachine, MerchantViewport v) {
        super(bundle, stateMachine);
        viewPort = v;
    }
}
