package model;

public class Elf implements Volk {
	
	private String volksFaehigkeit = "Leichtfüßig, Nachtsicht, Unsterblich";
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
