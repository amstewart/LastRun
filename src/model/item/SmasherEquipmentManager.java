package model.item;

import model.item.equipment.*;
import view.viewport.EquipmentViewport;

import java.util.ArrayList;

public class SmasherEquipmentManager extends EquipmentManager {

    private OneHandedWeapon oneHandedWeapon;
    private TwoHandedWeapon twoHandedWeapon;
    private Shield shieldSlot;

    public SmasherEquipmentManager(Inventory inventory) {
        super(inventory);
    }

    public boolean equipOneHandedWeapon(OneHandedWeapon weapon) {
        unequipOneHandedWeapon();
        unequipTwoHandedWeapon();
        removeFromInventory(weapon);
        setOneHandedWeapon(weapon);
        notifyViews();
        return true;
    }

    public boolean equipTwoHandedWeapon(TwoHandedWeapon weapon) {
        unequipOneHandedWeapon();
        unequipShield();
        removeFromInventory(weapon);
        setTwoHandedWeapon(weapon);
        notifyViews();
        return true;
    }

    public boolean equipShield(Shield shield) {
        unequipTwoHandedWeapon();
        unequipShield();
        removeFromInventory(shield);
        setShield(shield);
        notifyViews();
        return true;
    }

    public boolean unequipOneHandedWeapon() {
        OneHandedWeapon oneHandWeapon = oneHandedWeapon;
        oneHandedWeapon = null;
        addBackToInventory(oneHandWeapon);
        notifyViews();
        return true;
    }

    public boolean unequipTwoHandedWeapon() {
        TwoHandedWeapon twoHandWeapon = twoHandedWeapon;
        twoHandedWeapon = null;
        addBackToInventory(twoHandWeapon);
        notifyViews();
        return true;
    }

    public boolean unequipShield() {
        Shield shield = shieldSlot;
        shieldSlot = null;
        addBackToInventory(shield);
        notifyViews();
        return true;
    }

    @Override
    public Equipment[] getEquippedItems() {
        Equipment[] equipment = new Equipment[] {getHead(), getChest(), getLegs(),
                                    oneHandedWeapon, twoHandedWeapon, shieldSlot};

        return equipment;
    }

    private boolean addBackToInventory(SmasherEquipment item) {
        return getInventory().addItem(item);
    }

    private boolean removeFromInventory(SmasherEquipment item) {
        return getInventory().removeItem(item);
    }

    private void setOneHandedWeapon(OneHandedWeapon weapon) {
        oneHandedWeapon = weapon;
    }

    private void setTwoHandedWeapon(TwoHandedWeapon weapon) {
        twoHandedWeapon = weapon;
    }

    private void setShield(Shield shield) {
        shieldSlot = shield;
    }
}
