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


public class GUI extends JFrame {

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
		lblAttribut.setBounds(274, 11, 146, 34);
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
		
		SpinnerModel model = new SpinnerNumberModel(0, 0, 8, 1);
		SpinnerModel model2 = new SpinnerNumberModel(0, 0, 8, 1);
		SpinnerModel model3 = new SpinnerNumberModel(0, 0, 8, 1);
		SpinnerModel model4 = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel model5 = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel model6 = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel model7 = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel model8 = new SpinnerNumberModel(0, 0, 4, 1);
		SpinnerModel model9 = new SpinnerNumberModel(0, 0, 4, 1);
		
		JSpinner agilitySpinner = new JSpinner(model);
		agilitySpinner.setBounds(328, 103, 44, 20);
		contentPane.add(agilitySpinner);
		
		JSpinner mindSpinner = new JSpinner(model2);
		mindSpinner.setBounds(328, 148, 44, 20);
		contentPane.add(mindSpinner);
		
		JSpinner bodySpinner = new JSpinner(model3);
		bodySpinner.setBounds(328, 56, 44, 20);
		contentPane.add(bodySpinner);
		
		JLabel lblEigenschaften = new JLabel("Eigenschaften");
		lblEigenschaften.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEigenschaften.setBounds(442, 11, 146, 34);
		contentPane.add(lblEigenschaften);
		
		JLabel lblStrke = new JLabel("St\u00E4rke");
		lblStrke.setBounds(442, 49, 44, 34);
		contentPane.add(lblStrke);
		
		JLabel lblHrte = new JLabel("H\u00E4rte");
		lblHrte.setBounds(586, 49, 44, 34);
		contentPane.add(lblHrte);
		
		JSpinner strengthSpinner = new JSpinner(model4);
		strengthSpinner.setBounds(496, 56, 44, 20);
		contentPane.add(strengthSpinner);
		
		JSpinner hardnessSpinner = new JSpinner(model5);
		hardnessSpinner.setBounds(640, 56, 44, 20);
		contentPane.add(hardnessSpinner);
		
		JLabel lblBewegung = new JLabel("Bewegung");
		lblBewegung.setBounds(442, 96, 58, 34);
		contentPane.add(lblBewegung);
		
		JLabel lblGeschick = new JLabel("Geschick");
		lblGeschick.setBounds(586, 96, 44, 34);
		contentPane.add(lblGeschick);
		
		JSpinner movementSpinner = new JSpinner(model6);
		movementSpinner.setBounds(496, 103, 44, 20);
		contentPane.add(movementSpinner);
		
		JSpinner deftnessSpinner = new JSpinner(model7);
		deftnessSpinner.setBounds(640, 103, 44, 20);
		contentPane.add(deftnessSpinner);
		
		JLabel lblVerstand = new JLabel("Verstand");
		lblVerstand.setBounds(442, 141, 49, 34);
		contentPane.add(lblVerstand);
		
		JLabel lblAura = new JLabel("Aura");
		lblAura.setBounds(586, 141, 44, 34);
		contentPane.add(lblAura);
		
		JSpinner brainSpinner = new JSpinner(model8);
		brainSpinner.setBounds(496, 148, 44, 20);
		contentPane.add(brainSpinner);
		
		JSpinner auraSpinner = new JSpinner(model9);
		auraSpinner.setBounds(640, 148, 44, 20);
		contentPane.add(auraSpinner);
	}
}
