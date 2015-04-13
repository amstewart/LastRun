
package view.viewport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import model.action.Action;
import model.item.Inventory;
import model.map.GameMap;

/**
 *
 * @author ChrisMoscoso
 */
public class GameViewport extends Viewport{
    
    private Viewport mapVP, inventoryVP;
    
    public GameViewport(GameMap map, Inventory inventory){
        mapVP = new MapViewport(map);
        inventoryVP = new InventoryViewport(inventory);
        this.setBackground(Color.white);
        inventoryVP.setBackground(Color.lightGray);
        mapVP.setBackground(Color.lightGray);
        this.add(mapVP);
        this.add(inventoryVP);
    }

    @Override
    public void render() {
        int width = this.getSize().width;
        int height = this.getPreferredSize().height;
        mapVP.setPreferredSize(new Dimension((int) (width * 0.40), height));
        inventoryVP.setPreferredSize(new Dimension((int) (width * 0.10), height));
        
        mapVP.render();
        inventoryVP.render();
        revalidate();
    }

    @Override
    public void setListeners(ArrayList<Action> a) {
        
    }
}
