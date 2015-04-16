package view.viewport;

import controller.action.Action;
import controller.action.equipmentAction.UnequipAction;
import model.entity.occupation.Occupation;
import model.item.EquipmentManager;
import model.item.equipment.Equipment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class EquipmentViewport extends Viewport {

    private UnequipAction unequipAction;
    private JPopupMenu menu = new JPopupMenu("PopUp");
    private JMenuItem unequipItem = new JMenuItem("Unequip");

    public EquipmentViewport(EquipmentManager equipmentManager, Occupation occupation) {
        equipmentManager.registerView(this);
        receiveEquipment(equipmentManager.getEquippedItems());

        setMenu();
        unequipAction = new UnequipAction(occupation);
        unequipItem.addActionListener(Action.getActionListener(unequipAction));
    }

    public void receiveEquipment(Equipment[] equipment) {
        this.removeAll();
        this.add(new JLabel("Equipment"));
        for(int i = 0; i < equipment.length; i++) {
            if(equipment[i] != null) {
                add(new EquipmentButton(equipment[i]));
            }
       }
    }

    private void setMenu() {
        menu.add(unequipItem);
    }

    @Override
    public void render() {

    }

    

    public class EquipmentButton extends JButton {
        private Equipment equipment;

        public EquipmentButton(Equipment equipment) {
            super(equipment.getName());
            this.equipment = equipment;
            this.addMouseListener(new ItemMouseListener());
        }

        public Equipment getEquipment(){
            return equipment;
        }
    }
    private class ItemMouseListener implements MouseListener {

        public ItemMouseListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            try{

                Equipment equipment =  ((EquipmentButton) e.getSource()).getEquipment();
                menu.show(e.getComponent(), e.getX(), e.getY());
                unequipAction.setEquipment(equipment);


            }catch(IllegalComponentStateException ex){}
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
