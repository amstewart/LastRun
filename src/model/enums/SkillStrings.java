package model.enums;

public enum SkillStrings {
	
	ONEHAND("oneHand"),
	TWOHAND("twoHand"),
	BRAWL("brawl"),
	RANGE("range"),
	DETECTTRAP("dettrap"),
	BARGAIN("bargain");
	
	String type;

	private SkillStrings(String type) {
		this.type = type;
	}
	
	

}
