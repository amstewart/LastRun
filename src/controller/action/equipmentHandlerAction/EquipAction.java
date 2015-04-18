package controller.action.equipmentHandlerAction;

import controller.action.Action;

import javax.swing.JOptionPane;

import view.viewport.DialogueViewport;
import model.entity.Avatar;
import model.item.EquipmentHandler;
import model.item.EquippableItem;
import model.stat.Stats;

public class EquipAction extends Action {

    private EquippableItem equippableItem;
    private EquipmentHandler equipmentHandler;
    private Stats stats;

    public EquipAction(EquipmentHandler equipmentHandler, Stats stats) {
        this.equipmentHandler = equipmentHandler;
        this.stats = stats;
    }

    public void setEquippableItem(EquippableItem equippableItem) {
        this.equippableItem = equippableItem;
    }

    @Override
    public void perform() {
        if(equippableItem != null) {
            if(!equippableItem.equip(equipmentHandler)){
            	DialogueViewport ins =  DialogueViewport.getInstance();
            	ins.print("It looks like I can't equip items of type " + equippableItem.getSlotCategory());
            }     
        }
    }
}