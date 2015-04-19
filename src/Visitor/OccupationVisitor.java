package Visitor;

import model.entity.occupation.Occupation;

public class OccupationVisitor {
	
	public void visit(Occupation occupation, VisitorContainer container){
		occupation.accept(this,container);
	}

}
