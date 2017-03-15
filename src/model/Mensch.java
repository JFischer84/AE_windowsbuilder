package model;

public class Mensch implements Volk {
	private String volksFaehigkeit = "1 Talentpunkt";
	private String volksName = "Mensch";

	@Override
	public String getVolksFaehigkeit() {
		return volksFaehigkeit;
	}

	@Override
	public String getVolksName() {
		return volksName;
	}

}
