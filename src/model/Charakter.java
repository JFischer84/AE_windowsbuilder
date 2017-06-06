package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * 
 * Diese Klasse stellt das Model für den Charakter.
 *
 */
@Entity
public class Charakter {
	
	@Column(name = "name")
	private String name;
	@Column(name = "geschlecht")
	private String geschlecht;
	@OneToOne
	@JoinColumn(name = "charakterklasse_id")
	private CharakterKlasse charakterKlasse;
	@OneToOne
	@JoinColumn(name = "volk_id")
	private Volk volk;
	@Column(name = "koerper")
	private int koerper;
	@Column(name = "agilitaet")
	private int agilitaet;
	@Column(name = "geist")
	private int geist;
	@Column(name = "staerke")
	private int staerke;
	@Column(name = "haerte")
	private int haerte;
	@Column(name = "bewegung")
	private int bewegung;
	@Column(name = "laufen")
	private double laufen;
	@Column(name = "geschick")
	private int geschick;
	@Column(name = "verstand")
	private int verstand;
	@Column(name = "aura")
	private int aura;
	@Column(name = "lebenskraft")
	private int lebenskraft;
	@Column(name = "schlagen")
	private int schlagen;
	@Column(name = "abwehr")
	private int abwehr;
	@Column(name = "schiessen")
	private int schiessen;
	@Column(name = "initiative")
	private int initiative;
	@Column(name = "zaubern")
	private int zaubern;
	@Column(name = "zielzauber")
	private int zielzauber;
	@Column(name = "ersterTalentpunkt")
	private String ersterTalentpunkt;
	@Column(name = "zweiterTalentpunkt")
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
