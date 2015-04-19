
package state;

import model.entity.Avatar;
import view.viewport.CharacterSelectionViewport;
import view.viewport.Viewport;


public class CharacterSelectionState extends State{

    private CharacterSelectionViewport viewPort;
    private Avatar avatar;

    public CharacterSelectionState(Avatar avatar){
        this.avatar = avatar;
        viewPort =  new CharacterSelectionViewport(avatar);
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
