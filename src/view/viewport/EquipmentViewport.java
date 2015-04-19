package view.viewport;

import controller.action.Action;
import controller.action.equipmentHandlerAction.UnequipAction;

import java.awt.GridLayout;
import java.awt.IllegalComponentStateException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.item.EquippableItem;
import model.observer.EquipmentHandlerObserver;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.EquipmentHandler;
import model.observer.AvatarObserver;
import model.stat.Stats;
import utility.ImageUtil;

public class EquipmentViewport extends Viewport implements EquipmentHandlerObserver, AvatarObserver {

    private JPopupMenu equipmentItemMenu = new JPopupMenu("Popup");
    private JMenuItem cancel = new JMenuItem("Cancel");
    private JMenuItem equipmentUnEquip = new JMenuItem("UnEquip");

    private UnequipAction unequipAction;
    Avatar av;

    public EquipmentViewport(EquipmentHandler equipmentHandler, Stats playerStats, Avatar av) {
        equipmentHandler.addObserver(this);
        this.av = av;

        unequipAction = new UnequipAction(av, playerStats);
        setUpMenu();
    }

    @Override
    public void render() {
        this.revalidate();
    }

    private void setUpMenu() {
        equipmentItemMenu.add(equipmentUnEquip);
        equipmentItemMenu.addSeparator();
        equipmentItemMenu.add(cancel);

        equipmentUnEquip.addActionListener(Action.getActionListener(unequipAction));
        this.setLayout(new GridLayout(0, 3));
    }

    @Override
    public void receiveEquipment(HashMap<String, EquippableItem> equipment) {
        this.removeAll();
        for (String s : equipment.keySet()) {
            EquippableItem item = equipment.get(s);
            
            JButton b;
            if (item != null) {
                b = new EquippableItemButton(item);
                add(b);
            } else {
                //b = new JButton();
                //b.setOpaque(false);
                //b.setContentAreaFilled(false);
            }

            /*for (String viewSlot : viewSlots){
                
            }*/

        }

        /*this.add(new JButton(ImageUtil.getImage(ImageUtil.HEAD_SLOT)));
        this.add(new JButton(ImageUtil.getImage(ImageUtil.CHEST_SLOT)));

        this.add(new JButton(ImageUtil.getImage(ImageUtil.LEGS_SLOT)));

        this.add(new JButton(ImageUtil.getImage(ImageUtil.SHIELD_SLOT)));

        this.add(new JButton(ImageUtil.getImage(ImageUtil.SUMMONER_WEAPON_SLOT)));

        this.add(new JButton(ImageUtil.getImage(ImageUtil.SMASHER_WEAPON_SLOT)));

        this.add(new JButton(ImageUtil.getImage(ImageUtil.SNEAK_WEAPON_SLOT)));

        this.add(new JButton(ImageUtil.getImage(ImageUtil.BOOTS_SLOT)));
        this.setBackground(Color.BLUE);*/

    }

    @Override
    public void receiveNewOccupation(Occupation o, Stats playerStats) {
        unequipAction = new UnequipAction(av, playerStats);
        equipmentUnEquip.addActionListener(Action.getActionListener(unequipAction));
        o.getEquipmentHandler().addObserver(this);
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
