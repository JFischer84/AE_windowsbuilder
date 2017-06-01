package gui;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * 
 *  Diese Klasse dient als Container für die einzelnen 
 *  Charakterwerte-Felder und berechnet die Kampfwerte aus den
 *  Attributen und Eigenschaften.
 *
 */
public class CharakterWerte {

	
	private KampfWerteFeld kampfWerteFeld;
	private AttributsFeld attributsFeld;
	private EigenschaftsFeld eigenschaftsFeld;
	private int lebenskraft;
	private int abwehr;
	private int initiative;
	private double laufen;
	private int schlagen;
	private int schiessen;
	private int zaubern;
	private int zielzauber;
	private JLabel lblZuVieleAttributsPunkte;
	private JLabel lblZuVieleEigenschaftsPunkte;
	public int getLebenskraft() {
		return lebenskraft;
	}

	public int getAbwehr() {
		return abwehr;
	}

	public int getInitiative() {
		return initiative;
	}

	public double getLaufen() {
		return laufen;
	}

	public int getSchlagen() {
		return schlagen;
	}

	public int getSchiessen() {
		return schiessen;
	}

	public int getZaubern() {
		return zaubern;
	}

	public int getZielzauber() {
		return zielzauber;
	}

	public AttributsFeld getAttributsFeld() {
		return attributsFeld;
	}

	public EigenschaftsFeld getEigenschaftsFeld() {
		return eigenschaftsFeld;
	}

	public JLabel getLblZuVieleAttributsPunkte() {
		return lblZuVieleAttributsPunkte;
	}
	
	public JLabel lblZuVieleEigenschaftsPunkte() {
		return lblZuVieleEigenschaftsPunkte;
	}

	public CharakterWerte(JPanel contentPane, JButton btnSpeichern) {
		lblZuVieleAttributsPunkte = new JLabel("<html>Sie haben zu viele<br>Attributspunkte ausgegeben!</html>");
		lblZuVieleAttributsPunkte.setForeground(Color.RED);
		lblZuVieleAttributsPunkte.setBounds(800, 499, 132, 48);
		lblZuVieleAttributsPunkte.setVisible(false);
		contentPane.add(lblZuVieleAttributsPunkte);
		
		lblZuVieleEigenschaftsPunkte = new JLabel("<html>Sie haben zu viele<br>Eigenschaftspunkte ausgegeben!</html>");
		lblZuVieleEigenschaftsPunkte.setForeground(Color.RED);
		lblZuVieleEigenschaftsPunkte.setBounds(800, 551, 132, 48);
		lblZuVieleEigenschaftsPunkte.setVisible(false);
		contentPane.add(lblZuVieleEigenschaftsPunkte);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(656, 15, 18, 178);
		contentPane.add(separator);

		kampfWerteFeld = new KampfWerteFeld(contentPane);	
		attributsFeld = new AttributsFeld(contentPane, this, btnSpeichern);
		eigenschaftsFeld = new EigenschaftsFeld(contentPane, this, btnSpeichern);
	}

	//TODO
	public void berechneKampfwerte() {
		lebenskraft = attributsFeld.getKoerper() + eigenschaftsFeld.getHaerte() + eigenschaftsFeld.getHaerteBonus() + 10;
		abwehr = attributsFeld.getKoerper() + eigenschaftsFeld.getHaerte() + eigenschaftsFeld.getHaerteBonus() + 0;// PA muss raufgerechnet werden bei Auswahl von Rüstung
		initiative = (int) (attributsFeld.getAgilitaet() + eigenschaftsFeld.getBewegung() + eigenschaftsFeld.getBewegungBonus());
		laufen = Double.valueOf(attributsFeld.getAgilitaet()) / 2 + 1;
		schlagen = attributsFeld.getKoerper() + eigenschaftsFeld.getStaerke() + eigenschaftsFeld.getStaerkeBonus() + 0;// WB muss raufgerechnet werden bei Auswahl von Waffe
		schiessen = attributsFeld.getAgilitaet() + eigenschaftsFeld.getGeschick() + eigenschaftsFeld.getGeschickBonus() + 0;// WB muss raufgerechnet werden bei Auswahl von Waffe
		zaubern = attributsFeld.getGeist() + eigenschaftsFeld.getAura() + eigenschaftsFeld.getAuraBonus() - 0;// PA muss abgezogen werden bei Auswahl von Rüstung
		zielzauber = attributsFeld.getGeist() + eigenschaftsFeld.getGeschick() + eigenschaftsFeld.getGeschickBonus() - 0; // PA muss abgezogen werden bei Auswahl von Rüstung
		
		kampfWerteFeld.getLblLebenskraftPunkte().setText(Integer.toString(lebenskraft));
		kampfWerteFeld.getLblAbwehrPunkte().setText(Integer.toString(abwehr));
		kampfWerteFeld.getLblInitiativePunkte().setText(Integer.toString(initiative));
		kampfWerteFeld.getLblLaufenPunkte().setText(Double.toString(laufen));
		kampfWerteFeld.getLblSchlagenPunkte().setText(Integer.toString(schlagen));
		kampfWerteFeld.getLblSchiessenPunkte().setText(Integer.toString(schiessen));
		kampfWerteFeld.getLblZaubernPunkte().setText(Integer.toString(zaubern));
		kampfWerteFeld.getLblZielzauberPunkte().setText(Integer.toString(zielzauber));
	}
}
