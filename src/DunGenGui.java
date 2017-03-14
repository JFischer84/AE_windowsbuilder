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
import java.beans.PropertyChangeListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Choice;
import javax.swing.JCheckBox;

public class DunGenGui extends JFrame {

	private JPanel contentPane;
	
	

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
		Kopfzeile kopfzeile = new Kopfzeile(contentPane);
		Kerndaten kerndaten = new Kerndaten(contentPane);
		Kampfwerte kampfwerte = new Kampfwerte(contentPane);		
		AusruestungsBoxen ausruestungsBoxen = new AusruestungsBoxen(contentPane);
	
	}		
}
