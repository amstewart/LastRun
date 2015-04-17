package model.entity;

import model.entity.occupation.Occupation;
import model.entity.occupation.Smasher;
import model.entity.occupation.Sneak;
import model.entity.occupation.Summoner;
import view.viewport.CharacterSelectionViewport;

import java.util.ArrayList;
// Handles responsibility of selecting an occupation
// Association class, reduces encumbering Avatar with
// responsibilities to selecting occupation

public class OccupationChooser {

    private Avatar avatar;
    private Occupation occupation;
    private ArrayList<CharacterSelectionViewport> views;

    public OccupationChooser(Avatar avatar) {
        this.avatar = avatar;
        views = new ArrayList<CharacterSelectionViewport>();
        selectSneak();//by default
    }

    public void selectSmasher() {
        occupation = new Smasher(avatar.getInventory());
        occupation.getSkillPtAllocator().setSkills(occupation.getSkills());
        notifyViews();
    }

    public void selectSneak() {
        occupation = new Sneak(avatar.getInventory());
        occupation.getSkillPtAllocator().setSkills(occupation.getSkills());
        notifyViews();
    }

    public void selectSummoner() {
        occupation = new Summoner(avatar.getInventory());
        occupation.getSkillPtAllocator().setSkills(occupation.getSkills());
        notifyViews();
    }

    public void registerView(CharacterSelectionViewport view) {
        views.add(view);
    }

    public Occupation getOccupation() {
        return occupation;
    }

    // Views that are registered will receive information on choice
    public void notifyViews() {
        for(CharacterSelectionViewport v: views) {
            v.receiveSelection(occupation.getName());
        }
    }
}
