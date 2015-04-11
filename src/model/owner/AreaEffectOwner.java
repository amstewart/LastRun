
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.areaEffect.AreaEffect;

/**
 *
 * @author ChrisMoscoso
 */
public class AreaEffectOwner {
    public Set<AreaEffect> slaves;
    
    public AreaEffectOwner(){
        slaves = new HashSet<AreaEffect>();
    }
    
    public int getNumberOwned(){
        return slaves.size();
    }
    
    public void adopt(AreaEffect a){
        slaves.add(a);
    }
    
    public void release(AreaEffect a){
        slaves.remove(a);
    }
}
