import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class Kopfzeile {
	
	public Kopfzeile(JPanel contentPane) {
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
		txtName.setBounds(18, 42, 138, 16);
		contentPane.add(txtName);
	}

}
