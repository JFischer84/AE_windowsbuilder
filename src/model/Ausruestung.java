package model;

//diese Klasse ist noch WiP und stellt momentan keine Funktionalitaet.
public abstract class Ausruestung {
	
	private String name;
	private double preis;
	
	public String getName() {
		return name;
	}
	public double getPreis() {
		return preis;
	}
	
	public Ausruestung(String name, double preis) {
		this.name = name;
		this.preis = preis;
	}
}
