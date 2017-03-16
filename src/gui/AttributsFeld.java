package gui;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * Diese Klasse bildet die Komponente ab, welche sich um die Attribute kümmert.
 *
 */
public class AttributsFeld {
	
	private static final int ATTRIBUTE_MAX = 20;
	private int attributsPunkte = ATTRIBUTE_MAX;
	private SpinnerModel modelAgilitaet = new SpinnerNumberModel(0, 0, 8, 1);
	private SpinnerModel modelGeist = new SpinnerNumberModel(0, 0, 8, 1);
	private SpinnerModel modelKoerper = new SpinnerNumberModel(0, 0, 8, 1);
	private JLabel lblAttributsPunkteUebrig = new JLabel("");
	private CharakterWerte charakterWerte;
	private JButton btnSpeichern;
	private int agilitaet;
	private int geist;
	private int koerper;
	private boolean buttonGesperrtDurchAttributsFeld = false;
	
	public boolean getButtonGesperrtDurchAttributsFeld() {
		return buttonGesperrtDurchAttributsFeld;
	}
	
	public int getAgilitaet() {
		return agilitaet;
	}

	public int getGeist() {
		return geist;
	}

	public int getKoerper() {
		return koerper;
	}

	public AttributsFeld(JPanel contentPane, CharakterWerte charakterWerte, JButton btnSpeichern) {
		this.charakterWerte = charakterWerte;
		this.btnSpeichern = btnSpeichern;
		
		JLabel lblAttribut = new JLabel("Attribute");
		lblAttribut.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAttribut.setBounds(493, 11, 58, 34);
		contentPane.add(lblAttribut);

		JLabel lblKoerper = new JLabel("K\u00F6rper");
		lblKoerper.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKoerper.setBounds(544, 42, 44, 34);
		contentPane.add(lblKoerper);

		JLabel lblAgilitaet = new JLabel("Agilit\u00E4t");
		lblAgilitaet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAgilitaet.setBounds(544, 81, 44, 34);
		contentPane.add(lblAgilitaet);

		JLabel lblGeist = new JLabel("Geist");
		lblGeist.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeist.setBounds(544, 120, 44, 34);
		contentPane.add(lblGeist);
		
		lblAttributsPunkteUebrig.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAttributsPunkteUebrig.setBounds(619, 11, 44, 34);
		contentPane.add(lblAttributsPunkteUebrig);

		JSpinner agilitaetSpinner = new JSpinner(modelAgilitaet);
		agilitaetSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				try {
					agilitaetSpinner.commitEdit();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				agilitaet = Integer.parseInt(agilitaetSpinner.getValue().toString());
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeAttributsPunkte();
			}
		});
		agilitaetSpinner.setBounds(600, 87, 44, 20);
		contentPane.add(agilitaetSpinner);

		JSpinner geistSpinner = new JSpinner(modelGeist);
		geistSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					geistSpinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				geist = Integer.parseInt(geistSpinner.getValue().toString());
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeAttributsPunkte();
			}
		});
		
		geistSpinner.setBounds(600, 126, 44, 20);
		contentPane.add(geistSpinner);
		JSpinner koerperSpinner = new JSpinner(modelKoerper);
		koerperSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				try {
					koerperSpinner.commitEdit();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				koerper = Integer.parseInt(koerperSpinner.getValue().toString());
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeAttributsPunkte();
			}
		});
		koerperSpinner.setBounds(600, 48, 44, 20);
		contentPane.add(koerperSpinner);
		lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
	}
	
	private void pruefeUebrigeAttributsPunkte() {
		if (attributsPunkte < 0) {
			btnSpeichern.setEnabled(false);
			charakterWerte.getLblZuVieleAttributsPunkte().setVisible(true);
			lblAttributsPunkteUebrig.setForeground(Color.red);
			buttonGesperrtDurchAttributsFeld = true;
		} else {
			lblAttributsPunkteUebrig.setForeground(Color.black);
			charakterWerte.getLblZuVieleAttributsPunkte().setVisible(false);
			buttonGesperrtDurchAttributsFeld = false;
			if (!charakterWerte.getEigenschaftsFeld().getButtonGesperrtDurchEigenschaftsFeld()) {
				btnSpeichern.setEnabled(true);
			}
		}
	}
	
	private int berechneVerbleibendeAttributspunkte() {
		return ATTRIBUTE_MAX - (koerper + agilitaet + geist);
	}
}
