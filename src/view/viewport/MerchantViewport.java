package view.viewport;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.entity.occupation.Occupation;
import model.item.ActivationItem;
import model.item.EquippableItem;
import model.item.Item;
import model.item.NonEquippableItem;
import model.item.TakeableItem;
import model.observer.AvatarObserver;
import model.observer.InventoryObserver;
import model.stat.Stats;
import utility.ImageUtil;

public class MerchantViewport extends Viewport implements InventoryObserver, AvatarObserver {

    private JPanel bankPanel, merchantPanel, inventoryPanel;
    
    public MerchantViewport() {
        initComponents();
    }
    private void initComponents() {
    
        this.setLayout(new GridLayout(0,3));
        
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(0,5));
        JPanel bankPanel = new JPanel();
        JPanel merchantPanel = new JPanel();
        
    }

    @Override
    public void render() { this.revalidate(); }

    @Override
    public void receiveAllInventoryItems(EquippableItem[] equippableItems, NonEquippableItem[] nonEquippableItems, ArrayList<ActivationItem> activationItems) {
        inventoryPanel.setSize(new Dimension(this.getSize()));

        inventoryPanel.removeAll();
        if (equippableItems != null) {
            for (EquippableItem i : equippableItems) {
                inventoryPanel.add(new MerchantItemButton(i));
            }
        }

        if (nonEquippableItems != null) {
            for (NonEquippableItem i : nonEquippableItems) {
                inventoryPanel.add(new MerchantItemButton(i));
            }
        }
    }

    @Override
    public void receiveNewOccupation(Occupation o, Stats playerStats) {
        
    }

    private class MerchantItemButton extends JButton {
        public MerchantItemButton(TakeableItem i){
            super(ImageUtil.getImage(i.getAssetID()));
            this.setToolTipText("Gold value: " + i.getValue());
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
        }
    }
}
