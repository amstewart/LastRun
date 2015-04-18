package view.viewport;

import controller.action.Action;
import controller.action.equipmentHandlerAction.UnequipAction;
import java.awt.IllegalComponentStateException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.item.EquippableItem;
import model.observer.EquipmentHandlerObserver;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import model.entity.occupation.Occupation;
import model.item.EquipmentHandler;
import model.observer.AvatarObserver;
import utility.ImageUtil;

public class EquipmentViewport extends Viewport implements EquipmentHandlerObserver, AvatarObserver {

    private JPopupMenu equipmentItemMenu = new JPopupMenu("Popup");
    private JMenuItem cancel = new JMenuItem("Cancel");
    private JMenuItem equipmentUnEquip = new JMenuItem("UnEquip");

    private UnequipAction unequipAction;

    public EquipmentViewport(EquipmentHandler equipmentHandler) {
        equipmentHandler.addObserver(this);
        unequipAction = new UnequipAction(equipmentHandler);
        setUpMenu();

    }

    @Override
    public void render() {

    }

    private void setUpMenu() {
        equipmentItemMenu.add(equipmentUnEquip);
        equipmentItemMenu.addSeparator();
        equipmentItemMenu.add(cancel);

        equipmentUnEquip.addActionListener(Action.getActionListener(unequipAction));
    }

    @Override
    public void receiveEquipment(HashMap<String, EquippableItem> equipment) {
        this.removeAll();
        this.add(new JLabel("Equipment"));

        for (String s : equipment.keySet()) {
            EquippableItem item = equipment.get(s);
            if (item != null) {
                this.add(new EquippableItemButton(item));
            }
        }
    }

    @Override
    public void receiveOccupation(Occupation o) {
       unequipAction = new UnequipAction(o.getEquipmentHandler());
       equipmentUnEquip.addActionListener(Action.getActionListener(unequipAction));
       o.getEquipmentHandler().addObserver(this);
    }

    public class EquippableItemButton extends JButton {

        private EquippableItem item;

        public EquippableItemButton(EquippableItem item) {
            super(ImageUtil.getImage(item.getAssetID()));
            this.setToolTipText(item.getName());
            this.item = item;
            this.addMouseListener(new EquippableItemButtonListener());
        }

        public EquippableItem getItem() {
            return item;

        }

        private class EquippableItemButtonListener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {

                    EquippableItem item = (EquippableItem) ((EquippableItemButton) e.getSource()).getItem();
                    equipmentItemMenu.show(e.getComponent(), e.getX(), e.getY());
                    unequipAction.setEquippableItem(item);

                } catch (IllegalComponentStateException ex) {
                }
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
}
