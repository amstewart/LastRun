
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.terrain.Terrain;

/**
 *
 * @author ChrisMoscoso
 */
public class TerrainOwner {
    //private Set<Terrain> slaves;
    Terrain slave;
    
    public TerrainOwner(){
        //slaves = new HashSet<Terrain>();
    }
    
    public void adopt(Terrain t){
        slave = t;
    }
    
    public void release(Terrain t){
        slave = null;
    }
    
    public int getNumberOwned(){
        if (slave == null) return 0;
        else return 1;
    }

    public Terrain getTerrain(){
        return slave;
    }
}
