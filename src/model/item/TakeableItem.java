package model.item;

import model.bank.BankAccount;
import model.entity.Entity;
import model.stat.Stats;
// These items are characterized by their behvaior of being added to the
// inventory in touch. These items also have a value to be sold.
public abstract class TakeableItem extends Item {

    private Stats stats;
    private int value;

    public TakeableItem(String name) {
        super(name);
    }

    public void setItemStats(Stats stats) {
        this.stats = stats;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void boostValue(int value) {
        this.value += value;
    }

    public Stats getItemStats() {
        return stats;
    }

    public void drop(Entity entity) {
        //entity.dropItem
    }

    // All takeableItems can be sold
    // TODO: Take into account the bargain skill level which all avatars have
    public abstract void sell(BankAccount bankAccount, Inventory inventory);

    public abstract void touch(Inventory inventory);

}

