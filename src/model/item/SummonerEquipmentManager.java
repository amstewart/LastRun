package model.item;

import model.item.equipment.Equipment;
import model.item.equipment.SpellBook;
import model.item.equipment.Staff;
import model.item.equipment.SummonerEquipment;

public class SummonerEquipmentManager extends EquipmentManager {

    private Staff staffSlot;
    private SpellBook spellBookSlot;

    public SummonerEquipmentManager(Inventory inventory) {
        super(inventory);
    }

    public boolean equipStaff(Staff staff) {
        unequipStaff();
        removeFromInventory(staff);
        setStaff(staff);
        return true;
    }

    public boolean equipSpellBook(SpellBook spellBook) {
        unequipSpellBook();
        removeFromInventory(spellBook);
        setSpellBookSlot(spellBook);
        return true;
    }

    public boolean unequipStaff() {
        Staff staff = staffSlot;
        setStaffEmpty();
        return addBackToInventory(staff);
    }

    public boolean unequipSpellBook() {
        SpellBook spellBook = spellBookSlot;
        setSpellBookEmpty();
        return addBackToInventory(spellBook);
    }

    @Override
    public Equipment[] getEquippedItems() {
        Equipment[] equipment = new Equipment[] { getHead(), getChest(), getLegs(),
                staffSlot, spellBookSlot};

        return equipment;
    }

    private boolean addBackToInventory(SummonerEquipment item) {
        return getInventory().addItem(item);
    }

    private boolean removeFromInventory(SummonerEquipment item) {
        return getInventory().removeItem(item);
    }

    private void setStaff(Staff staff) {
        staffSlot = staff;
    }

    private void setSpellBookSlot(SpellBook spellBook) {
        spellBookSlot = spellBook;
    }

    private void setStaffEmpty() {
        staffSlot = null;
    }

    private void setSpellBookEmpty() {
        spellBookSlot = null;
    }
}
