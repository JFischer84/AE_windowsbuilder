package model;

public class Elf implements Volk {
	
	private String volksFaehigkeit = "Leichtf\u00fc\u00dfig, Nachtsicht, Unsterblich";
	private String volksName = "Elf";

	@Override
	public String getVolksFaehigkeit() {
		return volksFaehigkeit;
	}

	@Override
	public String getVolksName() {
		return volksName;
	}

}
