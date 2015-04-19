
package state;

import model.entity.occupation.Occupation;
import view.viewport.IntroViewport;
import view.viewport.Viewport;

public class IntroState extends State{

    private IntroViewport viewPort;
    private Occupation ocupation;

    public IntroState(Occupation occupation){
        
        this.ocupation = occupation;
        viewPort = new IntroViewport();
    }

    @Override
    public void update() {

    }

    @Override
    public void onEnter() {
        render();
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
   
}
