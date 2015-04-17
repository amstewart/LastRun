package controller.action.skillAction;

import controller.action.Action;
import model.entity.Entity;
import model.skill.InternalSkill;

public class InternalSkillAction extends Action{
	private Entity entity;
	private InternalSkill skill;
	
	public InternalSkillAction(Entity ent, InternalSkill s){
		this.entity = ent;
		skill = s;
	}
	
	@Override
	public void perform() {
		skill.perfromSkill(entity);
	}

}
