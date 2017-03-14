import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KampfWerteFeld {
	private JLabel lblLebenskraftPunkte = new JLabel("0");
	private JLabel lblSchlagenPunkte = new JLabel("0");
	private JLabel lblAbwehrPunkte = new JLabel("0");
	private JLabel lblSchiessenPunkte = new JLabel("0");
	private JLabel lblInitiativePunkte = new JLabel("0");
	private JLabel lblZaubernPunkte = new JLabel("0");
	private JLabel lblLaufenPunkte = new JLabel("0");
	private JLabel lblZielzauberPunkte = new JLabel("0");
	
	
	public JLabel getLblLebenskraftPunkte() {
		return lblLebenskraftPunkte;
	}

	public JLabel getLblSchlagenPunkte() {
		return lblSchlagenPunkte;
	}

	public JLabel getLblAbwehrPunkte() {
		return lblAbwehrPunkte;
	}

	public JLabel getLblSchiessenPunkte() {
		return lblSchiessenPunkte;
	}

	public JLabel getLblInitiativePunkte() {
		return lblInitiativePunkte;
	}

	public JLabel getLblZaubernPunkte() {
		return lblZaubernPunkte;
	}

	public JLabel getLblLaufenPunkte() {
		return lblLaufenPunkte;
	}

	public JLabel getLblZielzauberPunkte() {
		return lblZielzauberPunkte;
	}

	
	public KampfWerteFeld(JPanel contentPane) {
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

}
