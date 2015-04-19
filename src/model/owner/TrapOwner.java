package model.owner;

import model.map.Trap;

public class TrapOwner {
	 Trap slave;
    
    public TrapOwner(){
       
    }
    
    public void adopt(Trap t){
        slave = t;
    }
    
    public void release(Trap t){
        slave = null;
    }
    
    public int getNumberOwned(){
        if (slave == null) return 0;
        else return 1;
    }

    public Trap getTrap(){
        return slave;
    }
}
