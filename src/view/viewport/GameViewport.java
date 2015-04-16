
package view.viewport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.entity.occupation.Smasher;
import model.item.EquipmentManager;
import model.item.Inventory;
import model.item.SmasherEquipmentManager;
import model.item.equipment.Equipment;
import model.item.equipment.SmasherEquipment;
import model.map.GameMap;
import model.stat.Stats;

import javax.swing.*;

/**
 *
 * @author ChrisMoscoso
 */
public class GameViewport extends Viewport{
    
    private Viewport mapVP;
    private Viewport inventoryVP;
    private EquipmentViewport equipmentVP;
    private StatsViewport statsVP;
    
    public GameViewport(GameMap map, Inventory inventory, Stats stats){
        mapVP = new MapViewport(map);
        // TEMP TEST
        Occupation smasher = new Smasher(inventory);
        EquipmentManager equipmentManager = smasher.getEquipmentManager();
        inventoryVP = new InventoryViewport(inventory, smasher);
        equipmentVP = new EquipmentViewport(equipmentManager, smasher);
        statsVP = new StatsViewport(stats);

        this.setBackground(Color.white);
        inventoryVP.setBackground(Color.lightGray);
        mapVP.setBackground(Color.lightGray);
        equipmentVP.setBackground(Color.blue);
        statsVP.setBackground(Color.lightGray);

        this.add(mapVP);
        this.add(inventoryVP);
        this.add(equipmentVP);
        this.add(statsVP);
    }

    @Override
    public void render() {
        int width = this.getSize().width;
        int height = this.getSize().height;

        mapVP.setPreferredSize(new Dimension((int) (width * 0.40), (int) (height * 0.70)));
        inventoryVP.setPreferredSize(new Dimension((int) (width * 0.10), (int) (height * 0.70)));
        equipmentVP.setPreferredSize(new Dimension((int) (width * 0.10), (int) (height * 0.70)));
        statsVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));

        revalidate();
        this.repaint();
        mapVP.render();
        inventoryVP.render();
        equipmentVP.render();
        statsVP.render();

        this.requestFocusInWindow();
    }

    
}
