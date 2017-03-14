import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AttributsFeld {
	
	private JLabel lblAttributsPunkteUebrig = new JLabel("");
	private int attributsPunkte = 20;
	private SpinnerModel aModelAgilitaet = new SpinnerNumberModel(0, 0, 8, 1);
	private SpinnerModel aModelGeist = new SpinnerNumberModel(0, 0, 8, 1);
	private SpinnerModel aModelKoerper = new SpinnerNumberModel(0, 0, 8, 1);
	private static final int ATTRIBUTE_MAX = 20;
	private CharakterWerte charakterWerte;
	private JButton btnSpeichern;
	
	public SpinnerModel getaModelAgilitaet() {
		return aModelAgilitaet;
	}

	public SpinnerModel getaModelGeist() {
		return aModelGeist;
	}

	public SpinnerModel getaModelKoerper() {
		return aModelKoerper;
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

		JSpinner agilitaetSpinner = new JSpinner(aModelAgilitaet);
		agilitaetSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeAttributsPunkte();
			}
		});
		agilitaetSpinner.setBounds(600, 87, 44, 20);
		contentPane.add(agilitaetSpinner);

		JSpinner geistSpinner = new JSpinner(aModelGeist);
		geistSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeAttributsPunkte();
			}
		});
		geistSpinner.setBounds(600, 126, 44, 20);
		contentPane.add(geistSpinner);
		
JSpinner koerperSpinner = new JSpinner(aModelKoerper);
	
		
		
		koerperSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
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
			lblAttributsPunkteUebrig.setForeground(Color.red);
		} else {
			btnSpeichern.setEnabled(true);
			lblAttributsPunkteUebrig.setForeground(Color.black);
		}
	}
	
	private int berechneVerbleibendeAttributspunkte() {
		return ATTRIBUTE_MAX - ((int)aModelKoerper.getValue() + (int)aModelAgilitaet.getValue() + (int)aModelGeist.getValue());
	}

}
