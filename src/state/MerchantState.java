package state;

import controller.action.stateMachineAction.GoToGameAction;
import controller.keyControllers.GeneralMenuController;
import view.viewport.MerchantViewport;
import view.viewport.Viewport;

public class MerchantState extends State {


    public MerchantState() {
        viewPort = new MerchantViewport();
        controller = new GeneralMenuController(new GoToGameAction());
    }

    @Override
    public void update() {
        
    }

     @Override
    public void onEnter() {
        viewPort.addKeyListener(controller);
    }
    
    public void onExit(){
        viewPort.removeKeyListener(controller);
    }
    
   

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
}
