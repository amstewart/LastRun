package view.viewport;

import controller.action.Action;
import controller.action.equipmentHandlerAction.EquipAction;
import controller.action.equipmentHandlerAction.EquipmentDropAction;
import controller.action.inventoryAction.InventoryDropAction;
import controller.action.inventoryAction.UseAction;
import java.awt.IllegalComponentStateException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import model.item.*;
import model.observer.InventoryObserver;

import javax.swing.*;
import model.entity.occupation.Occupation;
import model.observer.AvatarObserver;
import model.stat.Stats;
import utility.ImageUtil;

public class InventoryViewport extends Viewport implements InventoryObserver, AvatarObserver {

    private EquipAction equipAction;
    private EquipmentDropAction equipmentDropAction;
    private UseAction useAction;
    private InventoryDropAction inventoryDropAction;

    private JPopupMenu equipmentItemMenu = new JPopupMenu("Popup");
    private JMenuItem equipmentEquip = new JMenuItem("Equip");
    private JMenuItem equipmentItemDrop = new JMenuItem("Drop");

    private JPopupMenu inventoryItemMenu = new JPopupMenu("Popup");
    private JMenuItem inventoryUse = new JMenuItem("Use");
    private JMenuItem inventoryItemDrop = new JMenuItem("Drop");

    private JMenuItem cancel = new JMenuItem("Cancel");
    private JMenuItem cancel2 = new JMenuItem("Cancel");

    public InventoryViewport(Inventory inventory, EquipmentHandler eH, Stats playerStats) {

        equipAction = new EquipAction(eH, playerStats);
        useAction = new UseAction(inventory, playerStats);
        inventory.addObserver(this);
        inventoryDropAction = new InventoryDropAction(inventory);

        equipmentDropAction = new EquipmentDropAction(inventory);

        setUpMenu();

    }

    @Override
    public void receiveTakeableItems(EquippableItem[] equippableItems, NonEquippableItem[] nonEquippableItems,
                                     ArrayList<ActivationItem> activationItems) {
        // Receives items and partitions them properly.
        renderItems(equippableItems, nonEquippableItems, activationItems);
    }

    private void renderItems(EquippableItem[] equippableItems, NonEquippableItem[] nonEquippableItems,
                             ArrayList<ActivationItem> activationItems) {
        this.removeAll();
        this.add(new JLabel("Inventory"));
        if (equippableItems != null) {
            for (EquippableItem i : equippableItems) {
                this.add(new EquippableItemButton(i));
            }
        }

        if (nonEquippableItems != null) {
            for (NonEquippableItem i : nonEquippableItems) {
                this.add(new NonEquippableItemButton(i));
            }
        }

        //TEMPORARY
        if (activationItems != null) {
            for (ActivationItem item : activationItems) {
                this.add(new ActivationItemButton(item));
                System.out.println(item.getName()+ " WAS ADDED");
            }
        }
    }

    private void setUpMenu() {
        equipmentItemMenu.add(equipmentEquip);
        equipmentItemMenu.add(equipmentItemDrop);
        equipmentItemMenu.addSeparator();
        equipmentItemMenu.add(cancel);

        equipmentEquip.addActionListener(Action.getActionListener(equipAction));
        equipmentItemDrop.addActionListener(Action.getActionListener(equipmentDropAction));

        inventoryItemMenu.add(inventoryUse);
        inventoryItemMenu.add(inventoryItemDrop);
        inventoryItemMenu.addSeparator();
        inventoryItemMenu.add(cancel2);

        inventoryUse.addActionListener(Action.getActionListener(useAction));
        inventoryItemDrop.addActionListener(Action.getActionListener(inventoryDropAction));
    }

    @Override
    public void render() {

    }

    @Override
    public void receiveOccupation(Occupation o, Stats playerStats) {
        equipAction = new EquipAction(o.getEquipmentHandler(), playerStats);
        equipmentEquip.addActionListener(Action.getActionListener(equipAction));
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
                    equipAction.setEquippableItem(item);
                    equipmentDropAction.setCurrentItem(item);

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

    public class NonEquippableItemButton extends JButton {

        private NonEquippableItem item;

        public NonEquippableItemButton(NonEquippableItem item) {
            super(ImageUtil.getImage(item.getAssetID()));
            this.setToolTipText(item.getName());
            this.item = item;
            this.addMouseListener(new NonEquippableItemButtonListener());
        }

        public NonEquippableItem getItem() {
            return item;
        }

        private class NonEquippableItemButtonListener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                NonEquippableItem item = (NonEquippableItem) ((NonEquippableItemButton) e.getSource()).getItem();
                inventoryItemMenu.show(e.getComponent(), e.getX(), e.getY());
                useAction.setCurrentItem(item);
                inventoryDropAction.setCurrentItem(item);

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

    public class ActivationItemButton extends JButton {
        private ActivationItem item;

        public ActivationItemButton(ActivationItem activationItem) {
            super(ImageUtil.getImage(activationItem.getAssetID()));
            this.item = activationItem;
            this.setToolTipText(item.getName());
        }
    }

}
