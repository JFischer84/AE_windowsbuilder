package gui;

import model.Charakter;
import model.Elf;
import model.Krieger;
import model.Mensch;
import model.Spaeher;
import model.Zauberwirker;
import model.Zwerg;
/**
 * 
 * Diese Klasse dient der Erstellung von Charakter-Objekten nach vorgegebenen Parametern.
 *
 */
class CharakterFactory {
	
	private CharakterFactory() {}
	
	static Charakter createCharakter(String volk, String klasse) {
		Charakter charakter = null;
		if (volk == "Elf") {
			switch (klasse) {
			case "Krieger": charakter = new Charakter(new Elf(), new Krieger());
				break;
			case "Späher": charakter = new Charakter(new Elf(), new Spaeher());
				break;
			case "Zauberwirker": charakter = new Charakter(new Elf(), new Zauberwirker());
				break;
			default:
				break;
			}
		} else if (volk == "Mensch") {
			switch (klasse) {
			case "Krieger": charakter = new Charakter(new Mensch(), new Krieger());
				break;
			case "Späher": charakter = new Charakter(new Mensch(), new Spaeher());
				break;
			case "Zauberwirker": charakter = new Charakter(new Mensch(), new Zauberwirker());
				break;
			default:
				break;
			}
		} else if (volk == "Zwerg") {
			switch (klasse) {
			case "Krieger": charakter = new Charakter(new Zwerg(), new Krieger());
				break;
			case "Späher": charakter = new Charakter(new Zwerg(), new Spaeher());
				break;
			case "Zauberwirker": charakter = new Charakter(new Zwerg(), new Zauberwirker());
				break;
			default:
				break;
			}
		}
		return charakter;
	}
}
