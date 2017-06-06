 package gui;
import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import model.Charakter;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JComboBox;

/**
 * 
 * Diese Klasse stellt den Root-Container für die GUI-Klassen dar.
 * Zusätzlich wird hier die Exception für das Speichern behandelt und 
 * der Speichern-Button verwaltet.
 *
 */
public class DunGenGui extends JFrame {

	private JPanel contentPane;
	private JPanel ladenPane;
	private JButton btnSpeichern;
	private CharakterWerte charakterWerte;
	private JTabbedPane tabbedPane;
	private DefaultListModel listModel;
	private JButton btnNewButton;
	private JButton btnCharakterLschen;
	

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
		setBounds(100, 100, 940, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ladenPane = new JPanel();
		ladenPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ladenPane.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 882, 620);
		tabbedPane.addTab("Erstellen", null, contentPane, null);
		setContentPane(tabbedPane);
				
		contentPane.setLayout(null);
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(795, 607, 117, 29);
		contentPane.add(btnSpeichern);
		Kopfzeile kopfzeile = new Kopfzeile(contentPane);
		charakterWerte = new CharakterWerte(contentPane, btnSpeichern);
		KerndatenFeld kerndatenFeld = new KerndatenFeld(contentPane, charakterWerte);
		AusruestungsFeld ausruestungsBoxen = new AusruestungsFeld(contentPane);
		
		
		JLabel lblFehlerLabel = new JLabel("<html>Beim Speichern<br> ist ein fehler aufgetreten!</html>");
		lblFehlerLabel.setForeground(Color.red);
		lblFehlerLabel.setBounds(801, 542, 118, 54);
		lblFehlerLabel.setVisible(false);
		contentPane.add(lblFehlerLabel);
		
		JLabel lblSpeichern = new JLabel("<html>Der Charakter wurde erfolgreich gespeichert!</html>");
		lblSpeichern.setForeground(Color.green);
		lblSpeichern.setBounds(795, 542, 120, 64);
		lblSpeichern.setVisible(false);
		contentPane.add(lblSpeichern);
		
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				if (lblFehlerLabel.isVisible()) {
					lblFehlerLabel.setVisible(false);
				}
				
				Charakter charakter;
				charakter = CharakterFactory.createCharakter(kerndatenFeld.getVolk(), kerndatenFeld.getCharakterKlasse());
				charakter = CharakterMapper.charakterWerteSetzen(charakter, charakterWerte, kerndatenFeld, kopfzeile);
				try {
					CharakterWriter.writeCharakter(charakter);
					lblSpeichern.setVisible(true);
				} catch (IOException e1) {
					lblFehlerLabel.setVisible(true);
					e1.printStackTrace();
					lblSpeichern.setVisible(false);
				}
			}
		});
		tabbedPane.addTab("Laden", null, ladenPane, null);
		listModel = new DefaultListModel();
		listModel.addElement("Test1");
		listModel.addElement("Test2");
		listModel.addElement("Test3");
		JList list = new JList(listModel);
		list.setBounds(10, 11, 102, 360);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		ladenPane.add(list);
		
		btnNewButton = new JButton("Charakter Laden");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(122, 11, 212, 33);
		ladenPane.add(btnNewButton);
		
		btnCharakterLschen = new JButton("Charakter L\u00F6schen");
		btnCharakterLschen.setBounds(122, 55, 212, 33);
		ladenPane.add(btnCharakterLschen);
		
	}
}
