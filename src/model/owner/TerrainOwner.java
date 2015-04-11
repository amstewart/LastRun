
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
        slaves = new HashSet<>();
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
}
