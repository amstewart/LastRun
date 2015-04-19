package Visitor;

import model.entity.Entity;

public class EntityVisitor {

	public void visit(Entity entity,VisitorContainer container){
		entity.accept(this,container);
	}
}
