import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		KerndatenFeld kerndatenFeld = new KerndatenFeld(contentPane);
		CharakterWerte charakterWerte = new CharakterWerte(contentPane);
		AusruestungsBoxen ausruestungsBoxen = new AusruestungsBoxen(contentPane);
	
	}		
}
