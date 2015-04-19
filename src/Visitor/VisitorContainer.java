package Visitor;

import model.entity.occupation.Occupation;

public class VisitorContainer {
	Occupation occupation;
	
	
	public Occupation getOccupation(){
		return occupation;
	}
	
	public void setOccupation(Occupation o){
		occupation=o;
	}
}
