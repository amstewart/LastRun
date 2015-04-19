
package view.viewport;

import java.awt.Color;
import java.awt.Dimension;
import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.Inventory;
import model.map.GameMap;
import model.stat.Stats;


public class GameViewport extends Viewport{
    
    private Viewport mapVP;
    private StatsViewport statsVP;
    private InventoryViewport invVP;
    private EquipmentViewport equipVP;
    private SkillPtAllocationViewport skillPtAllocationVP;
    private DialogueViewport dialogueViewport;


    public GameViewport(MapViewport mapVP, Inventory inventory, Avatar a){
        Occupation occupation = a.getOccupation();
        Stats stats = a.getStats();
        
        this.mapVP = mapVP;
        invVP = new InventoryViewport(inventory, occupation.getEquipmentHandler(), a.getStats());
        inventory.addObserver(invVP);
        a.addObserver(invVP);
        equipVP = new EquipmentViewport(occupation.getEquipmentHandler(), a.getStats());
        a.addObserver(equipVP);
        statsVP = new StatsViewport(stats);
        skillPtAllocationVP = new SkillPtAllocationViewport(occupation.getSkillBook());
        dialogueViewport = DialogueViewport.getInstance();
        this.setBackground(Color.white);
        mapVP.setBackground(Color.lightGray);
        statsVP.setBackground(Color.lightGray);
        skillPtAllocationVP.setBackground(Color.yellow);
        dialogueViewport.setBackground(Color.yellow);
        

        this.add(mapVP);
        this.add(invVP);
        this.add(equipVP);
        this.add(statsVP);
        this.add(dialogueViewport);
        this.add(skillPtAllocationVP);
     
    }
    @Override
    public void render() {
        int width = this.getSize().width;
        int height = this.getSize().height;

        mapVP.setPreferredSize(new Dimension((int) (width * 0.40), (int) (height * 0.70)));
        equipVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        invVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        dialogueViewport.setPreferredSize(new Dimension((int) (width * 0.4), (int) (height * 0.25)));
        statsVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        skillPtAllocationVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.25)));
       

        revalidate();
        this.repaint();
        mapVP.render();
        statsVP.render();
        skillPtAllocationVP.render();
        dialogueViewport.render();
        this.requestFocusInWindow();
    }


    public void updateOccupation(Occupation o){
    	skillPtAllocationVP.updateOccupation(o.getSkillBook());
    }
    
}
