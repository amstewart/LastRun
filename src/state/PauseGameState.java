package state;

import view.viewport.PauseGameViewport;
import view.viewport.Viewport;

public class PauseGameState extends State {

    private PauseGameViewport viewPort;

    public PauseGameState() {
        viewPort = new PauseGameViewport();
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
