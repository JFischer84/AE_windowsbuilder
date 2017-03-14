import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

public class Kampfwerte {
	
	private SpinnerModel aModelAgilitaet = new SpinnerNumberModel(0, 0, 8, 1);
	private SpinnerModel aModelGeist = new SpinnerNumberModel(0, 0, 8, 1);
	private SpinnerModel aModelKoerper = new SpinnerNumberModel(0, 0, 8, 1);
	
	private SpinnerModel eModelStaerke = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel eModelHaerte = new SpinnerNumberModel(0, 0, 4, 1);
	
	private SpinnerModel eModelBewegung = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel eModelGeschick = new SpinnerNumberModel(0, 0, 4, 1);
	
	private SpinnerModel eModelVerstand = new SpinnerNumberModel(0, 0, 4, 1);
	private SpinnerModel eModelAura = new SpinnerNumberModel(0, 0, 4, 1);
	
	private JLabel lblLebenskraftPunkte = new JLabel("0");
	private JLabel lblSchlagenPunkte = new JLabel("0");
	private JLabel lblAbwehrPunkte = new JLabel("0");
	private JLabel lblSchiessenPunkte = new JLabel("0");
	private JLabel lblInitiativePunkte = new JLabel("0");
	private JLabel lblZaubernPunkte = new JLabel("0");
	private JLabel lblLaufenPunkte = new JLabel("0");
	private JLabel lblZielzauberPunkte = new JLabel("0");
	private JLabel lblAttributsPunkteUebrig = new JLabel("");
	private JLabel lblEigenschaftspunkteUebrig = new JLabel("");
	private JButton btnSpeichern = new JButton("Speichern");
	
	
	private int attributsPunkte = 20;
	private int eigenschaftsPunkte = 8;
	private static final int ATTRIBUTE_MAX = 20;
	private static final int EIGENSCHAFTEN_MAX = 8;
	private int lebenskraft;
	private int abwehr;
	private int initiative;
	private double laufen;
	private int schlagen;
	private int schiessen;
	private int zaubern;
	private int zielzauber;
	

