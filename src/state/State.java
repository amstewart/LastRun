package state;

import model.GameBundle;
import view.viewport.Viewport;

public interface State {

    public void update();

    public void render();

    public void onEnter(GameBundle bundle);

    public void onExit();

    public Viewport getViewport();

}
