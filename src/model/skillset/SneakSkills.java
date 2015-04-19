package model.skillset;

import java.util.ArrayList;

import model.effect.Creep;
import model.effect.DetectTrap;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

public class SneakSkills extends BasicSkills {

    private InternalSkill creep;
    private ExternalSkill trapDetectionRemoval;
    private InternalSkill range;

    public SneakSkills() {
    Creep creepEffect = new Creep();
    DetectTrap detectTrap= new DetectTrap();
    creep = new InternalSkill("Creep", 1, creepEffect, false);
    trapDetectionRemoval = new ExternalSkill("TrapRemoval", 1,detectTrap, 5, true);
     //   range = new InternalSkill("Range", 1);
    }

    protected InternalSkill getCreep() {
        return creep;
    }

    protected ExternalSkill getTrapRemoval() {
        return trapDetectionRemoval;
    }

    protected InternalSkill getRange() {
        return range;
    }

    @Override
    public Skill[] getSkills() {
        Skill[] list = new Skill[] {getBargain(), getBindWound(), getObservation(),
                getCreep(), getTrapRemoval(), getRange()};

        return list;
    }

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		eSkills.add(getObservation());
		eSkills.add(getBargain());
		iSkills.add(getBindWound());
		iSkills.add(getRange());
		eSkills.add(getTrapRemoval());
		iSkills.add(getCreep());
		
		
	}
}
