package state;

import controller.keyControllers.GeneralMenuController;
import view.viewport.PauseViewport;
import view.viewport.Viewport;

public class PauseState extends State {


    public PauseState() {
        viewPort = new PauseViewport();
        controller = new GeneralMenuController();
        viewPort.addKeyListener(controller);
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }

    @Override
    public void render() {

    }

    @Override
    public void update() {

    }
}
