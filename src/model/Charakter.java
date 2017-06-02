package model;

import org.hibernate.annotations.Table;

/**
 * 
 * Diese Klasse stellt das Model für den Charakter.
 *
 */
@Table(appliesTo = "charakter")
public class Charakter {
	
	
	private String name;
	private String geschlecht;
	private CharakterKlasse charakterKlasse;
	private Volk volk;
	private int koerper;
	private int agilitaet;
	private int geist;
	private int staerke;
	private int haerte;
	private int bewegung;
	private double laufen;
	private int geschick;
	private int verstand;
	private int aura;
	private int lebenskraft;
	private int schlagen;
	private int abwehr;
	private int schiessen;
	private int initiative;
	private int zaubern;
	private int zielzauber;
	private String ersterTalentpunkt;
	private String zweiterTalentpunkt;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	public CharakterKlasse getCharakterKlasse() {
		return charakterKlasse;
	}
	public void setCharakterKlasse(CharakterKlasse charakterKlasse) {
		this.charakterKlasse = charakterKlasse;
	}
	public Volk getVolk() {
		return volk;
	}
	public void setVolk(Volk volk) {
		this.volk = volk;
	}
	public int getKoerper() {
		return koerper;
	}
	public void setKoerper(int koerper) {
		this.koerper = koerper;
	}
	public int getAgilitaet() {
		return agilitaet;
	}
	public void setAgilitaet(int agilitaet) {
		this.agilitaet = agilitaet;
	}
	public int getGeist() {
		return geist;
	}
	public void setGeist(int geist) {
		this.geist = geist;
	}
	public int getStaerke() {
		return staerke;
	}
	public void setStaerke(int staerke) {
		this.staerke = staerke;
	}
	public int getHaerte() {
		return haerte;
	}
	public void setHaerte(int haerte) {
		this.haerte = haerte;
	}
	public int getBewegung() {
		return bewegung;
	}
	public void setBewegung(int bewegung) {
		this.bewegung = bewegung;
	}
	
	public double getLaufen() {
		return laufen;
	}
	public void setLaufen(double laufen) {
		this.laufen = laufen;
	}
	public int getGeschick() {
		return geschick;
	}
	public void setGeschick(int geschick) {
		this.geschick = geschick;
	}
	public int getVerstand() {
		return verstand;
	}
	public void setVerstand(int verstand) {
		this.verstand = verstand;
	}
	public int getAura() {
		return aura;
	}
	public void setAura(int aura) {
		this.aura = aura;
	}
	public int getLebenskraft() {
		return lebenskraft;
	}
	public void setLebenskraft(int lebenskraft) {
		this.lebenskraft = lebenskraft;
	}
	public int getSchlagen() {
		return schlagen;
	}
	public void setSchlagen(int schlagen) {
		this.schlagen = schlagen;
	}
	public int getAbwehr() {
		return abwehr;
	}
	public void setAbwehr(int abwehr) {
		this.abwehr = abwehr;
	}
	public int getSchiessen() {
		return schiessen;
	}
	public void setSchiessen(int schiessen) {
		this.schiessen = schiessen;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public int getZaubern() {
		return zaubern;
	}
	public void setZaubern(int zaubern) {
		this.zaubern = zaubern;
	}

	public int getZielzauber() {
		return zielzauber;
	}
	public void setZielzauber(int zielzauber) {
		this.zielzauber = zielzauber;
	}
	public String getErsterTalentpunkt() {
		return ersterTalentpunkt;
	}
	public void setErsterTalentpunkt(String ersterTalentpunkt) {
		this.ersterTalentpunkt = ersterTalentpunkt;
	}
	public String getZweiterTalentpunkt() {
		return zweiterTalentpunkt;
	}
	public void setZweiterTalentpunkt(String zweiterTalentpunkt) {
		this.zweiterTalentpunkt = zweiterTalentpunkt;
	}
	
	public Charakter(Volk volk, CharakterKlasse charakterKlasse) {
		this.volk = volk;
		this.charakterKlasse = charakterKlasse;
	}
	
}
