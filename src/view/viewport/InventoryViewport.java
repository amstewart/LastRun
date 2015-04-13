
package view.viewport;

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

/**
 *
 * @author ChrisMoscoso
 */
public class InventoryViewport extends Viewport{
    private Inventory inventory;
    private JPopupMenu menu = new JPopupMenu("Popup");
    private JMenuItem useItem = new JMenuItem("Use"), dropItem = new JMenuItem("Drop"), cancel = new JMenuItem("Cancel");
    private TakeableItem ti;
    
    public InventoryViewport(Inventory i){
        inventory = i;
        menu.add(useItem);
        menu.add(dropItem);
        menu.addSeparator();
        menu.add(cancel);
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
        //menu.addMenuKeyListener(a.get(0));
        dropItem.addActionListener(a.get(0).getActionListener());

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
                ti =  (TakeableItem)((ItemButton) e.getSource()).getItem();
                menu.show(e.getComponent(), e.getX(), e.getY());

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
