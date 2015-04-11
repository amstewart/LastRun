
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.terrain.Terrain;

/**
 *
 * @author ChrisMoscoso
 */
public class TerrainOwner {
    private Set<Terrain> slaves;
    
    public TerrainOwner(){
        slaves = new HashSet<Terrain>();
    }
    
    public void adopt(Terrain t){
        slaves.add(t);
    }
    
    public void release(Terrain t){
        slaves.remove(t);
    }
    
    public int getNumberOwned(){
        return slaves.size();
    }
    
    /* TODO: This returns a random terrain if numOwner > 1 */
    public Terrain getTerrain(){
        Terrain terrain = null; 
        for(Terrain t : slaves){
            terrain = t;
        }
        return terrain;
    }
}
