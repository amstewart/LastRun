package controller;

public enum Command {
	
	NORTH("NORTH"),
	SOUTH("SOUTH");
	
	String identifier;
	private Command(String identifier) {
		this.identifier = identifier;
	}
}
