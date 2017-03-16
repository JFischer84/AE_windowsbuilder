package model;

//diese Klasse ist noch WiP und stellt momentan keine Funktionalitaet.
public class Waffe extends Ausruestung{
	private int waffenbonus;
	private String besonderes;
	public int getWaffenbonus() {
		return waffenbonus;
	}
	public String getBesonderes() {
		return besonderes;
	}
	
	public Waffe(int waffenbonus, String besonderes, int preis, String name) {
		super(name, preis);
		this.waffenbonus = waffenbonus;
		this.besonderes = besonderes;
	}
}
