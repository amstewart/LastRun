
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
        slaves = new HashSet<Item>();
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
    
    public Set<Item> getItems(){
    	return slaves;
    }
    
      public Item getItem(){
         Item item= null;
        for(Item i: slaves){
            item=i;
        }
        return item;
    }
     
}
