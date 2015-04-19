
package controller.action.merchantAction;

import controller.action.Action;
import model.bank.BankAccount;
import model.item.Inventory;
import model.item.NonEquippableItem;
import model.item.TakeableItem;
/**
 *
 * @author ChrisMoscoso
 */
public class SellNonEquippableItemAction extends Action {

    private NonEquippableItem item;
    
    private Inventory inv; 
            private BankAccount account;
    
    public SellNonEquippableItemAction(Inventory inv, BankAccount account){
        this.inv = inv;
        this.account = account;
    }
    
    @Override
    public void perform() {
        if(item != null){
            account.deposit(item.getValue());
            inv.remove(item);
            
        }
    }
    
    public void setCurrentItem(NonEquippableItem i ){
        item = i;
    }
    
}
