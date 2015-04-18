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
		int radius = skill.getRadius();
		Vector2 pos = map.getAvatarMovement().getPosition();//right now it's just getting the
		//position of the avatar, if we want NPC's to do skills, then edit this.
		LocalArea area = map.createLocalArea(radius, pos);
		skill.performSkill(area, entity);
	}
}
