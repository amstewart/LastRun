package state;

import view.viewport.PauseViewport;
import view.viewport.Viewport;

public class PauseState extends State {

    private PauseViewport viewPort;

    public PauseState() {
        viewPort = new PauseViewport();
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onEnter() {

    }

    @Override
    public void render() {

    }

    @Override
    public void update() {

    }
}
