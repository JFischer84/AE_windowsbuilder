import java.awt.Color;
import java.awt.Font;

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
	
	private SpinnerModel eModelStaerke = new SpinnerNumberModel(0, 0, 4, 1);
	

	private SpinnerModel eModelHaerte = new SpinnerNumberModel(0, 0, 4, 1);
	
	private SpinnerModel eModelBewegung = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel eModelGeschick = new SpinnerNumberModel(0, 0, 4, 1);
	
	private SpinnerModel eModelVerstand = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel eModelAura = new SpinnerNumberModel(0, 0, 4, 1);
	
	private JLabel lblEigenschaftspunkteUebrig = new JLabel("");
	private JButton btnSpeichern;
	private CharakterWerte charakterWerte;
	
	private int eigenschaftsPunkte = 8;

	private static final int EIGENSCHAFTEN_MAX = 8;
	
	public SpinnerModel geteModelStaerke() {
		return eModelStaerke;
	}
	public SpinnerModel geteModelHaerte() {
		return eModelHaerte;
	}
	public SpinnerModel geteModelBewegung() {
		return eModelBewegung;
	}
	public SpinnerModel geteModelGeschick() {
		return eModelGeschick;
	}
	public SpinnerModel geteModelVerstand() {
		return eModelVerstand;
	}
	public SpinnerModel geteModelAura() {
		return eModelAura;
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
		
		btnSpeichern.setBounds(795, 607, 117, 29);
		contentPane.add(btnSpeichern);

		

		
		lblEigenschaftspunkteUebrig.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEigenschaftspunkteUebrig.setBounds(868, 11, 44, 34);
		contentPane.add(lblEigenschaftspunkteUebrig);

		lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));


		JSpinner staerkeSpinner = new JSpinner(eModelStaerke);
		staerkeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}

			
		});
		staerkeSpinner.setBounds(756, 48, 44, 20);
		contentPane.add(staerkeSpinner);

		JSpinner haerteSpinner = new JSpinner(eModelHaerte);
		haerteSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		haerteSpinner.setBounds(868, 48, 44, 20);
		contentPane.add(haerteSpinner);

		


		JSpinner bewegungSpinner = new JSpinner(eModelBewegung);
		bewegungSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		bewegungSpinner.setBounds(756, 87, 44, 20);
		contentPane.add(bewegungSpinner);

		JSpinner geschickSpinner = new JSpinner(eModelGeschick);
		geschickSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		geschickSpinner.setBounds(868, 87, 44, 20);
		contentPane.add(geschickSpinner);

		

		JSpinner verstandSpinner = new JSpinner(eModelVerstand);
		verstandSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				charakterWerte.berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		verstandSpinner.setBounds(756, 126, 44, 20);
		contentPane.add(verstandSpinner);

		JSpinner auraSpinner = new JSpinner(eModelAura);
		auraSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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
		return EIGENSCHAFTEN_MAX - ((int)eModelStaerke.getValue() + (int)eModelHaerte.getValue() +
				(int)eModelAura.getValue() + (int)eModelVerstand.getValue() + (int)eModelGeschick.getValue() + (int)eModelBewegung.getValue());
	}
	
	private void pruefeUebrigeEigenschaftsPunkte() {
		if (eigenschaftsPunkte < 0) {
			btnSpeichern.setEnabled(false);
			lblEigenschaftspunkteUebrig.setForeground(Color.red);
		} else {
			btnSpeichern.setEnabled(true);
			lblEigenschaftspunkteUebrig.setForeground(Color.black);
		}
	}

}
