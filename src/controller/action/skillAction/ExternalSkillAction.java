package controller.action.skillAction;

import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.skill.ExternalSkill;
import controller.action.Action;

public class ExternalSkillAction extends Action{

	private GameMap map;
	private Entity entity;
	ExternalSkill skill;
	
	public ExternalSkillAction(GameMap map, Entity ent, ExternalSkill s){
		this.map = map;
		this.entity = ent;
		skill = s;
	}
	
	@Override
	public void perform() {
		skill.performSkill(map, entity);
	}

}
