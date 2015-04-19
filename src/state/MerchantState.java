package state;

import controller.action.stateMachineAction.GoToGameAction;
import controller.keyControllers.GeneralMenuController;
import model.bank.BankAccount;
import model.item.Inventory;
import view.viewport.MerchantViewport;
import view.viewport.Viewport;

public class MerchantState extends State {


    public MerchantState(Inventory inv, BankAccount account) {
        viewPort = new MerchantViewport(inv, account);
        controller = new GeneralMenuController(new GoToGameAction());
        viewPort.addKeyListener(controller);
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
