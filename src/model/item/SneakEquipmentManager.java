package model.item;

import model.item.equipment.Equipment;
import model.item.equipment.Range;
import model.item.equipment.SneakEquipment;

public class SneakEquipmentManager extends EquipmentManager {

    private Range rangeSlot;

    public SneakEquipmentManager(Inventory inventory) {
        super(inventory);
    }

    public boolean equipRange(Range range) {
        unequipRange();
        removeFromInventory(range);
        setRangeSlot(range);
        notifyViews();
        return true;
    }

    public boolean unequipRange() {
        Range range = rangeSlot;
        setRangeSlotEmpty();
        addBackToInventory(range);
        notifyViews();
        return true;
    }

    @Override
    public Equipment[] getEquippedItems() {
        Equipment[] equipment = new Equipment[] { getHead(), getChest(), getLegs(),
                rangeSlot};

        return equipment;
    }

    private boolean addBackToInventory(SneakEquipment item) {
        return getInventory().addItem(item);
    }

    private boolean removeFromInventory(SneakEquipment item) {
        return getInventory().removeItem(item);
    }

    private void setRangeSlot(Range range) {
        rangeSlot = range;
    }

    private void setRangeSlotEmpty() {
        rangeSlot = null;
    }
}
