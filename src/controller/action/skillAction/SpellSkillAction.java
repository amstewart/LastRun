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
	int numtimes;
	
	public SpellSkillAction(GameMap map, Entity ent, SpellSkill s){
		this.map = map;
		this.entity = ent;
		skill = s;
	}
	
	@Override
	public void perform() {
		if(numtimes == 2){
			System.out.println("sadfasdf");
		}
		skill.performSkill(map, entity);
		++numtimes;
		
	}
}
