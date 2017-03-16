package gui;

import model.Charakter;
import model.Zauberwirker;

/**
 * 
 * Diese Klasse mappt die Charakterwerte aus der GUI auf das Charakter-Objekt.
 *
 */
class CharakterMapper {
	private CharakterMapper() {}
	
	static Charakter charakterWerteSetzen(Charakter charakter, CharakterWerte charakterWerte, KerndatenFeld kerndatenFeld, Kopfzeile kopfzeile) {
		//Kopfzeile
		charakter.setName(kopfzeile.getTxtName().getText());
		charakter.setGeschlecht(kopfzeile.getGeschlecht());
		//Attribute
		charakter.setAgilitaet(charakterWerte.getAttributsFeld().getAgilitaet());
		charakter.setGeist(charakterWerte.getAttributsFeld().getGeist());
		charakter.setKoerper(charakterWerte.getAttributsFeld().getKoerper());
		//Eigenschaften
		charakter.setStaerke(charakterWerte.getEigenschaftsFeld().getStaerke() + charakterWerte.getEigenschaftsFeld().getStaerkeBonus());
		charakter.setHaerte(charakterWerte.getEigenschaftsFeld().getHaerte() + charakterWerte.getEigenschaftsFeld().getHaerteBonus());
		charakter.setBewegung(charakterWerte.getEigenschaftsFeld().getBewegung() + charakterWerte.getEigenschaftsFeld().getBewegungBonus());
		charakter.setGeschick(charakterWerte.getEigenschaftsFeld().getGeschick() + charakterWerte.getEigenschaftsFeld().getGeschickBonus());
		charakter.setVerstand(charakterWerte.getEigenschaftsFeld().getVerstand() + charakterWerte.getEigenschaftsFeld().getVerstandBonus());
		charakter.setAura(charakterWerte.getEigenschaftsFeld().getAura() + charakterWerte.getEigenschaftsFeld().getAuraBonus());
		//Kampfwerte
		charakter.setLebenskraft(charakterWerte.getLebenskraft());
		charakter.setSchlagen(charakterWerte.getSchlagen());
		charakter.setAbwehr(charakterWerte.getAbwehr());
		charakter.setSchiessen(charakterWerte.getSchiessen());
		charakter.setInitiative(charakterWerte.getInitiative());
		charakter.setZaubern(charakterWerte.getZaubern());
		charakter.setLaufen(charakterWerte.getLaufen());
		charakter.setZielzauber(charakterWerte.getZielzauber());
		//Talentpunkte und Startzauber/Zauberwirkertyp
		charakter.setErsterTalentpunkt(kerndatenFeld.getStartTalent());
		charakter.setZweiterTalentpunkt(kerndatenFeld.getZweitesStarTtalent());
		if (charakter.getCharakterKlasse().getKlassenName().equals("Zauberwirker")) {
			Zauberwirker zauberwirker = new Zauberwirker();
			zauberwirker.setStartZauber(kerndatenFeld.getErsterZauber());
			zauberwirker.setZauberWirkerTyp(kerndatenFeld.getZauberWirkerTyp());
			charakter.setCharakterKlasse(zauberwirker);
		}
		return charakter;
	}
}
