
package view.viewport;

import java.awt.Color;
import java.awt.Dimension;
import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.Inventory;
import model.stat.Stats;


public class GameViewport extends Viewport{
    
    private Viewport mapVP;
    private StatsViewport statsVP;
    private InventoryViewport invVP;


    public GameViewport(MapViewport mapVP, Inventory inventory, Avatar a){
        Occupation occupation = a.getOccupation();
        Stats stats = a.getStats();
        
        this.mapVP = mapVP;
        invVP = new InventoryViewport(inventory, occupation.getEquipmentHandler(), a.getStats(), a);
        inventory.addObserver(invVP);
        a.addObserver(invVP);
        statsVP = new StatsViewport(stats);
        this.setBackground(Color.white);
        mapVP.setBackground(Color.lightGray);
        statsVP.setBackground(Color.lightGray);

        this.add(mapVP);
        this.add(invVP);
        this.add(statsVP);
    }
    @Override
    public void render() {
        int width = this.getSize().width;
        int height = this.getSize().height;

        mapVP.setPreferredSize(new Dimension((int) (width * 0.40), (int) (height * 0.70)));
        invVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        statsVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        //skillPtAllocationVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));

        revalidate();
        this.repaint();
        mapVP.render();
        invVP.render();
        statsVP.render();
        //skillPtAllocationVP.render();
        this.requestFocusInWindow();
    }


    public void updateOccupation(Occupation o){
    	//skillPtAllocationVP.updateOccupation(o.getSkillBook());
    }
    
}
