package Visitor;

import model.entity.Avatar;
import model.entity.occupation.Occupation;

public class AvatarVisitor {
	public void visit(Avatar avatar,VisitorContainer visitorContainer,OccupationVisitor visitor){
		avatar.accept(this, visitorContainer);
	}

}
