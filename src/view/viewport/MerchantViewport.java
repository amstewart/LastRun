package view.viewport;

import controller.action.Action;
import controller.action.equipmentHandlerAction.UnequipAction;
import controller.action.merchantAction.SellEquippableItemAction;
import controller.action.merchantAction.SellNonEquippableItemAction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.IllegalComponentStateException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import model.bank.BankAccount;
import model.entity.occupation.Occupation;
import model.item.ActivationItem;
import model.item.EquippableItem;
import model.item.Inventory;
import model.item.Item;
import model.item.NonEquippableItem;
import model.item.TakeableItem;
import model.observer.AvatarObserver;
import model.observer.InventoryObserver;
import model.stat.Stats;
import utility.ImageUtil;

public class MerchantViewport extends Viewport implements InventoryObserver {

    private BankAccount bankAccount;
    private JPanel bankPanel, merchantPanel, inventoryPanel;
    
    private JPopupMenu merchantEquippableItemMenu = new JPopupMenu("Popup");
    private JPopupMenu merchantNonEquippableItemMenu = new JPopupMenu("Popup");
    private JMenuItem cancel = new JMenuItem("Cancel");
        private JMenuItem cancel2 = new JMenuItem("Cancel");

    private JMenuItem sellEquippableItem = new JMenuItem("Sell Equip");
        private JMenuItem sellNonEquippableItem = new JMenuItem("Sell Non");


    private SellEquippableItemAction sellEquippableAction;
    private SellNonEquippableItemAction sellNonEquippableAction;
    

    public MerchantViewport(Inventory inventory, BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        initComponents();
        this.requestFocusInWindow();
        inventory.addObserver(this);
        
        sellEquippableAction = new SellEquippableItemAction(inventory, bankAccount);
        sellNonEquippableAction = new SellNonEquippableItemAction(inventory, bankAccount);
        
        merchantEquippableItemMenu.add(sellEquippableItem);
        merchantEquippableItemMenu.addSeparator();
        merchantEquippableItemMenu.add(cancel);
        
        sellEquippableItem.addActionListener(Action.getActionListener(sellEquippableAction));
        
        merchantNonEquippableItemMenu.add(sellNonEquippableItem);
        merchantNonEquippableItemMenu.addSeparator();
        merchantNonEquippableItemMenu.add(cancel2);
        
        sellNonEquippableItem.addActionListener(Action.getActionListener(sellNonEquippableAction));
        
    }

    private void initComponents() {

        this.setLayout(new GridLayout(0, 2));

        
        add(new JLabel("Inventory"));
        add(new JLabel("Bank Account Balance"));

        
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(0, 5));
        bankPanel = new JPanel();
        
        add(inventoryPanel);
        add(bankPanel);
        
    }

    @Override
    public void render() {
        this.requestFocusInWindow();
        this.revalidate();
    }

    @Override
    public void receiveAllInventoryItems(EquippableItem[] equippableItems, NonEquippableItem[] nonEquippableItems, ArrayList<ActivationItem> activationItems) {
        
        inventoryPanel.setSize(new Dimension(this.getSize()));

        inventoryPanel.removeAll();
        if (equippableItems != null) {
            for (EquippableItem i : equippableItems) {
                inventoryPanel.add(new MerchantEquippableItemButton(i));
            }
        }

        if (nonEquippableItems != null) {
            for (NonEquippableItem i : nonEquippableItems) {
                inventoryPanel.add(new MerchantNonEquippableItemButton(i));
            }
        }
        
        bankPanel.removeAll();
        bankPanel.add(new JLabel(""+bankAccount.getAccountBalance()));
    }

    private class MerchantEquippableItemButton extends JButton {

        EquippableItem item;
        
        public MerchantEquippableItemButton(EquippableItem i) {
            super(ImageUtil.getImage(i.getAssetID()));
            item = i;
            this.setToolTipText("Gold value: " + i.getValue());
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.addMouseListener(new MerchantItemButtonListener());
            
        }
        
        public TakeableItem getItem() {
            return item;

        }

        private class MerchantItemButtonListener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {

                    EquippableItem item = (EquippableItem) ((MerchantEquippableItemButton) e.getSource()).getItem();
                    merchantEquippableItemMenu.show(e.getComponent(), e.getX(), e.getY());
                    sellEquippableAction.setCurrentItem(item);

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
    
    private class MerchantNonEquippableItemButton extends JButton {

        TakeableItem item;
        
        public MerchantNonEquippableItemButton(TakeableItem i) {
            super(ImageUtil.getImage(i.getAssetID()));
            item = i;
            this.setToolTipText("Gold value: " + i.getValue());
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.addMouseListener(new MerchantItemButtonListener());
            
        }
        
        public TakeableItem getItem() {
            return item;

        }

        private class MerchantItemButtonListener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {

                    NonEquippableItem item = (NonEquippableItem) ((MerchantNonEquippableItemButton) e.getSource()).getItem();
                    merchantNonEquippableItemMenu.show(e.getComponent(), e.getX(), e.getY());
                    sellNonEquippableAction.setCurrentItem(item);

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
