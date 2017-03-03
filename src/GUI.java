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
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUI extends JFrame {

	int attributePoints = 20;
	int qualitiesPoints = 8;
	public static final int ATTRIBUTE_MAX = 20;
	public static final int QUALITIES_MAX = 8;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Derbe Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxRaceBonus = new JComboBox();
		comboBoxRaceBonus.setBounds(430, 225, 146, 20);
		contentPane.add(comboBoxRaceBonus);
		
		JComboBox comboBoxProfessionBonus = new JComboBox();
		comboBoxProfessionBonus.setBounds(430, 279, 146, 20);
		contentPane.add(comboBoxProfessionBonus);
		
		JComboBox comboBoxMageType = new JComboBox();
		comboBoxMageType.setBounds(10, 245, 146, 20);
		contentPane.add(comboBoxMageType);
		comboBoxMageType.addItem("Heiler");
		comboBoxMageType.addItem("Zauberer");
		comboBoxMageType.addItem("Schwarzmagier");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(414, 22, 18, 178);
		contentPane.add(separator);
		
		JLabel lblAttributePoints = new JLabel("");
		lblAttributePoints.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAttributePoints.setBounds(388, 11, 44, 34);
		contentPane.add(lblAttributePoints);

		JComboBox comboBoxProfession = new JComboBox();
		comboBoxProfession.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxProfessionBonus.removeAllItems();
				comboBoxMageType.setEnabled(false);
				if (comboBoxProfession.getSelectedItem() == "Zauberwirker") {
					comboBoxProfessionBonus.addItem("Verstand");
					comboBoxProfessionBonus.addItem("Aura");
					comboBoxMageType.setEnabled(true);
					
				} else if (comboBoxProfession.getSelectedItem() == "Krieger") {
					comboBoxProfessionBonus.addItem("Stärke");
					comboBoxProfessionBonus.addItem("Härte");
				} else if (comboBoxProfession.getSelectedItem() == "Späher") {
					comboBoxProfessionBonus.addItem("Bewegung");
					comboBoxProfessionBonus.addItem("Geschick");
				}
			}
		});
		comboBoxProfession.addItem("Zauberwirker");
		comboBoxProfession.addItem("Krieger");
		comboBoxProfession.addItem("Späher");
		comboBoxProfession.setBounds(10, 56, 146, 20);
		contentPane.add(comboBoxProfession);

		JLabel lblKlasse = new JLabel("Klasse");
		lblKlasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKlasse.setBounds(10, 11, 146, 34);
		contentPane.add(lblKlasse);

		JLabel lblVolk = new JLabel("Volk");
		lblVolk.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVolk.setBounds(10, 96, 146, 34);
		contentPane.add(lblVolk);

		JComboBox comboBoxRace = new JComboBox();
		comboBoxRace.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxRaceBonus.removeAllItems();
				if (comboBoxRace.getSelectedItem() == "Elf") {
					comboBoxRaceBonus.addItem("Bewegung");
					comboBoxRaceBonus.addItem("Geschick");
					comboBoxRaceBonus.addItem("Aura");
				} else if (comboBoxRace.getSelectedItem() == "Mensch") {
					comboBoxRaceBonus.addItem("Bewegung");
					comboBoxRaceBonus.addItem("Geschick");
					comboBoxRaceBonus.addItem("Aura");
					comboBoxRaceBonus.addItem("Stärke");
					comboBoxRaceBonus.addItem("Härte");
					comboBoxRaceBonus.addItem("Verstand");
				} else if (comboBoxRace.getSelectedItem() == "Zwerg") {
					comboBoxRaceBonus.addItem("Stärke");
					comboBoxRaceBonus.addItem("Härte");
					comboBoxRaceBonus.addItem("Geschick");
				}
			}
		});
		comboBoxRace.addItem("Elf");
		comboBoxRace.addItem("Mensch");
		comboBoxRace.addItem("Zwerg");
		comboBoxRace.setBounds(10, 141, 146, 20);
		contentPane.add(comboBoxRace);
		
		

		JLabel lblAttribut = new JLabel("Attribute");
		lblAttribut.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAttribut.setBounds(274, 11, 58, 34);
		contentPane.add(lblAttribut);

		JLabel lblKrper = new JLabel("K\u00F6rper");
		lblKrper.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKrper.setBounds(274, 49, 44, 34);
		contentPane.add(lblKrper);

		JLabel lblAgilitt = new JLabel("Agilit\u00E4t");
		lblAgilitt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAgilitt.setBounds(274, 96, 44, 34);
		contentPane.add(lblAgilitt);

		JLabel lblGeist = new JLabel("Geist");
		lblGeist.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeist.setBounds(274, 141, 44, 34);
		contentPane.add(lblGeist);

		SpinnerModel aModelAgility = new SpinnerNumberModel(0, 0, 8, 1);
		SpinnerModel aModelMind = new SpinnerNumberModel(0, 0, 8, 1);
		SpinnerModel aModelBody = new SpinnerNumberModel(0, 0, 8, 1);
		
		SpinnerModel qModelStrength = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel qModelHardness = new SpinnerNumberModel(0, 0, 4, 1);
		
		SpinnerModel qModelMovement = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel qModelDeftness = new SpinnerNumberModel(0, 0, 4, 1);
		
		SpinnerModel qModelBrain = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel qModelAura = new SpinnerNumberModel(0, 0, 4, 1);

		JSpinner agilitySpinner = new JSpinner(aModelAgility);
		agilitySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				attributePoints = ATTRIBUTE_MAX - ((int)aModelBody.getValue() + (int)aModelAgility.getValue() + (int)aModelMind.getValue());
				lblAttributePoints.setText(Integer.toString(attributePoints));
			}
		});
		agilitySpinner.setBounds(328, 103, 44, 20);
		contentPane.add(agilitySpinner);

		JSpinner mindSpinner = new JSpinner(aModelMind);
		mindSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				attributePoints = ATTRIBUTE_MAX - ((int)aModelBody.getValue() + (int)aModelAgility.getValue() + (int)aModelMind.getValue());
				lblAttributePoints.setText(Integer.toString(attributePoints));
				
			}
		});
		mindSpinner.setBounds(328, 148, 44, 20);
		contentPane.add(mindSpinner);

		

		lblAttributePoints.setText(Integer.toString(attributePoints));

		JLabel lblQualitiesPoints = new JLabel("");
		lblQualitiesPoints.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblQualitiesPoints.setBounds(584, 11, 44, 34);
		contentPane.add(lblQualitiesPoints);

		lblQualitiesPoints.setText(Integer.toString(qualitiesPoints));

		JSpinner bodySpinner = new JSpinner(aModelBody);
		bodySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
						
				attributePoints = ATTRIBUTE_MAX - ((int)aModelBody.getValue() + (int)aModelAgility.getValue() + (int)aModelMind.getValue());
				lblAttributePoints.setText(Integer.toString(attributePoints));
			}
		});
		bodySpinner.setBounds(328, 56, 44, 20);
		contentPane.add(bodySpinner);

		JLabel lblEigenschaften = new JLabel("Eigenschaften");
		lblEigenschaften.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEigenschaften.setBounds(442, 11, 84, 34);
		contentPane.add(lblEigenschaften);

		JLabel lblStrke = new JLabel("St\u00E4rke");
		lblStrke.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStrke.setBounds(468, 56, 44, 34);
		contentPane.add(lblStrke);

		JLabel lblHrte = new JLabel("H\u00E4rte");
		lblHrte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHrte.setBounds(619, 56, 44, 34);
		contentPane.add(lblHrte);

		

		JSpinner strengthSpinner = new JSpinner(qModelStrength);
		strengthSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				qualitiesPoints = QUALITIES_MAX - ((int)qModelStrength.getValue() + (int)qModelHardness.getValue() +
						(int)qModelAura.getValue() + (int)qModelBrain.getValue() + (int)qModelDeftness.getValue() + (int)qModelMovement.getValue());
				lblQualitiesPoints.setText(Integer.toString(qualitiesPoints));
			}
		});
		strengthSpinner.setBounds(532, 63, 44, 20);
		contentPane.add(strengthSpinner);

		JSpinner hardnessSpinner = new JSpinner(qModelHardness);
		hardnessSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				qualitiesPoints = QUALITIES_MAX - ((int)qModelStrength.getValue() + (int)qModelHardness.getValue() +
						(int)qModelAura.getValue() + (int)qModelBrain.getValue() + (int)qModelDeftness.getValue() + (int)qModelMovement.getValue());
				lblQualitiesPoints.setText(Integer.toString(qualitiesPoints));
			}
		});
		hardnessSpinner.setBounds(673, 63, 44, 20);
		contentPane.add(hardnessSpinner);

		JLabel lblBewegung = new JLabel("Bewegung");
		lblBewegung.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBewegung.setBounds(468, 96, 58, 34);
		contentPane.add(lblBewegung);

		JLabel lblGeschick = new JLabel("Geschick");
		lblGeschick.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeschick.setBounds(619, 96, 44, 34);
		contentPane.add(lblGeschick);


		JSpinner movementSpinner = new JSpinner(qModelMovement);
		movementSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				qualitiesPoints = QUALITIES_MAX - ((int)qModelStrength.getValue() + (int)qModelHardness.getValue() +
						(int)qModelAura.getValue() + (int)qModelBrain.getValue() + (int)qModelDeftness.getValue() + (int)qModelMovement.getValue());
				lblQualitiesPoints.setText(Integer.toString(qualitiesPoints));
			}
		});
		movementSpinner.setBounds(532, 103, 44, 20);
		contentPane.add(movementSpinner);

		JSpinner deftnessSpinner = new JSpinner(qModelDeftness);
		deftnessSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				qualitiesPoints = QUALITIES_MAX - ((int)qModelStrength.getValue() + (int)qModelHardness.getValue() +
						(int)qModelAura.getValue() + (int)qModelBrain.getValue() + (int)qModelDeftness.getValue() + (int)qModelMovement.getValue());
				lblQualitiesPoints.setText(Integer.toString(qualitiesPoints));
			}
		});
		deftnessSpinner.setBounds(673, 103, 44, 20);
		contentPane.add(deftnessSpinner);

		JLabel lblVerstand = new JLabel("Verstand");
		lblVerstand.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVerstand.setBounds(468, 134, 49, 34);
		contentPane.add(lblVerstand);

		JLabel lblAura = new JLabel("Aura");
		lblAura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAura.setBounds(619, 134, 44, 34);
		contentPane.add(lblAura);

		JSpinner brainSpinner = new JSpinner(qModelBrain);
		brainSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				qualitiesPoints = QUALITIES_MAX - ((int)qModelStrength.getValue() + (int)qModelHardness.getValue() +
						(int)qModelAura.getValue() + (int)qModelBrain.getValue() + (int)qModelDeftness.getValue() + (int)qModelMovement.getValue());
				lblQualitiesPoints.setText(Integer.toString(qualitiesPoints));
			}
		});
		brainSpinner.setBounds(532, 141, 44, 20);
		contentPane.add(brainSpinner);

		JSpinner auraSpinner = new JSpinner(qModelAura);
		auraSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
			}
		});
		auraSpinner.setBounds(673, 141, 44, 20);
		contentPane.add(auraSpinner);

		JLabel lblPunkte = new JLabel("Punkte: ");
		lblPunkte.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblPunkte.setBounds(338, 11, 44, 34);
		contentPane.add(lblPunkte);

		JLabel label = new JLabel("Punkte: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 9));
		label.setBounds(532, 11, 44, 34);
		contentPane.add(label);
		
		
		
		JLabel lblVolksbonus = new JLabel("Volksbonus");
		lblVolksbonus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVolksbonus.setBounds(323, 218, 76, 34);
		contentPane.add(lblVolksbonus);
		
		JLabel lblKlassenbonus = new JLabel("Klassenbonus");
		lblKlassenbonus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKlassenbonus.setBounds(323, 272, 97, 34);
		contentPane.add(lblKlassenbonus);
		
		JLabel lblZaubererTyp = new JLabel("Zauberer Typ");
		lblZaubererTyp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZaubererTyp.setBounds(10, 200, 146, 34);
		contentPane.add(lblZaubererTyp);
		
	
		
		
	}
}
