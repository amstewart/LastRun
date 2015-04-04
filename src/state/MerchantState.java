package state;

import controller.MerchantController;
import model.entity.GameBundle;
import view.viewport.MerchantViewport;
import view.viewport.Viewport;

public class MerchantState implements State {

    private MerchantViewport viewPort;
    private MerchantController controller;

    public MerchantState(GameBundle bundle, StateMachine stateMachine) {
        viewPort = new MerchantViewport();
        controller = new MerchantController(bundle, stateMachine, viewPort);
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
