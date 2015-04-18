package view.viewport;

import controller.action.Action;
import controller.action.equipmentHandlerAction.EquipAction;
import controller.action.equipmentHandlerAction.EquipmentDropAction;
import controller.action.inventoryAction.InventoryDropAction;
import controller.action.inventoryAction.UseAction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.IllegalComponentStateException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import model.item.EquippableItem;
import model.item.Inventory;
import model.item.NonEquippableItem;
import model.observer.InventoryObserver;

import javax.swing.*;

import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.ActivationItem;
import model.item.EquipmentHandler;
import model.observer.AvatarObserver;
import model.stat.Stats;
import utility.ImageUtil;

public class InventoryViewport extends Viewport implements InventoryObserver, AvatarObserver {

    private EquipmentViewport equipmentViewport;
    
    private JScrollPane scrollPane;
    private JPanel panel = new JPanel();

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

        this.setLayout(new GridLayout(0,2));
        panel.setLayout(new GridLayout(0, 3));

        //panel.setSize(new Dimension(300,300));
        setUpMenu();
        

        scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        
        
        equipmentViewport = new EquipmentViewport(eH, playerStats);
        add(equipmentViewport);
        
        panel.setBackground(Color.WHITE);

    }

    
    private void renderItems(EquippableItem[] equippableItems, NonEquippableItem[] nonEquippableItems,
                             ArrayList<ActivationItem> activationItems) {
        
        panel.setSize(new Dimension(this.getSize()));

        panel.removeAll();
        if (equippableItems != null) {
            for (EquippableItem i : equippableItems) {
                panel.add(new EquippableItemButton(i));
            }
        }

        if (nonEquippableItems != null) {
            for (NonEquippableItem i : nonEquippableItems) {
                panel.add(new NonEquippableItemButton(i));
            }
        }

        if (activationItems != null) {
            for (ActivationItem item: activationItems) {
                panel.add(new ActivationItemButton(item));
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
        this.revalidate();
        scrollPane.setPreferredSize(new Dimension(this.getWidth() / 2, this.getHeight()));
        equipmentViewport.setPreferredSize(new Dimension(this.getWidth() / 2, this.getHeight()));
    }

    @Override
    public void receiveOccupation(Occupation o, Stats playerStats) {
        remove(equipmentViewport);
        equipmentViewport = new EquipmentViewport(o.getEquipmentHandler(), playerStats);
        add(equipmentViewport);
        equipAction = new EquipAction(o.getEquipmentHandler(), playerStats);
        equipmentEquip.addActionListener(Action.getActionListener(equipAction));
    }

    @Override
    public void receiveTakeableItems(EquippableItem[] equippableItems, NonEquippableItem[] nonEquippableItems, ArrayList<ActivationItem> activationItems) {
        renderItems(equippableItems, nonEquippableItems, activationItems);
    }

    public class EquippableItemButton extends JButton {

        private EquippableItem item;

        public EquippableItemButton(EquippableItem item) {
            super(ImageUtil.getImage(item.getAssetID()));
            this.setToolTipText(item.getName());
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
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
            
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            
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

        public ActivationItemButton(ActivationItem item) {
            super(ImageUtil.getImage(item.getAssetID()));
            this.setToolTipText(item.getName());

            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);

            this.item = item;
            this.addMouseListener(new ActivationItemButtonListener());
        }

        public ActivationItem getItem() {
            return item;
        }

        private class ActivationItemButtonListener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
