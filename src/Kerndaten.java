import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Kerndaten {

	public Kerndaten(JPanel contentPane) {
		JComboBox comboBoxVolksBonus = new JComboBox();
		comboBoxVolksBonus.setBounds(10, 280, 146, 20);
		contentPane.add(comboBoxVolksBonus);
		
		JComboBox comboBoxKlassenBonus = new JComboBox();
		comboBoxKlassenBonus.setBounds(10, 350, 146, 20);
		contentPane.add(comboBoxKlassenBonus);
		
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
		
		JComboBox comboBoxZweitesStartTalent = new JComboBox();
		comboBoxZweitesStartTalent.setBounds(178, 350, 191, 20);
		contentPane.add(comboBoxZweitesStartTalent);
		
		JLabel lblErsterZauber = new JLabel("Erster Zauber");
		lblErsterZauber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErsterZauber.setBounds(175, 159, 146, 34);
		contentPane.add(lblErsterZauber);
		
		JComboBox comboBoxErsterZauber = new JComboBox();
		comboBoxErsterZauber.setBounds(175, 205, 191, 20);
		contentPane.add(comboBoxErsterZauber);
		
		JComboBox comboBoxStartTalent = new JComboBox();
		comboBoxStartTalent.setBounds(175, 280, 191, 20);
		contentPane.add(comboBoxStartTalent);
		JComboBox comboBoxKlasse = new JComboBox();
		
		JComboBox comboBoxZauberwirkerTyp = new JComboBox();
		
		comboBoxZauberwirkerTyp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
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

		JLabel lblVolk = new JLabel("Volk");
		lblVolk.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVolk.setBounds(6, 159, 146, 34);
		contentPane.add(lblVolk);

		JComboBox comboBoxVolk = new JComboBox();
		comboBoxVolk.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxVolksBonus.removeAllItems();
				comboBoxErsterZauber.removeAllItems();
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
	
	private void befuelleZauberSchwarzmagier(JComboBox comboBoxErsterZauber) {
		comboBoxErsterZauber.addItem("Feuerstrahl");
		comboBoxErsterZauber.addItem("Magie entdecken");
		comboBoxErsterZauber.addItem("Magie identifizieren");
		comboBoxErsterZauber.addItem("Magische Waffe");
		comboBoxErsterZauber.addItem("Magisches Schloss");
		comboBoxErsterZauber.addItem("Öffnen");
		comboBoxErsterZauber.addItem("Zaubertrick");
	}

	private void befuelleZauberZauberer(JComboBox comboBoxErsterZauber) {
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

	private void befuelleZauberHeiler(JComboBox comboBoxErsterZauber) {
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
	
	private void fuelleStartTalentSchwarzmagier(JComboBox comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Feuermagier");
	}

	private void fuelleStartTalentHeiler(JComboBox comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Fürsorger");
		comboBoxStartTalent.addItem("Manipulator");
		comboBoxStartTalent.addItem("Rüstzauberer");
	}

	private void fuelleStartTalentZauberwirker(JComboBox comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Alchemie");
		comboBoxStartTalent.addItem("Runenkunde");
		comboBoxStartTalent.addItem("Umdenken");
		comboBoxStartTalent.addItem("Wechsler");
	}
	
	private void fuelleStartTalentSpaeher(JComboBox comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Akrobat");
		comboBoxStartTalent.addItem("Diebeskunst");
		comboBoxStartTalent.addItem("Flink");
		comboBoxStartTalent.addItem("Heimlichkeit");
		comboBoxStartTalent.addItem("Jäger");
		comboBoxStartTalent.addItem("Schütze");
	}

	private void fuelleStartTalentKrieger(JComboBox comboBoxStartTalent) {
		comboBoxStartTalent.addItem("Blocker");
		comboBoxStartTalent.addItem("Kämpfer");
		comboBoxStartTalent.addItem("Parade");
		comboBoxStartTalent.addItem("Standhaft");
		comboBoxStartTalent.addItem("Zwei Waffen");
	}
	
	private void fuelleVolksBonusZwerg(JComboBox comboBoxVolksBonus) {
		comboBoxVolksBonus.addItem("Stärke");
		comboBoxVolksBonus.addItem("Härte");
		comboBoxVolksBonus.addItem("Geschick");
	}

	private void fuelleVoksBonusMensch(JComboBox comboBoxVolksBonus) {
		comboBoxVolksBonus.addItem("Stärke");
		comboBoxVolksBonus.addItem("Härte");
		comboBoxVolksBonus.addItem("Verstand");
	}

	private void fuelleVolksBonusElf(JComboBox comboBoxVolksBonus) {
		comboBoxVolksBonus.addItem("Bewegung");
		comboBoxVolksBonus.addItem("Geschick");
		comboBoxVolksBonus.addItem("Aura");
	}
	
	private void fuellecomboBoxTalent(JComboBox comboBoxStartTalent, JComboBox comboBoxKlasse, JComboBox comboBoxZauberwirkerTyp) {
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

}
