
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.item.Item;

/**
 *
 * @author ChrisMoscoso
 */
public class ItemOwner {
    
    public Set<Item> slaves;
    
    public ItemOwner(){
        slaves = new HashSet<>();
    }
    
    public int getNumberOwned(){
        return slaves.size();
    }
    
    public void adopt(Item i){
        slaves.add(i);
    }
    
    public void release(Item i){
        slaves.remove(i);
    }
}
