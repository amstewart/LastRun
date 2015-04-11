package state;

import model.map.GameMap;
import view.viewport.GameViewport;
import view.viewport.MapViewport;
import view.viewport.Viewport;

public class GameState extends State {
    
    private Viewport viewPort;

    public GameState(){
        GameMap map = new GameMap(); 
        viewPort =  new MapViewport(map);
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
