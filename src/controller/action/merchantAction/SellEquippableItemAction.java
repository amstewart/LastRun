
package controller.action.merchantAction;

import controller.action.Action;
import model.bank.BankAccount;
import model.item.EquippableItem;
import model.item.Inventory;
import model.item.NonEquippableItem;
import model.item.TakeableItem;
import view.viewport.DialogueViewport;
/**
 *
 * @author ChrisMoscoso
 */
public class SellEquippableItemAction extends Action {

    private EquippableItem item;
    
    private Inventory inv; 
            private BankAccount account;
    
    public SellEquippableItemAction(Inventory inv, BankAccount account){
        this.inv = inv;
        this.account = account;
    }
    
    @Override
    public void perform() {
        if(item != null){
            account.deposit(item.getValue());
            inv.remove(item);
            DialogueViewport.getInstance().print("I sold " + item.getName() + " and received " + item.getValue() + " gold.");
        }
    }
    
    public void setCurrentItem(EquippableItem i ){
        item = i;
    }
    
}
