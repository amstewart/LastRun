
package view.viewport;

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

/**
 *
 * @author ChrisMoscoso
 */
public class InventoryViewport extends Viewport{
    private Inventory inventory;
    private JPopupMenu menu = new JPopupMenu("Popup");
    private JMenuItem useItem = new JMenuItem("Use"), dropItem = new JMenuItem("Drop");
    
    public InventoryViewport(Inventory i){
        inventory = i;
        menu.add(useItem);
        menu.add(dropItem);
    }
    
    @Override
    public void render() {
        this.removeAll();
        add(new JLabel("Inventory"));
        for(Item item : inventory.getItems()){
            add(new ItemButton(item));
        }
    }

    @Override
    public void setListeners(ArrayList<Action> a) {
        
    }

    private class ItemButton extends JButton {
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
           menu.show(e.getComponent(), e.getX(), e.getY());
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
