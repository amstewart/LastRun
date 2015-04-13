
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

import javax.swing.*;

/**
 *
 * @author ChrisMoscoso
 */
public class GameViewport extends Viewport{
    
    private Viewport mapVP,inventoryVP;
    
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
        int height = this.getSize().height;
        mapVP.setPreferredSize(new Dimension((int) (width * 0.40), (int) (height * 0.70)));
        inventoryVP.setPreferredSize(new Dimension((int) (width * 0.10), (int) (height * 0.70)));

        revalidate();
        this.repaint();
        mapVP.render();
        inventoryVP.render();

        this.requestFocusInWindow();
    }

    @Override
    public void setListeners(ArrayList<Action> a) {
        this.addKeyListener(a.get(0).getKeyListener());
        this.addKeyListener(a.get(1).getKeyListener());
        this.addKeyListener(a.get(2).getKeyListener());
        this.addKeyListener(a.get(3).getKeyListener());
        this.addKeyListener(a.get(4).getKeyListener());
        this.addKeyListener(a.get(5).getKeyListener());

        this.setFocusable(true);
        this.requestFocusInWindow();

    }
}
