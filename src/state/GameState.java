package state;

import view.viewport.GameViewport;
import view.viewport.Viewport;

public class GameState extends State {
    
    private GameViewport viewPort;

    public GameState(){
        viewPort =  new GameViewport();
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
}
