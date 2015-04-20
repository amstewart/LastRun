package state;

import controller.action.stateMachineAction.GoToGameAction;
import controller.keyControllers.GeneralMenuController;
import view.viewport.PauseViewport;
import view.viewport.Viewport;

public class PauseState extends State {


    public PauseState() {
        viewPort = new PauseViewport();
        controller = new GeneralMenuController(new GoToGameAction());
        viewPort.addKeyListener(controller);
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }

   
    @Override
    public void update() {

    }
}
