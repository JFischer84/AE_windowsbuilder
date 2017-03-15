package gui;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Charakter;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DunGenGui extends JFrame {

	private JPanel contentPane;
	private JButton btnSpeichern;
	private CharakterWerte charakterWerte;
	

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
		setBounds(100, 100, 918, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(795, 607, 117, 29);
		contentPane.add(btnSpeichern);
		Kopfzeile kopfzeile = new Kopfzeile(contentPane);
		charakterWerte = new CharakterWerte(contentPane, btnSpeichern);
		KerndatenFeld kerndatenFeld = new KerndatenFeld(contentPane, charakterWerte);
		AusruestungsBoxen ausruestungsBoxen = new AusruestungsBoxen(contentPane);
		
		
		JLabel lblFehlerLabel = new JLabel("<html>Beim Speichern<br> ist ein fehler aufgetreten!</html>");
		lblFehlerLabel.setForeground(Color.RED);
		lblFehlerLabel.setBounds(795, 542, 117, 53);
		lblFehlerLabel.setVisible(false);
		contentPane.add(lblFehlerLabel);
		
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Charakter charakter;
				charakter = CharakterFactory.createCharakter(kerndatenFeld.getVolk(), kerndatenFeld.getCharakterKlasse());
				charakter = CharakterMapper.charakterWerteSetzen(charakter, charakterWerte, kerndatenFeld, kopfzeile);
				try {
					CharakterWriter.writeCharakter(charakter);
				} catch (IOException e1) {
					lblFehlerLabel.setVisible(true);
					e1.printStackTrace();
				}
			}
		});
	}
}
