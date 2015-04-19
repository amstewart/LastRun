package model.item;

import model.bank.BankAccount;
import model.entity.Entity;
import model.tile.Tile;

public class ActivationItem extends TakeableItem {

    private int interactionID;

    public ActivationItem(String name) {
        super(name);
    }

    @Override
    public void touch(Inventory inventory) {
        inventory.add(this);
    }

    @Override
    public void accept(Entity e, Tile tile) {
        tile.removeItem(this);
        e.visit(this);
    }

    @Override
    public void sell(BankAccount bankAccount, Inventory inventory) {
        bankAccount.deposit(getValue());
        inventory.remove(this);
    }

    public void setInteractionID(int id) {
        this.interactionID = id;
    }
    // Checks if passed in interactive item works with this key
    public boolean activates(InteractiveItem interactiveItem) {
        return interactionID == interactiveItem.getActivationId();
    }

}
