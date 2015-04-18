package controller.action.skillAction;

import controller.action.Action;
import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.skill.ExternalSkill;
import model.skill.SpellSkill;

public class SpellSkillAction extends Action{
	private GameMap map;
	private Entity entity;
	SpellSkill skill;
	
	public SpellSkillAction(GameMap map, Entity ent, SpellSkill s){
		this.map = map;
		this.entity = ent;
		skill = s;
	}
	
	@Override
	public void perform() {
		skill.performSkill(map, entity);
	}
}
