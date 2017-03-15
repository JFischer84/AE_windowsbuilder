package model;

public class Zwerg implements Volk {
	
	private String volksFaehigkeit = "Dunkelsicht, Langlebig, Zäh";
	private String volksName = "Zwerg";

	@Override
	public String getVolksFaehigkeit() {
		return volksFaehigkeit;
	}

	@Override
	public String getVolksName() {
		return volksName;
	}

}