	public Kampfwerte(JPanel contentPane) {
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
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(656, 15, 18, 178);
		contentPane.add(separator);
		
		btnSpeichern.setBounds(795, 607, 117, 29);
		contentPane.add(btnSpeichern);

		lblAttributsPunkteUebrig.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAttributsPunkteUebrig.setBounds(619, 11, 44, 34);
		contentPane.add(lblAttributsPunkteUebrig);

		JSpinner agilitaetSpinner = new JSpinner(aModelAgilitaet);
		agilitaetSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				berechneKampfwerte();
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
				berechneKampfwerte();
				pruefeUebrigeAttributsPunkte();
			}
		});
		geistSpinner.setBounds(600, 126, 44, 20);
		contentPane.add(geistSpinner);

		

		lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));

		
		lblEigenschaftspunkteUebrig.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEigenschaftspunkteUebrig.setBounds(868, 11, 44, 34);
		contentPane.add(lblEigenschaftspunkteUebrig);

		lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));

		JSpinner koerperSpinner = new JSpinner(aModelKoerper);
	
		
		
		koerperSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				berechneKampfwerte();
				pruefeUebrigeAttributsPunkte();
			}

			
		});
		koerperSpinner.setBounds(600, 48, 44, 20);
		contentPane.add(koerperSpinner);

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

		

		JSpinner staerkeSpinner = new JSpinner(eModelStaerke);
		staerkeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				berechneKampfwerte();
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
				berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		haerteSpinner.setBounds(868, 48, 44, 20);
		contentPane.add(haerteSpinner);

		JLabel lblBewegung = new JLabel("Bewegung");
		lblBewegung.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBewegung.setBounds(686, 81, 58, 34);
		contentPane.add(lblBewegung);

		JLabel lblGeschick = new JLabel("Geschick");
		lblGeschick.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeschick.setBounds(812, 81, 44, 34);
		contentPane.add(lblGeschick);


		JSpinner bewegungSpinner = new JSpinner(eModelBewegung);
		bewegungSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				berechneKampfwerte();
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
				berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		geschickSpinner.setBounds(868, 87, 44, 20);
		contentPane.add(geschickSpinner);

		JLabel lblVerstand = new JLabel("Verstand");
		lblVerstand.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVerstand.setBounds(686, 120, 49, 34);
		contentPane.add(lblVerstand);

		JLabel lblAura = new JLabel("Aura");
		lblAura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAura.setBounds(812, 120, 44, 34);
		contentPane.add(lblAura);

		JSpinner verstandSpinner = new JSpinner(eModelVerstand);
		verstandSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				eigenschaftsPunkte = berechneVerbleibendeEigenschaftspunkte();
				lblEigenschaftspunkteUebrig.setText(Integer.toString(eigenschaftsPunkte));
				berechneKampfwerte();
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
				berechneKampfwerte();
				pruefeUebrigeEigenschaftsPunkte();
			}
		});
		auraSpinner.setBounds(868, 126, 44, 20);
		contentPane.add(auraSpinner);

		JLabel lblAttributsPunkte = new JLabel("Punkte: ");
		lblAttributsPunkte.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAttributsPunkte.setBounds(563, 11, 44, 34);
		contentPane.add(lblAttributsPunkte);

		JLabel lblEigenschaftsPunkte = new JLabel("Punkte: ");
		lblEigenschaftsPunkte.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEigenschaftsPunkte.setBounds(812, 11, 44, 34);
		contentPane.add(lblEigenschaftsPunkte);
		
		
		
		
		JPanel charakterWertePanel = new JPanel();
		charakterWertePanel.setBounds(666, 205, 242, 122);
		contentPane.add(charakterWertePanel);
		GridBagLayout gbl_charakterWertePanel = new GridBagLayout();
		gbl_charakterWertePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_charakterWertePanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_charakterWertePanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_charakterWertePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		charakterWertePanel.setLayout(gbl_charakterWertePanel);
		
		JLabel lblLebenskraft = new JLabel("Lebenskraft:");
		GridBagConstraints gbc_lblLebenskraft = new GridBagConstraints();
		gbc_lblLebenskraft.insets = new Insets(0, 0, 5, 5);
		gbc_lblLebenskraft.gridx = 0;
		gbc_lblLebenskraft.gridy = 0;
		charakterWertePanel.add(lblLebenskraft, gbc_lblLebenskraft);
		lblLebenskraft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GridBagConstraints gbc_lblLebenskraftPunkte = new GridBagConstraints();
		gbc_lblLebenskraftPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblLebenskraftPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblLebenskraftPunkte.gridx = 1;
		gbc_lblLebenskraftPunkte.gridy = 0;
		charakterWertePanel.add(lblLebenskraftPunkte, gbc_lblLebenskraftPunkte);
		lblLebenskraftPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblSchlagen = new JLabel("Schlagen:");
		GridBagConstraints gbc_lblSchlagen = new GridBagConstraints();
		gbc_lblSchlagen.anchor = GridBagConstraints.WEST;
		gbc_lblSchlagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchlagen.gridx = 2;
		gbc_lblSchlagen.gridy = 0;
		charakterWertePanel.add(lblSchlagen, gbc_lblSchlagen);
		lblSchlagen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblSchlagenPunkte = new GridBagConstraints();
		gbc_lblSchlagenPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblSchlagenPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblSchlagenPunkte.gridx = 3;
		gbc_lblSchlagenPunkte.gridy = 0;
		charakterWertePanel.add(lblSchlagenPunkte, gbc_lblSchlagenPunkte);
		lblSchlagenPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblAbwehr = new JLabel("Abwehr:");
		GridBagConstraints gbc_lblAbwehr = new GridBagConstraints();
		gbc_lblAbwehr.anchor = GridBagConstraints.WEST;
		gbc_lblAbwehr.insets = new Insets(0, 0, 5, 5);
		gbc_lblAbwehr.gridx = 0;
		gbc_lblAbwehr.gridy = 1;
		charakterWertePanel.add(lblAbwehr, gbc_lblAbwehr);
		lblAbwehr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblAbwehrPunkte = new GridBagConstraints();
		gbc_lblAbwehrPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblAbwehrPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblAbwehrPunkte.gridx = 1;
		gbc_lblAbwehrPunkte.gridy = 1;
		charakterWertePanel.add(lblAbwehrPunkte, gbc_lblAbwehrPunkte);
		lblAbwehrPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		JLabel lblSchiessen = new JLabel("Schießen:");
		GridBagConstraints gbc_lblSchiessen = new GridBagConstraints();
		gbc_lblSchiessen.anchor = GridBagConstraints.WEST;
		gbc_lblSchiessen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchiessen.gridx = 2;
		gbc_lblSchiessen.gridy = 1;
		charakterWertePanel.add(lblSchiessen, gbc_lblSchiessen);
		lblSchiessen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblSchiessenPunkte = new GridBagConstraints();
		gbc_lblSchiessenPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblSchiessenPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblSchiessenPunkte.gridx = 3;
		gbc_lblSchiessenPunkte.gridy = 1;
		charakterWertePanel.add(lblSchiessenPunkte, gbc_lblSchiessenPunkte);
		lblSchiessenPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblInitiative = new JLabel("Initiative:");
		GridBagConstraints gbc_lblInitiative = new GridBagConstraints();
		gbc_lblInitiative.anchor = GridBagConstraints.WEST;
		gbc_lblInitiative.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitiative.gridx = 0;
		gbc_lblInitiative.gridy = 2;
		charakterWertePanel.add(lblInitiative, gbc_lblInitiative);
		lblInitiative.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblInitiativePunkte = new GridBagConstraints();
		gbc_lblInitiativePunkte.anchor = GridBagConstraints.WEST;
		gbc_lblInitiativePunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitiativePunkte.gridx = 1;
		gbc_lblInitiativePunkte.gridy = 2;
		charakterWertePanel.add(lblInitiativePunkte, gbc_lblInitiativePunkte);
		lblInitiativePunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		JLabel lblZaubern = new JLabel("Zaubern:");
		GridBagConstraints gbc_lblZaubern = new GridBagConstraints();
		gbc_lblZaubern.anchor = GridBagConstraints.WEST;
		gbc_lblZaubern.insets = new Insets(0, 0, 5, 5);
		gbc_lblZaubern.gridx = 2;
		gbc_lblZaubern.gridy = 2;
		charakterWertePanel.add(lblZaubern, gbc_lblZaubern);
		lblZaubern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblZaubernPunkte = new GridBagConstraints();
		gbc_lblZaubernPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblZaubernPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblZaubernPunkte.gridx = 3;
		gbc_lblZaubernPunkte.gridy = 2;
		charakterWertePanel.add(lblZaubernPunkte, gbc_lblZaubernPunkte);
		lblZaubernPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblLaufen = new JLabel("Laufen:");
		GridBagConstraints gbc_lblLaufen = new GridBagConstraints();
		gbc_lblLaufen.anchor = GridBagConstraints.WEST;
		gbc_lblLaufen.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaufen.gridx = 0;
		gbc_lblLaufen.gridy = 3;
		charakterWertePanel.add(lblLaufen, gbc_lblLaufen);
		lblLaufen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblLaufenPunkte = new GridBagConstraints();
		gbc_lblLaufenPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblLaufenPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaufenPunkte.gridx = 1;
		gbc_lblLaufenPunkte.gridy = 3;
		charakterWertePanel.add(lblLaufenPunkte, gbc_lblLaufenPunkte);
		lblLaufenPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblZielzauber = new JLabel("Zielzauber:");
		GridBagConstraints gbc_lblZielzauber = new GridBagConstraints();
		gbc_lblZielzauber.anchor = GridBagConstraints.WEST;
		gbc_lblZielzauber.insets = new Insets(0, 0, 5, 5);
		gbc_lblZielzauber.gridx = 2;
		gbc_lblZielzauber.gridy = 3;
		charakterWertePanel.add(lblZielzauber, gbc_lblZielzauber);
		lblZielzauber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblZielzauberPunkte = new GridBagConstraints();
		gbc_lblZielzauberPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblZielzauberPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblZielzauberPunkte.gridx = 3;
		gbc_lblZielzauberPunkte.gridy = 3;
		charakterWertePanel.add(lblZielzauberPunkte, gbc_lblZielzauberPunkte);
		lblZielzauberPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
	}
	
	
	private int berechneVerbleibendeAttributspunkte() {
		return ATTRIBUTE_MAX - ((int)aModelKoerper.getValue() + (int)aModelAgilitaet.getValue() + (int)aModelGeist.getValue());
	}
	
	private int berechneVerbleibendeEigenschaftspunkte() {
		return EIGENSCHAFTEN_MAX - ((int)eModelStaerke.getValue() + (int)eModelHaerte.getValue() +
				(int)eModelAura.getValue() + (int)eModelVerstand.getValue() + (int)eModelGeschick.getValue() + (int)eModelBewegung.getValue());
	}

	//TODO
	private void berechneKampfwerte() {
		lebenskraft = (int)aModelKoerper.getValue() + (int)eModelHaerte.getValue() + 10;
		abwehr = (int)aModelKoerper.getValue() + (int)eModelHaerte.getValue() + 0;// PA
		initiative = (int)aModelAgilitaet.getValue() + (int)eModelBewegung.getValue();
		laufen = Double.valueOf(aModelAgilitaet.getValue().toString()) / 2 + 1;
		schlagen = (int)aModelKoerper.getValue() + (int)eModelStaerke.getValue() + 0;// WB
		schiessen = (int)aModelAgilitaet.getValue() + (int)eModelGeschick.getValue() + 0;// WB
		zaubern = (int)aModelGeist.getValue() + (int)eModelAura.getValue() - 0;// PA
		zielzauber = (int)aModelGeist.getValue() + (int)eModelGeschick.getValue() - 0; // PA
		
		lblLebenskraftPunkte.setText(Integer.toString(lebenskraft));
		lblAbwehrPunkte.setText(Integer.toString(abwehr));
		lblInitiativePunkte.setText(Integer.toString(initiative));
		lblLaufenPunkte.setText(Double.toString(laufen));
		lblSchlagenPunkte.setText(Integer.toString(schlagen));
		lblSchiessenPunkte.setText(Integer.toString(schiessen));
		lblZaubernPunkte.setText(Integer.toString(zaubern));
		lblZielzauberPunkte.setText(Integer.toString(zielzauber));
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
