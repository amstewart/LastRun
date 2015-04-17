
package view.viewport;

import java.awt.Color;
import java.awt.Dimension;
import model.entity.occupation.Occupation;
import model.item.EquipmentManager;
import model.item.Inventory;
import model.map.GameMap;
import model.stat.Stats;


/**
 *
 * @author ChrisMoscoso
 */
public class GameViewport extends Viewport{
    
    private Viewport mapVP;
    private InventoryViewport inventoryVP;
    private EquipmentViewport equipmentVP;
    private StatsViewport statsVP;
    private SkillPtAllocationViewport skillPtAllocationVP;


    public GameViewport(MapViewport mapVP, Inventory inventory, Occupation occupation, Stats stats){
        this.mapVP = mapVP;
        // TEMP TEST
        EquipmentManager equipmentManager = occupation.getEquipmentManager();
        inventoryVP = new InventoryViewport(inventory, occupation);
        equipmentVP = new EquipmentViewport(equipmentManager, occupation);
        statsVP = new StatsViewport(stats);
        skillPtAllocationVP = new SkillPtAllocationViewport(occupation.getSkillBook());
        this.setBackground(Color.white);
        inventoryVP.setBackground(Color.lightGray);
        mapVP.setBackground(Color.lightGray);
        equipmentVP.setBackground(Color.blue);
        statsVP.setBackground(Color.lightGray);
        skillPtAllocationVP.setBackground(Color.yellow);

        this.add(mapVP);
        this.add(inventoryVP);
        this.add(equipmentVP);
        this.add(statsVP);
        this.add(skillPtAllocationVP);
    }
    @Override
    public void render() {
        int width = this.getSize().width;
        int height = this.getSize().height;

        mapVP.setPreferredSize(new Dimension((int) (width * 0.40), (int) (height * 0.70)));
        inventoryVP.setPreferredSize(new Dimension((int) (width * 0.10), (int) (height * 0.70)));
        equipmentVP.setPreferredSize(new Dimension((int) (width * 0.10), (int) (height * 0.70)));
        statsVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        skillPtAllocationVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));

        revalidate();
        this.repaint();
        mapVP.render();
        inventoryVP.render();
        equipmentVP.render();
        statsVP.render();
        skillPtAllocationVP.render();
        this.requestFocusInWindow();
    }
    
    public InventoryViewport getInventoryViewport(){
        return inventoryVP;
    }

    public EquipmentViewport getEquipmentViewport(){
        return equipmentVP;
    }
    
    public void updateOccupation(Occupation o){
    	skillPtAllocationVP.updateOccupation(o.getSkillBook());
    }
    
}
