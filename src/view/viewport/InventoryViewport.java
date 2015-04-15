
package view.viewport;

import controller2.action.Action2;
import controller2.inventoryAction.DropAction;
import java.awt.IllegalComponentStateException;
import java.awt.PopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import model.action.Action;
import model.item.Inventory;
import model.item.Item;
import model.item.TakeableItem;

public class InventoryViewport extends Viewport{

    private Inventory inventory;

    private DropAction dropAction;
    private JPopupMenu menu = new JPopupMenu("Popup");
    private JMenuItem useItem = new JMenuItem("Use");
    private JMenuItem dropItem = new JMenuItem("Drop");
    private JMenuItem cancel = new JMenuItem("Cancel");

    public InventoryViewport(Inventory inventory){
        this.inventory = inventory;
        inventory.registerView(this);

        TakeableItem[] items = inventory.getItems();
        add(new JLabel("Inventory"));
        for(int i = 0; i < items.length; i++){
            add(new ItemButton(items[i]));
        }
        dropAction = new DropAction(inventory);
        dropItem.addActionListener(Action2.getActionListener(dropAction));
    }

    public void receive(TakeableItem[] items) {
        this.removeAll();
        add(new JLabel("Inventory"));
        for(int i = 0; i < items.length; i++){
            add(new ItemButton(items[i]));
        }

    }

    private void setUpMenu() {
        menu.add(useItem);
        menu.add(dropItem);
        menu.addSeparator();
        menu.add(cancel);
    }

    @Override
    public void render() {

    }

   

    @Override
    public void setListeners(ArrayList<Action> a) {
        
    }

    public class ItemButton extends JButton {
        private Item item;
        
        public ItemButton(Item i) {
            super(i.getName());
            item = i;
            this.addMouseListener(new ItemMouseListener());
        }
        
        public Item getItem(){
            return item;
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
                
               TakeableItem ti =  (TakeableItem)((ItemButton) e.getSource()).getItem();
               menu.show(e.getComponent(), e.getX(), e.getY());
               dropAction.setCurrentItem(ti);

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
