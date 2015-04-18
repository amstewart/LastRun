
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.entity.Entity;

/**
 *
 * @author ChrisMoscoso
 */
public class EntityOwner {
    
    private Set<Entity> slaves;
    
    public EntityOwner(){
        slaves = new HashSet<Entity>();
    }
    
    public void adopt(Entity e){
        slaves.add(e);
    }
    
    public void release(Entity e){
        slaves.remove(e);
    }
    
    public int getNumberOwned(){
        return slaves.size();
    }
    
    public Entity getEntity(){
        Entity e=null;
        for(Entity entity : slaves){
            e=entity;
        }
        return e;
    }

	public Set<Entity> getEntities() {
		return slaves;
	}
}
