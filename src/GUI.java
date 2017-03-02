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

public class GUI extends JFrame {

	int attributePoints = 20;
	int qualitiesPoints = 8;

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

		JComboBox comboBoxProfession = new JComboBox();
		comboBoxProfession.addItem("Magier");
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
		lblKrper.setBounds(274, 49, 44, 34);
		contentPane.add(lblKrper);

		JLabel lblAgilitt = new JLabel("Agilit\u00E4t");
		lblAgilitt.setBounds(274, 96, 44, 34);
		contentPane.add(lblAgilitt);

		JLabel lblGeist = new JLabel("Geist");
		lblGeist.setBounds(274, 141, 44, 34);
		contentPane.add(lblGeist);

		SpinnerModel modelAgility = new SpinnerNumberModel(0, 0, 8, 1);
		SpinnerModel modelMind = new SpinnerNumberModel(0, 0, 8, 1);
		SpinnerModel modelBody = new SpinnerNumberModel(0, 0, 8, 1);

		JSpinner agilitySpinner = new JSpinner(modelAgility);
		agilitySpinner.setBounds(328, 103, 44, 20);
		contentPane.add(agilitySpinner);

		JSpinner mindSpinner = new JSpinner(modelMind);
		mindSpinner.setBounds(328, 148, 44, 20);
		contentPane.add(mindSpinner);

		JLabel lblAttributePoints = new JLabel("");
		lblAttributePoints.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAttributePoints.setBounds(388, 11, 44, 34);
		contentPane.add(lblAttributePoints);

		lblAttributePoints.setText(Integer.toString(attributePoints));

		JLabel lblQualitiesPoints = new JLabel("");
		lblQualitiesPoints.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblQualitiesPoints.setBounds(571, 11, 44, 34);
		contentPane.add(lblQualitiesPoints);

		lblQualitiesPoints.setText(Integer.toString(qualitiesPoints));

		JSpinner bodySpinner = new JSpinner(modelBody);
		bodySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				JSpinner source = (JSpinner) arg0.getSource();
				if (source.getVerifyInputWhenFocusTarget()) {
					
					if ((Integer) source.getPreviousValue() < (Integer) source
							.getValue()) {
						attributePoints--;
					} else if ((Integer) source.getPreviousValue() > (Integer) source
							.getValue()) {
						attributePoints++;
					}
				}
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
		lblStrke.setBounds(442, 49, 44, 34);
		contentPane.add(lblStrke);

		JLabel lblHrte = new JLabel("H\u00E4rte");
		lblHrte.setBounds(586, 49, 44, 34);
		contentPane.add(lblHrte);

		SpinnerModel modelStrength = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel modelHardness = new SpinnerNumberModel(0, 0, 4, 1);

		JSpinner strengthSpinner = new JSpinner(modelStrength);
		strengthSpinner.setBounds(496, 56, 44, 20);
		contentPane.add(strengthSpinner);

		JSpinner hardnessSpinner = new JSpinner(modelHardness);
		hardnessSpinner.setBounds(640, 56, 44, 20);
		contentPane.add(hardnessSpinner);

		JLabel lblBewegung = new JLabel("Bewegung");
		lblBewegung.setBounds(442, 96, 58, 34);
		contentPane.add(lblBewegung);

		JLabel lblGeschick = new JLabel("Geschick");
		lblGeschick.setBounds(586, 96, 44, 34);
		contentPane.add(lblGeschick);

		SpinnerModel modelMovement = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel modelDeftness = new SpinnerNumberModel(0, 0, 4, 1);

		JSpinner movementSpinner = new JSpinner(modelMovement);
		movementSpinner.setBounds(496, 103, 44, 20);
		contentPane.add(movementSpinner);

		JSpinner deftnessSpinner = new JSpinner(modelDeftness);
		deftnessSpinner.setBounds(640, 103, 44, 20);
		contentPane.add(deftnessSpinner);

		JLabel lblVerstand = new JLabel("Verstand");
		lblVerstand.setBounds(442, 141, 49, 34);
		contentPane.add(lblVerstand);

		JLabel lblAura = new JLabel("Aura");
		lblAura.setBounds(586, 141, 44, 34);
		contentPane.add(lblAura);

		SpinnerModel modelBrain = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel modelAura = new SpinnerNumberModel(0, 0, 4, 1);

		JSpinner brainSpinner = new JSpinner(modelBrain);
		brainSpinner.setBounds(496, 148, 44, 20);
		contentPane.add(brainSpinner);

		JSpinner auraSpinner = new JSpinner(modelAura);
		auraSpinner.setBounds(640, 148, 44, 20);
		contentPane.add(auraSpinner);

		JLabel lblPunkte = new JLabel("Punkte: ");
		lblPunkte.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblPunkte.setBounds(338, 11, 44, 34);
		contentPane.add(lblPunkte);

		JLabel label = new JLabel("Punkte: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 9));
		label.setBounds(532, 11, 44, 34);
		contentPane.add(label);
	}
}
