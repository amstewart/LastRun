package utility;

import model.Vector2;

public class Direction {
    public static final Vector2 DELTA_ODD = new Vector2(0, -1);

    public static final Vector2 NORTH=     new Vector2(0,-1);
    public static final Vector2 NORTHEAST = new Vector2(1,0);
    public static final Vector2 NORTHWEST = new Vector2(-1,0);
    public static final Vector2 SOUTH =     new Vector2(0,1);
    public static final Vector2 SOUTHEAST = new Vector2(1,1);
    public static final Vector2 SOUTHWEST = new Vector2(-1,1);
    
    
   public static final String facingDir(Vector2 loc){
	   if(loc.X==NORTH.X && loc.Y==NORTH.Y){
		   return "NORTH";
	   }
	   if(loc.X==NORTHEAST.X && loc.Y==NORTHEAST.Y){
		   return "NORTHEAST";
	   }
	   if(loc.X==NORTHWEST.X && loc.Y==NORTHWEST.Y){
		   return "NORTHWEST";
	   }
	   if(loc.X==SOUTH.X && loc.Y==SOUTH.Y){
		   return "SOUTH";
	   }
	   if(loc.X==SOUTHEAST.X && loc.Y==SOUTHEAST.Y){
		   return "SOUTHEAST";
	   }
	   if(loc.X==SOUTHWEST.X && loc.Y==SOUTHWEST.Y){
		   return "SOUTHWEST";
	   }
	   return "";
   }
   
   public static final int dirNum(String s){
	   if(s.equals("NORTH"))
		   return 0;
	  
	   if(s.equals("NORTHEAST"))
		   return 1;
	   
	   if(s.equals("SOUTHEAST"))
		   return 2;
	   
	  
	   if(s.equals("SOUTH"))
		   return 3;
	   
	   if(s.equals("SOUTHWEST"))
		   return 4;
	   
	   if(s.equals("NORTHWEST"))
	   return 5;
	   
	   return 0;
   }
}
