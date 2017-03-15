package gui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class Kopfzeile {
	
	private String geschlecht;
	private String name;
	private JTextPane txtName;
	
	public String getGeschlecht() {
		return geschlecht;
	}


	public String getName() {
		return name;
	}


	public JTextPane getTxtName() {
		return txtName;
	}


	public Kopfzeile(JPanel contentPane) {
		JRadioButton rdbtnMaennlich = new JRadioButton("Männlich");
		rdbtnMaennlich.setBounds(271, 22, 141, 23);
		contentPane.add(rdbtnMaennlich);
		rdbtnMaennlich.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				geschlecht = "Männlich";
				
			}
			
		});
		
		JRadioButton rdbtnWeiblich = new JRadioButton("Weiblich");
		rdbtnWeiblich.setBounds(271, 46, 141, 23);
		contentPane.add(rdbtnWeiblich);
		rdbtnWeiblich.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				geschlecht = "Weiblich";
				
			}
			
		});
		
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
		
		txtName = new JTextPane();
		txtName.setBounds(18, 42, 138, 16);
		contentPane.add(txtName);
	}

}
