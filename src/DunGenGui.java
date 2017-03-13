import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DunGenGui extends JFrame {

	private int attributsPunkte = 20;
	private int eigenschaftsPunkte = 8;
	private static final int ATTRIBUTE_MAX = 20;
	private static final int EIGENSCHAFTEN_MAX = 8;
	private int lebenskraft;
	private int abwehr;
	private int initiative;
	private int laufen;
	private int schlagen;
	private int schiessen;
	private int zaubern;
	private int zielzauber;
	private JPanel contentPane;
	
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DunGenGui frame = new DunGenGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DunGenGui() {
		setTitle("DunGen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxVolksBonus = new JComboBox();
		comboBoxVolksBonus.setBounds(10, 280, 146, 20);
		contentPane.add(comboBoxVolksBonus);
		
		JComboBox comboBoxKlassenBonus = new JComboBox();
		comboBoxKlassenBonus.setBounds(10, 350, 146, 20);
		contentPane.add(comboBoxKlassenBonus);
		
		JLabel lblTalent = new JLabel("Erster Talentpunkt");
		lblTalent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTalent.setBounds(175, 234, 128, 34);
		contentPane.add(lblTalent);
		
		
		
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
				} else if (comboBoxZauberwirkerTyp.getSelectedItem() == "Zauberer") {
					comboBoxErsterZauber.addItem("Duftnote");
					comboBoxErsterZauber.addItem("Feuerstrahl");
					comboBoxErsterZauber.addItem("Licht");
					comboBoxErsterZauber.addItem("Magie entdecken");
					comboBoxErsterZauber.addItem("Magie identifizieren");
					comboBoxErsterZauber.addItem("Magische Waffe");
					comboBoxErsterZauber.addItem("Magisches Schloss");
					comboBoxErsterZauber.addItem("Öffnen");
					comboBoxErsterZauber.addItem("Zaubertrick");
				} else if (comboBoxZauberwirkerTyp.getSelectedItem() == "Schwarzmagier") {
					comboBoxErsterZauber.addItem("Feuerstrahl");
					comboBoxErsterZauber.addItem("Magie entdecken");
					comboBoxErsterZauber.addItem("Magie identifizieren");
					comboBoxErsterZauber.addItem("Magische Waffe");
					comboBoxErsterZauber.addItem("Magisches Schloss");
					comboBoxErsterZauber.addItem("Öffnen");
					comboBoxErsterZauber.addItem("Zaubertrick");
				}
			}
		});
		comboBoxZauberwirkerTyp.setBounds(178, 127, 146, 20);
		contentPane.add(comboBoxZauberwirkerTyp);
		comboBoxZauberwirkerTyp.addItem("Heiler");
		comboBoxZauberwirkerTyp.addItem("Zauberer");
		comboBoxZauberwirkerTyp.addItem("Schwarzmagier");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(656, 15, 18, 178);
		contentPane.add(separator);
		
		JLabel lblAttributsPunkteUebrig = new JLabel("");
		lblAttributsPunkteUebrig.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAttributsPunkteUebrig.setBounds(619, 11, 44, 34);
		contentPane.add(lblAttributsPunkteUebrig);
			
		
		JLabel lblKlasse = new JLabel("Klasse");
		lblKlasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKlasse.setBounds(6, 81, 146, 34);
		contentPane.add(lblKlasse);
		
		

		
		comboBoxKlasse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxStartTalent.removeAllItems();
				comboBoxZweitesStartTalent.removeAllItems();
				comboBoxKlassenBonus.removeAllItems();
				comboBoxZauberwirkerTyp.setEnabled(false);
				comboBoxErsterZauber.setEnabled(false);
				if (comboBoxKlasse.getSelectedItem() == "Zauberwirker") {
					comboBoxKlassenBonus.addItem("Verstand");
					comboBoxKlassenBonus.addItem("Aura");
					comboBoxZauberwirkerTyp.setEnabled(true);
					comboBoxErsterZauber.setEnabled(true);
					fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					
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
					
				} else if (comboBoxKlasse.getSelectedItem() == "Krieger") {
					comboBoxKlassenBonus.addItem("Stärke");
					comboBoxKlassenBonus.addItem("Härte");
					fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					
					comboBoxStartTalent.addItem("Blocker");
					comboBoxStartTalent.addItem("Kämpfer");
					comboBoxStartTalent.addItem("Parade");
					comboBoxStartTalent.addItem("Standhaft");
					comboBoxStartTalent.addItem("Zwei Waffen");
				} else if (comboBoxKlasse.getSelectedItem() == "Späher") {
					comboBoxKlassenBonus.addItem("Bewegung");
					comboBoxKlassenBonus.addItem("Geschick");
					fuellecomboBoxTalent(comboBoxStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
					
					comboBoxStartTalent.addItem("Akrobat");
					comboBoxStartTalent.addItem("Diebeskunst");
					comboBoxStartTalent.addItem("Flink");
					comboBoxStartTalent.addItem("Heimlichkeit");
					comboBoxStartTalent.addItem("Jäger");
					comboBoxStartTalent.addItem("Schütze");
				}
			}
		});
		comboBoxKlasse.addItem("Zauberwirker");
		comboBoxKlasse.addItem("Krieger");
		comboBoxKlasse.addItem("Späher");
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
				fuellecomboBoxTalent(comboBoxZweitesStartTalent, comboBoxKlasse, comboBoxZauberwirkerTyp);
				comboBoxZweitesStartTalent.setEnabled(false);
				if (comboBoxVolk.getSelectedItem() == "Elf") {
					comboBoxVolksBonus.addItem("Bewegung");
					comboBoxVolksBonus.addItem("Geschick");
					comboBoxVolksBonus.addItem("Aura");
				} else if (comboBoxVolk.getSelectedItem() == "Mensch") {
					comboBoxVolksBonus.addItem("Bewegung");
					comboBoxVolksBonus.addItem("Geschick");
					comboBoxVolksBonus.addItem("Aura");
					comboBoxVolksBonus.addItem("Stärke");
					comboBoxVolksBonus.addItem("Härte");
					comboBoxVolksBonus.addItem("Verstand");
					comboBoxZweitesStartTalent.setEnabled(true);
				} else if (comboBoxVolk.getSelectedItem() == "Zwerg") {
					comboBoxVolksBonus.addItem("Stärke");
					comboBoxVolksBonus.addItem("Härte");
					comboBoxVolksBonus.addItem("Geschick");
				}
			}
		});
		comboBoxVolk.addItem("Elf");
		comboBoxVolk.addItem("Mensch");
		comboBoxVolk.addItem("Zwerg");
		comboBoxVolk.setBounds(10, 205, 146, 20);
		contentPane.add(comboBoxVolk);
		
		

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

		

		JSpinner agilitaetSpinner = new JSpinner(aModelAgilitaet);
		agilitaetSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				attributsPunkte = berechneVerbleibendeAttributspunkte();
				lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));
				berechneKampfwerte();
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
			}
		});
		geistSpinner.setBounds(600, 126, 44, 20);
		contentPane.add(geistSpinner);

		

		lblAttributsPunkteUebrig.setText(Integer.toString(attributsPunkte));

		JLabel lblEigenschaftspunkteUebrig = new JLabel("");
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
		
		JRadioButton rdbtnMaennlich = new JRadioButton("Männlich");
		rdbtnMaennlich.setBounds(271, 22, 141, 23);
		contentPane.add(rdbtnMaennlich);
		
		JRadioButton rdbtnWeiblich = new JRadioButton("Weiblich");
		rdbtnWeiblich.setBounds(271, 46, 141, 23);
		contentPane.add(rdbtnWeiblich);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnWeiblich);
		buttonGroup.add(rdbtnMaennlich);
		
		JLabel lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGeschlecht.setBounds(201, 6, 74, 34);
		contentPane.add(lblGeschlecht);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(6, 15, 74, 34);
		contentPane.add(lblName);
		
		JTextPane txtName = new JTextPane();
		txtName.setBounds(18, 42, 134, 16);
		contentPane.add(txtName);
		
		JPanel charakterWertePannel = new JPanel();
		charakterWertePannel.setBounds(666, 205, 242, 122);
		contentPane.add(charakterWertePannel);
		GridBagLayout gbl_charakterWertePannel = new GridBagLayout();
		gbl_charakterWertePannel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_charakterWertePannel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_charakterWertePannel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_charakterWertePannel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		charakterWertePannel.setLayout(gbl_charakterWertePannel);
		
		JLabel lblLebenskraft = new JLabel("Lebenskraft:");
		GridBagConstraints gbc_lblLebenskraft = new GridBagConstraints();
		gbc_lblLebenskraft.insets = new Insets(0, 0, 5, 5);
		gbc_lblLebenskraft.gridx = 0;
		gbc_lblLebenskraft.gridy = 0;
		charakterWertePannel.add(lblLebenskraft, gbc_lblLebenskraft);
		lblLebenskraft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GridBagConstraints gbc_lblLebenskraftPunkte = new GridBagConstraints();
		gbc_lblLebenskraftPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblLebenskraftPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblLebenskraftPunkte.gridx = 1;
		gbc_lblLebenskraftPunkte.gridy = 0;
		charakterWertePannel.add(lblLebenskraftPunkte, gbc_lblLebenskraftPunkte);
		lblLebenskraftPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblSchlagen = new JLabel("Schlagen:");
		GridBagConstraints gbc_lblSchlagen = new GridBagConstraints();
		gbc_lblSchlagen.anchor = GridBagConstraints.WEST;
		gbc_lblSchlagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchlagen.gridx = 2;
		gbc_lblSchlagen.gridy = 0;
		charakterWertePannel.add(lblSchlagen, gbc_lblSchlagen);
		lblSchlagen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblSchlagenPunkte = new GridBagConstraints();
		gbc_lblSchlagenPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblSchlagenPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblSchlagenPunkte.gridx = 3;
		gbc_lblSchlagenPunkte.gridy = 0;
		charakterWertePannel.add(lblSchlagenPunkte, gbc_lblSchlagenPunkte);
		lblSchlagenPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblAbwehr = new JLabel("Abwehr:");
		GridBagConstraints gbc_lblAbwehr = new GridBagConstraints();
		gbc_lblAbwehr.anchor = GridBagConstraints.WEST;
		gbc_lblAbwehr.insets = new Insets(0, 0, 5, 5);
		gbc_lblAbwehr.gridx = 0;
		gbc_lblAbwehr.gridy = 1;
		charakterWertePannel.add(lblAbwehr, gbc_lblAbwehr);
		lblAbwehr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblAbwehrPunkte = new GridBagConstraints();
		gbc_lblAbwehrPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblAbwehrPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblAbwehrPunkte.gridx = 1;
		gbc_lblAbwehrPunkte.gridy = 1;
		charakterWertePannel.add(lblAbwehrPunkte, gbc_lblAbwehrPunkte);
		lblAbwehrPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		JLabel lblSchiessen = new JLabel("Schießen:");
		GridBagConstraints gbc_lblSchiessen = new GridBagConstraints();
		gbc_lblSchiessen.anchor = GridBagConstraints.WEST;
		gbc_lblSchiessen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchiessen.gridx = 2;
		gbc_lblSchiessen.gridy = 1;
		charakterWertePannel.add(lblSchiessen, gbc_lblSchiessen);
		lblSchiessen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblSchiessenPunkte = new GridBagConstraints();
		gbc_lblSchiessenPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblSchiessenPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblSchiessenPunkte.gridx = 3;
		gbc_lblSchiessenPunkte.gridy = 1;
		charakterWertePannel.add(lblSchiessenPunkte, gbc_lblSchiessenPunkte);
		lblSchiessenPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblInitiative = new JLabel("Initiative:");
		GridBagConstraints gbc_lblInitiative = new GridBagConstraints();
		gbc_lblInitiative.anchor = GridBagConstraints.WEST;
		gbc_lblInitiative.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitiative.gridx = 0;
		gbc_lblInitiative.gridy = 2;
		charakterWertePannel.add(lblInitiative, gbc_lblInitiative);
		lblInitiative.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblInitiativePunkte = new GridBagConstraints();
		gbc_lblInitiativePunkte.anchor = GridBagConstraints.WEST;
		gbc_lblInitiativePunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitiativePunkte.gridx = 1;
		gbc_lblInitiativePunkte.gridy = 2;
		charakterWertePannel.add(lblInitiativePunkte, gbc_lblInitiativePunkte);
		lblInitiativePunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		JLabel lblZaubern = new JLabel("Zaubern:");
		GridBagConstraints gbc_lblZaubern = new GridBagConstraints();
		gbc_lblZaubern.anchor = GridBagConstraints.WEST;
		gbc_lblZaubern.insets = new Insets(0, 0, 5, 5);
		gbc_lblZaubern.gridx = 2;
		gbc_lblZaubern.gridy = 2;
		charakterWertePannel.add(lblZaubern, gbc_lblZaubern);
		lblZaubern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblZaubernPunkte = new GridBagConstraints();
		gbc_lblZaubernPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblZaubernPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblZaubernPunkte.gridx = 3;
		gbc_lblZaubernPunkte.gridy = 2;
		charakterWertePannel.add(lblZaubernPunkte, gbc_lblZaubernPunkte);
		lblZaubernPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblLaufen = new JLabel("Laufen:");
		GridBagConstraints gbc_lblLaufen = new GridBagConstraints();
		gbc_lblLaufen.anchor = GridBagConstraints.WEST;
		gbc_lblLaufen.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaufen.gridx = 0;
		gbc_lblLaufen.gridy = 3;
		charakterWertePannel.add(lblLaufen, gbc_lblLaufen);
		lblLaufen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblLaufenPunkte = new GridBagConstraints();
		gbc_lblLaufenPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblLaufenPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaufenPunkte.gridx = 1;
		gbc_lblLaufenPunkte.gridy = 3;
		charakterWertePannel.add(lblLaufenPunkte, gbc_lblLaufenPunkte);
		lblLaufenPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblZielzauber = new JLabel("Zielzauber:");
		GridBagConstraints gbc_lblZielzauber = new GridBagConstraints();
		gbc_lblZielzauber.anchor = GridBagConstraints.WEST;
		gbc_lblZielzauber.insets = new Insets(0, 0, 5, 5);
		gbc_lblZielzauber.gridx = 2;
		gbc_lblZielzauber.gridy = 3;
		charakterWertePannel.add(lblZielzauber, gbc_lblZielzauber);
		lblZielzauber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		GridBagConstraints gbc_lblZielzauberPunkte = new GridBagConstraints();
		gbc_lblZielzauberPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_lblZielzauberPunkte.anchor = GridBagConstraints.WEST;
		gbc_lblZielzauberPunkte.gridx = 3;
		gbc_lblZielzauberPunkte.gridy = 3;
		charakterWertePannel.add(lblZielzauberPunkte, gbc_lblZielzauberPunkte);
		lblZielzauberPunkte.setFont(new Font("Tahoma", Font.BOLD, 14));		
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
			laufen = (int)aModelAgilitaet.getValue() / 2 + 1 + 1;//runden klären
			schlagen = (int)aModelKoerper.getValue() + (int)eModelStaerke.getValue() + 0;// WB
			schiessen = (int)aModelAgilitaet.getValue() + (int)eModelGeschick.getValue() + 0;// WB
			zaubern = (int)aModelGeist.getValue() + (int)eModelAura.getValue() - 0;// PA
			zielzauber = (int)aModelGeist.getValue() + (int)eModelGeschick.getValue() - 0; // PA
			
			lblLebenskraftPunkte.setText(Integer.toString(lebenskraft));
			lblAbwehrPunkte.setText(Integer.toString(abwehr));
			lblInitiativePunkte.setText(Integer.toString(initiative));
			lblLaufenPunkte.setText(Integer.toString(laufen));
			lblSchlagenPunkte.setText(Integer.toString(schlagen));
			lblSchiessenPunkte.setText(Integer.toString(schiessen));
			lblZaubernPunkte.setText(Integer.toString(zaubern));
			lblZielzauberPunkte.setText(Integer.toString(zielzauber));
		}
}
