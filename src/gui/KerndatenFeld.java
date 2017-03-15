package gui;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KerndatenFeld {
	
	private CharakterWerte charakterWerte;
	private String gegebenerVolksBonus = "";
	private String gegebenerKlassenBonus = "";
	private String volk;
	private String charakterKlasse;
	private String zauberWirkerTyp;
	private String ersterZauber;
	private String StartTalent;
	private String zweitesStarTtalent;

	public String getVolk() {
		return volk;
	}

	public String getCharakterKlasse() {
		return charakterKlasse;
	}
	

	public String getZauberWirkerTyp() {
		return zauberWirkerTyp;
	}

	public String getErsterZauber() {
		return ersterZauber;
	}

	public String getStartTalent() {
		return StartTalent;
	}

	public String getZweitesStarTtalent() {
		return zweitesStarTtalent;
	}

	public KerndatenFeld(JPanel contentPane, CharakterWerte charakterWerte) {
		this.charakterWerte = charakterWerte;
		
		
		JLabel lblVolksfaehigkeiten = new JLabel("Volksfähigkeiten:");
		lblVolksfaehigkeiten.setBounds(378, 206, 119, 16);
		contentPane.add(lblVolksfaehigkeiten);
		
		JLabel lblVolksfaehigkeitenAnzeige = new JLabel("-");
		lblVolksfaehigkeitenAnzeige.setBounds(378, 234, 266, 16);
		contentPane.add(lblVolksfaehigkeitenAnzeige);
		
		JLabel lblTalent = new JLabel("Erster Talentpunkt");
		lblTalent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTalent.setBounds(175, 234, 128, 34);
		contentPane.add(lblTalent);
		
		JLabel lblKlasse = new JLabel("Klasse");
		lblKlasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKlasse.setBounds(6, 81, 146, 34);
		contentPane.add(lblKlasse);
		
		JLabel lblVolksbonus = new JLabel("Volksbonus");
		lblVolksbonus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVolksbonus.setBounds(6, 234, 76, 34);
		contentPane.add(lblVolksbonus);
		
		JLabel lblKlassenbonus = new JLabel("Klassenbonus");
		lblKlassenbonus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKlassenbonus.setBounds(6, 304, 97, 34);
		contentPane.add(lblKlassenbonus);
		
		JLabel lblZauberwirkerTyp = new JLabel("Zauberwirker Typ");
		lblZauberwirkerTyp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZauberwirkerTyp.setBounds(175, 81, 146, 34);
		contentPane.add(lblZauberwirkerTyp);
			
		JLabel lblZweitesTalent = new JLabel("Zweiter Talentpunkt");
		lblZweitesTalent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZweitesTalent.setBounds(175, 304, 146, 34);
		contentPane.add(lblZweitesTalent);
		
		JLabel lblErsterZauber = new JLabel("Erster Zauber");
		lblErsterZauber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErsterZauber.setBounds(175, 159, 146, 34);
		contentPane.add(lblErsterZauber);
		
		JLabel lblVolk = new JLabel("Volk");
		lblVolk.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVolk.setBounds(6, 159, 146, 34);
		contentPane.add(lblVolk);
		
		JComboBox<String> comboBoxVolksBonus = new JComboBox<String>();
		comboBoxVolksBonus.setBounds(10, 280, 146, 20);
		contentPane.add(comboBoxVolksBonus);
		comboBoxVolksBonus.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				gegebenerVolksBonus  = entferneBonus(gegebenerVolksBonus);
				gegebenerVolksBonus = setzeBonus(comboBoxVolksBonus, gegebenerVolksBonus);
				charakterWerte.berechneKampfwerte();
			}

		
		});
		
		JComboBox<String> comboBoxKlassenBonus = new JComboBox<String>();
		comboBoxKlassenBonus.setBounds(10, 350, 146, 20);
		contentPane.add(comboBoxKlassenBonus);
		comboBoxKlassenBonus.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				gegebenerKlassenBonus  = entferneBonus(gegebenerKlassenBonus);
				gegebenerKlassenBonus = setzeBonus(comboBoxKlassenBonus, gegebenerKlassenBonus);
				charakterWerte.berechneKampfwerte();
			}
		});
		
		JComboBox<String> comboBoxZweitesStartTalent = new JComboBox<String>();
		comboBoxZweitesStartTalent.setBounds(178, 350, 191, 20);
		contentPane.add(comboBoxZweitesStartTalent);
		comboBoxZweitesStartTalent.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if (comboBoxZweitesStartTalent.getSelectedItem() != null) {
					zweitesStarTtalent = comboBoxZweitesStartTalent.getSelectedItem().toString();
				}
			}
		});
		
		JComboBox<String> comboBoxErsterZauber = new JComboBox<String>();
		comboBoxErsterZauber.setBounds(175, 205, 191, 20);
		contentPane.add(comboBoxErsterZauber);
		comboBoxErsterZauber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxErsterZauber.getSelectedItem() != null) {
					ersterZauber = comboBoxErsterZauber.getSelectedItem().toString();
				}
				
			}
		});
		
		JComboBox<String> comboBoxStartTalent = new JComboBox<String>();
		comboBoxStartTalent.setBounds(175, 280, 191, 20);
		contentPane.add(comboBoxStartTalent);
		JComboBox<String> comboBoxKlasse = new JComboBox<String>();
		comboBoxStartTalent.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if (comboBoxStartTalent.getSelectedItem() != null) {
					StartTalent = comboBoxStartTalent.getSelectedItem().toString();
				}
			}
		});
		
		JComboBox<String> comboBoxZauberwirkerTyp = new JComboBox<String>();
		
		comboBoxZauberwirkerTyp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				zauberWirkerTyp = comboBoxZauberwirkerTyp.getSelectedItem().toString();
				comboBoxErsterZauber.removeAllItems();
				comboBoxStartTalent.removeAllItems();
				comboBoxZweitesStartTalent.removeAllItems();
				fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
				fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
				if (comboBoxZauberwirkerTyp.getSelectedItem() == "Heiler") {
					befuelleZauberHeiler(comboBoxErsterZauber);
				} else if (comboBoxZauberwirkerTyp.getSelectedItem() == "Zauberer") {
					befuelleZauberZauberer(comboBoxErsterZauber);
				} else if (comboBoxZauberwirkerTyp.getSelectedItem() == "Schwarzmagier") {
					befuelleZauberSchwarzmagier(comboBoxErsterZauber);
				}
			}
		});
		
		comboBoxZauberwirkerTyp.setBounds(178, 127, 146, 20);
		contentPane.add(comboBoxZauberwirkerTyp);
		comboBoxZauberwirkerTyp.addItem("Heiler");
		comboBoxZauberwirkerTyp.addItem("Zauberer");
		comboBoxZauberwirkerTyp.addItem("Schwarzmagier");
		
		comboBoxKlasse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				charakterKlasse = comboBoxKlasse.getSelectedItem().toString();
				comboBoxStartTalent.removeAllItems();
				comboBoxZweitesStartTalent.removeAllItems();
				comboBoxKlassenBonus.removeAllItems();
				comboBoxErsterZauber.removeAllItems();
				comboBoxZauberwirkerTyp.setEnabled(false);
				comboBoxErsterZauber.setEnabled(false);
				if (comboBoxKlasse.getSelectedItem() == "Zauberwirker") {
					comboBoxKlassenBonus.addItem("Verstand");
					comboBoxKlassenBonus.addItem("Aura");
					comboBoxZauberwirkerTyp.setEnabled(true);
					comboBoxErsterZauber.setEnabled(true);
					fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					fuelleStartTalentZauberwirker(comboBoxStartTalent);
					if (comboBoxZauberwirkerTyp.getSelectedItem() == "Heiler") {
						fuelleStartTalentHeiler(comboBoxStartTalent);
						befuelleZauberHeiler(comboBoxErsterZauber);
					} else if (comboBoxZauberwirkerTyp.getSelectedItem() == "Schwarzmagier") {
						fuelleStartTalentSchwarzmagier(comboBoxStartTalent);
						befuelleZauberSchwarzmagier(comboBoxErsterZauber);
					} else if (comboBoxZauberwirkerTyp.getSelectedItem() == "Zauberer") {
						befuelleZauberZauberer(comboBoxErsterZauber);
					}
					
				} else if (comboBoxKlasse.getSelectedItem() == "Krieger") {
					comboBoxKlassenBonus.addItem("Stärke");
					comboBoxKlassenBonus.addItem("Härte");
					fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					
					fuelleStartTalentKrieger(comboBoxStartTalent);
				} else if (comboBoxKlasse.getSelectedItem() == "Späher") {
					comboBoxKlassenBonus.addItem("Bewegung");
					comboBoxKlassenBonus.addItem("Geschick");
					fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					
					fuelleStartTalentSpaeher(comboBoxStartTalent);
				}
			}			
		});
		
		comboBoxKlasse.addItem("Krieger");
		comboBoxKlasse.addItem("Späher");
		comboBoxKlasse.addItem("Zauberwirker");
		comboBoxKlasse.setBounds(10, 127, 146, 20);
		contentPane.add(comboBoxKlasse);

		JComboBox<String> comboBoxVolk = new JComboBox<String>();
		comboBoxVolk.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				volk = comboBoxVolk.getSelectedItem().toString();
				comboBoxVolksBonus.removeAllItems();
				comboBoxStartTalent.removeAllItems();
				comboBoxZweitesStartTalent.removeAllItems();
				fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
				comboBoxZweitesStartTalent.setEnabled(false);
				if (comboBoxVolk.getSelectedItem() == "Elf") {
					fuelleVolksBonusElf(comboBoxVolksBonus);
					lblVolksfaehigkeitenAnzeige.setText("Leichtfüßig, Nachtsicht, Unsterblich");
				} else if (comboBoxVolk.getSelectedItem() == "Mensch") {
					fuelleVolksBonusElf(comboBoxVolksBonus);
					fuelleVoksBonusMensch(comboBoxVolksBonus);
					fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					lblVolksfaehigkeitenAnzeige.setText("1 Talentpunkt");
					comboBoxZweitesStartTalent.setEnabled(true);
				} else if (comboBoxVolk.getSelectedItem() == "Zwerg") {
					fuelleVolksBonusZwerg(comboBoxVolksBonus);
					lblVolksfaehigkeitenAnzeige.setText("Dunkelsicht, Langlebig, Zäh");
				}
			}	
		});
		
		comboBoxVolk.addItem("Elf");
		comboBoxVolk.addItem("Mensch");
		comboBoxVolk.addItem("Zwerg");
		comboBoxVolk.setBounds(10, 205, 146, 20);
		contentPane.add(comboBoxVolk);
	}
	
	private void befuelleZauberSchwarzmagier(JComboBox<String> comboBoxErsterZauber) {
		comboBoxErsterZauber.addItem("Feuerstrahl");
		comboBoxErsterZauber.addItem("Magie entdecken");
		comboBoxErsterZauber.addItem("Magie identifizieren");
		comboBoxErsterZauber.addItem("Magische Waffe");
		comboBoxErsterZauber.addItem("Magisches Schloss");
		comboBoxErsterZauber.addItem("Öffnen");
		comboBoxErsterZauber.addItem("Zaubertrick");
	}

	private void befuelleZauberZauberer(JComboBox<String> comboBoxErsterZauber) {
		comboBoxErsterZauber.addItem("Duftnote");
		comboBoxErsterZauber.addItem("Feuerstrahl");
		comboBoxErsterZauber.addItem("Licht");
		comboBoxErsterZauber.addItem("Magie entdecken");
		comboBoxErsterZauber.addItem("Magie identifizieren");
		comboBoxErsterZauber.addItem("Magische Waffe");
		comboBoxErsterZauber.addItem("Magisches Schloss");
		comboBoxErsterZauber.addItem("Öffnen");
		comboBoxErsterZauber.addItem("Zaubertrick");
	}

	private void befuelleZauberHeiler(JComboBox<String> comboBoxErsterZauber) {
		comboBoxErsterZauber.addItem("Blenden");
		comboBoxErsterZauber.addItem("Giftschutz");
		comboBoxErsterZauber.addItem("Heilbeeren");
		comboBoxErsterZauber.addItem("Heilende Aura");
		comboBoxErsterZauber.addItem("Heilende Hand");
		comboBoxErsterZauber.addItem("Licht");
		comboBoxErsterZauber.addItem("Magie entdecken");
		comboBoxErsterZauber.addItem("Magische Waffe");
		comboBoxErsterZauber.addItem("Niesanfall");
		comboBoxErsterZauber.addItem("Tiere besänftigen");
		comboBoxErsterZauber.addItem("Verteidigung");
		comboBoxErsterZauber.addItem("Vertreiben");
		comboBoxErsterZauber.addItem("Wasser weihen");
	}
	
	private void fuelleStartTalentSchwarzmagier(JComboBox<String> comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Feuermagier");
	}

	private void fuelleStartTalentHeiler(JComboBox<String> comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Fürsorger");
		comboBoxStartTalent.addItem("Manipulator");
		comboBoxStartTalent.addItem("Rüstzauberer");
	}

	private void fuelleStartTalentZauberwirker(JComboBox<String> comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Alchemie");
		comboBoxStartTalent.addItem("Runenkunde");
		comboBoxStartTalent.addItem("Umdenken");
		comboBoxStartTalent.addItem("Wechsler");
	}
	
	private void fuelleStartTalentSpaeher(JComboBox<String> comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Akrobat");
		comboBoxStartTalent.addItem("Diebeskunst");
		comboBoxStartTalent.addItem("Flink");
		comboBoxStartTalent.addItem("Heimlichkeit");
		comboBoxStartTalent.addItem("Jäger");
		comboBoxStartTalent.addItem("Schütze");
	}

	private void fuelleStartTalentKrieger(JComboBox<String> comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Blocker");
		comboBoxStartTalent.addItem("Kämpfer");
		comboBoxStartTalent.addItem("Parade");
		comboBoxStartTalent.addItem("Standhaft");
		comboBoxStartTalent.addItem("Zwei Waffen");
	}
	
	private void fuelleVolksBonusZwerg(JComboBox<String> comboBoxVolksBonus) {
		comboBoxVolksBonus.addItem("Stärke");
		comboBoxVolksBonus.addItem("Härte");
		comboBoxVolksBonus.addItem("Geschick");
	}

	private void fuelleVoksBonusMensch(JComboBox<String> comboBoxVolksBonus) {
		comboBoxVolksBonus.addItem("Stärke");
		comboBoxVolksBonus.addItem("Härte");
		comboBoxVolksBonus.addItem("Verstand");
	}

	private void fuelleVolksBonusElf(JComboBox<String> comboBoxVolksBonus) {
		comboBoxVolksBonus.addItem("Bewegung");
		comboBoxVolksBonus.addItem("Geschick");
		comboBoxVolksBonus.addItem("Aura");
	}
	
	private void fuellecomboBoxTalent(JComboBox<String> comboBoxStartTalent, JComboBox<String> comboBoxKlasse, JComboBox<String> comboBoxZauberwirkerTyp) {
		comboBoxStartTalent.addItem("Ausweichen");
		comboBoxStartTalent.addItem("Bildung");
		comboBoxStartTalent.addItem("Charmant");
		comboBoxStartTalent.addItem("Diener der Dunkelheit");
		comboBoxStartTalent.addItem("Diener des Lichts");
		comboBoxStartTalent.addItem("Einstecker");
		comboBoxStartTalent.addItem("Genesung");
		comboBoxStartTalent.addItem("Glückspilz");
		comboBoxStartTalent.addItem("Handwerk");
		comboBoxStartTalent.addItem("Instrument");
		comboBoxStartTalent.addItem("Magieresistent");
		comboBoxStartTalent.addItem("Reiten");
		comboBoxStartTalent.addItem("Schlitzohr");
		comboBoxStartTalent.addItem("Schnelle Reflexe");
		comboBoxStartTalent.addItem("Schwimmen");
		comboBoxStartTalent.addItem("Wahrnehmung");
		comboBoxStartTalent.addItem("Wissensgebiet");
		
		if (comboBoxKlasse.getSelectedItem() == "Zauberwirker") {
			comboBoxStartTalent.addItem("Alchemie");
			comboBoxStartTalent.addItem("Runenkunde");
			comboBoxStartTalent.addItem("Umdenken");
			comboBoxStartTalent.addItem("Wechsler");
			if (comboBoxZauberwirkerTyp.getSelectedItem() == "Heiler") {
				comboBoxStartTalent.addItem("Fürsorger");
				comboBoxStartTalent.addItem("Manipulator");
				comboBoxStartTalent.addItem("Rüstzauberer");
			} else if (comboBoxZauberwirkerTyp.getSelectedItem() == "Schwarzmagier") {
				comboBoxStartTalent.addItem("Feuermagier");
			}
	}  else if (comboBoxKlasse.getSelectedItem() == "Krieger") {
		comboBoxStartTalent.addItem("Blocker");
		comboBoxStartTalent.addItem("Kämpfer");
		comboBoxStartTalent.addItem("Parade");
		comboBoxStartTalent.addItem("Standhaft");
		comboBoxStartTalent.addItem("Zwei Waffen");
	} else if (comboBoxKlasse.getSelectedItem() == "Späher") {
		comboBoxStartTalent.addItem("Akrobat");
		comboBoxStartTalent.addItem("Diebeskunst");
		comboBoxStartTalent.addItem("Flink");
		comboBoxStartTalent.addItem("Heimlichkeit");
		comboBoxStartTalent.addItem("Jäger");
		comboBoxStartTalent.addItem("Schütze");
	}
}
	
	private String setzeBonus(JComboBox<String> comboBoxBonus, String bonus) {
		if (comboBoxBonus.getSelectedItem() != null) {
			switch (comboBoxBonus.getSelectedItem().toString()) {
			case "Stärke": bonus = "Stärke";
			charakterWerte.getEigenschaftsFeld().setStaerkeBonus(charakterWerte.getEigenschaftsFeld().getStaerkeBonus() + 1);
				break;
			case "Härte": bonus = "Härte";
			charakterWerte.getEigenschaftsFeld().setHaerteBonus(charakterWerte.getEigenschaftsFeld().getHaerteBonus() + 1);
				break;
			case "Bewegung": bonus = "Bewegung";
			charakterWerte.getEigenschaftsFeld().setBewegungBonus(charakterWerte.getEigenschaftsFeld().getBewegungBonus() + 1);
				break;
			case "Geschick": bonus = "Geschick";
			charakterWerte.getEigenschaftsFeld().setGeschickBonus(charakterWerte.getEigenschaftsFeld().getGeschickBonus() + 1);
				break;
			case "Verstand": bonus = "Verstand";
			charakterWerte.getEigenschaftsFeld().setVerstandBonus(charakterWerte.getEigenschaftsFeld().getVerstandBonus() + 1);
				break;
			case "Aura": bonus = "Aura";
			charakterWerte.getEigenschaftsFeld().setAuraBonus(charakterWerte.getEigenschaftsFeld().getAuraBonus() + 1);
				break;
			default:
				break;
			}
		}
		return bonus;		
	}
	
	private String entferneBonus(String bonus) {
		switch (bonus) {
		case "Stärke": bonus = "";
			charakterWerte.getEigenschaftsFeld().setStaerkeBonus(charakterWerte.getEigenschaftsFeld().getStaerkeBonus() - 1);
			break;
		case "Härte": bonus = "";
		charakterWerte.getEigenschaftsFeld().setHaerteBonus(charakterWerte.getEigenschaftsFeld().getHaerteBonus() - 1);
			break;
		case "Bewegung": bonus = "";
		charakterWerte.getEigenschaftsFeld().setBewegungBonus(charakterWerte.getEigenschaftsFeld().getBewegungBonus() - 1);
			break;
		case "Geschick": bonus = "";
		charakterWerte.getEigenschaftsFeld().setGeschickBonus(charakterWerte.getEigenschaftsFeld().getGeschickBonus() - 1);
			break;
		case "Verstand": bonus = "";
		charakterWerte.getEigenschaftsFeld().setVerstandBonus(charakterWerte.getEigenschaftsFeld().getVerstandBonus() - 1);
			break;
		case "Aura": bonus = "";
		charakterWerte.getEigenschaftsFeld().setAuraBonus(charakterWerte.getEigenschaftsFeld().getAuraBonus() - 1);
			break;
		default:
			break;
		}	
		return bonus;	
	}
}
