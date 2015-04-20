
package state;

import controller.action.stateMachineAction.GoToGameAction;
import controller.action.stateMachineAction.GoToMainMenuAction;
import controller.keyControllers.GeneralMenuController;
import model.entity.Avatar;
import view.viewport.CharacterSelectionViewport;
import view.viewport.Viewport;


public class CharacterSelectionState extends State{

    private CharacterSelectionViewport viewPort;
    private Avatar avatar;

    public CharacterSelectionState(Avatar avatar){
        this.avatar = avatar;
        viewPort =  new CharacterSelectionViewport(avatar);
        controller = new GeneralMenuController(new GoToMainMenuAction());
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
