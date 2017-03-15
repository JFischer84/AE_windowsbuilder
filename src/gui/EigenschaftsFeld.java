package gui;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EigenschaftsFeld {
	
	private SpinnerModel modelStaerke = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel modelHaerte = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel modelBewegung = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel modelGeschick = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel modelVerstand = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel modelAura = new SpinnerNumberModel(0, 0, 4, 1);
	private JLabel lblEigenschaftspunkteUebrig = new JLabel("");
	private JButton btnSpeichern;
	private CharakterWerte charakterWerte;
	private int eigenschaftsPunkte = 8;
	private static final int EIGENSCHAFTEN_MAX = 8;
	private int staerke;
	private int haerte;
	private int bewegung;
	private int geschick;
	private int verstand;
	private int aura;
	private int staerkeBonus;
	private int haerteBonus;
	private int bewegungBonus;
	private int geschickBonus;
	private int verstandBonus;
	private int auraBonus;
	
	
	public int getStaerkeBonus() {
		return staerkeBonus;
	}
	public void setStaerkeBonus(int staerkeBonus) {
		this.staerkeBonus = staerkeBonus;
	}
	public int getHaerteBonus() {
		return haerteBonus;
	}
	public void setHaerteBonus(int haerteBonus) {
		this.haerteBonus = haerteBonus;
	}
	public int getBewegungBonus() {
		return bewegungBonus;
	}
	public void setBewegungBonus(int bewegungBonus) {
		this.bewegungBonus = bewegungBonus;
	}
	public int getGeschickBonus() {
		return geschickBonus;
	}
	public void setGeschickBonus(int geschickBonus) {
		this.geschickBonus = geschickBonus;
	}
	public int getVerstandBonus() {
		return verstandBonus;
	}
	public void setVerstandBonus(int verstandBonus) {
		this.verstandBonus = verstandBonus;
	}
	public int getAuraBonus() {
		return auraBonus;
	}
	public void setAuraBonus(int auraBonus) {
		this.auraBonus = auraBonus;
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

	public EigenschaftsFeld(JPanel contentPane, CharakterWerte charakterWerte, JButton btnSpeichern) {
		this.btnSpeichern = btnSpeichern;
		this.charakterWerte = charakterWerte;
		JLabel lblEigenschaften = new JLabel("Eigenschaften");
		lblEigenschaften.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEigenschaften.setBounds(716, 11, 84, 34);
		contentPane.add(lblEigenschaften);

		JLabel lblStaerke = new JLabel("St\u00E4rke");
		lblStaerke.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStaerke.setBounds(686, 42, 44, 34);
		contentPane.add(lblStaerke);

		JLabel lblHaerte = new JLabel("H\u00E4rte");
		lblHaerte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHaerte.setBounds(812, 42, 44, 34);
		contentPane.add(lblHaerte);
		
		JLabel lblBewegung = new JLabel("Bewegung");
		lblBewegung.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBewegung.setBounds(686, 81, 58, 34);
		contentPane.add(lblBewegung);

		JLabel lblGeschick = new JLabel("Geschick");
		lblGeschick.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeschick.setBounds(812, 81, 44, 34);
		contentPane.add(lblGeschick);
		
		JLabel lblVerstand = new JLabel("Verstand");
		lblVerstand.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVerstand.setBounds(686, 120, 49, 34);
		contentPane.add(lblVerstand);

		JLabel lblAura = new JLabel("Aura");
		lblAura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAura.setBounds(812, 120, 44, 34);
		contentPane.add(lblAura);
		
		JLabel lblAttributsPunkte = new JLabel("Punkte: ");
		lblAttributsPunkte.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAttributsPunkte.setBounds(563, 11, 44, 34);
		contentPane.add(lblAttributsPunkte);

		JLabel lblEigenschaftsPunkte = new JLabel("Punkte: ");
		lblEigenschaftsPunkte.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEigenschaftsPunkte.setBounds(812, 11, 44, 34);
		contentPane.add(lblEigenschaftsPunkte);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(656, 15, 18, 178);
		contentPane.add(separator);

		
		lblEigenschaftspunkteUebrig.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEigenschaftspunkteUebrig.setBounds(868, 11, 44, 34);
		contentPane.add(lblEigenschaftspunkteUebrig);

		lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));


		JSpinner staerkeSpinner = new JSpinner(modelStaerke);
		staerkeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					staerkeSpinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				staerke = Integer.parseInt(staerkeSpinner.getValue().toString());
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		staerkeSpinner.setBounds(756, 48, 44, 20);
		contentPane.add(staerkeSpinner);

		JSpinner haerteSpinner = new JSpinner(modelHaerte);
		haerteSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					haerteSpinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				haerte = Integer.parseInt(haerteSpinner.getValue().toString());
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		haerteSpinner.setBounds(868, 48, 44, 20);
		contentPane.add(haerteSpinner);

		


		JSpinner bewegungSpinner = new JSpinner(modelBewegung);
		bewegungSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					bewegungSpinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				bewegung = Integer.parseInt(bewegungSpinner.getValue().toString());
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		bewegungSpinner.setBounds(756, 87, 44, 20);
		contentPane.add(bewegungSpinner);

		JSpinner geschickSpinner = new JSpinner(modelGeschick);
		geschickSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					geschickSpinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				geschick = Integer.parseInt(geschickSpinner.getValue().toString());
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		geschickSpinner.setBounds(868, 87, 44, 20);
		contentPane.add(geschickSpinner);

		

		JSpinner verstandSpinner = new JSpinner(modelVerstand);
		verstandSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					verstandSpinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				verstand = Integer.parseInt(verstandSpinner.getValue().toString());
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		verstandSpinner.setBounds(756, 126, 44, 20);
		contentPane.add(verstandSpinner);

		JSpinner auraSpinner = new JSpinner(modelAura);
		auraSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					auraSpinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				aura = Integer.parseInt(auraSpinner.getValue().toString());
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		auraSpinner.setBounds(868, 126, 44, 20);
		contentPane.add(auraSpinner);	
	}
	private int berechneVerbleibendeEigenschaftspunkte() {
		return EIGENSCHAFTEN_MAX - (staerke + haerte + aura + verstand + geschick + bewegung);
	}
	
	private void pruefeUebrigeEigenschaftsPunkte() {
		if (eigenschaftsPunkte < 0) {
			btnSpeichern.setEnabled(false);
			lblEigenschaftspunkteUebrig.setForeground(Color.red);
			charakterWerte.lblZuVieleEigenschaftsPunkte().setVisible(true);
		} else {
			btnSpeichern.setEnabled(true);
			lblEigenschaftspunkteUebrig.setForeground(Color.black);
			charakterWerte.lblZuVieleEigenschaftsPunkte().setVisible(false);
		}
	}

}
