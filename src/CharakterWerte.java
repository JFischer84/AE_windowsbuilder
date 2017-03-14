import javax.swing.JButton;
import javax.swing.JPanel;

public class CharakterWerte {

	private JButton btnSpeichern = new JButton("Speichern");
	private KampfWerteFeld kampfWerteFeld;
	private AttributsFeld attributsFeld;
	private EigenschaftsFeld eigenschaftsFeld;
	private int lebenskraft;
	private int abwehr;
	private int initiative;
	private double laufen;
	private int schlagen;
	private int schiessen;
	private int zaubern;
	private int zielzauber;
	

	public CharakterWerte(JPanel contentPane) {

		kampfWerteFeld = new KampfWerteFeld(contentPane);	
		attributsFeld = new AttributsFeld(contentPane, this, btnSpeichern);
		eigenschaftsFeld = new EigenschaftsFeld(contentPane, this, btnSpeichern);
		
	}

	//TODO
	public void berechneKampfwerte() {
		lebenskraft = (int)attributsFeld.getaModelKoerper().getValue() + (int)eigenschaftsFeld.geteModelHaerte().getValue() + 10;
		abwehr = (int)attributsFeld.getaModelKoerper().getValue() + (int)eigenschaftsFeld.geteModelHaerte().getValue() + 0;// PA
		initiative = (int)attributsFeld.getaModelAgilitaet().getValue() + (int)eigenschaftsFeld.geteModelBewegung().getValue();
		laufen = Double.valueOf(attributsFeld.getaModelAgilitaet().getValue().toString()) / 2 + 1;
		schlagen = (int)attributsFeld.getaModelKoerper().getValue() + (int)eigenschaftsFeld.geteModelStaerke().getValue() + 0;// WB
		schiessen = (int)attributsFeld.getaModelAgilitaet().getValue() + (int)eigenschaftsFeld.geteModelGeschick().getValue() + 0;// WB
		zaubern = (int)attributsFeld.getaModelGeist().getValue() + (int)eigenschaftsFeld.geteModelAura().getValue() - 0;// PA
		zielzauber = (int)attributsFeld.getaModelGeist().getValue() + (int)eigenschaftsFeld.geteModelGeschick().getValue() - 0; // PA
		
		kampfWerteFeld.getLblLebenskraftPunkte().setText(Integer.toString(lebenskraft));
		kampfWerteFeld.getLblAbwehrPunkte().setText(Integer.toString(abwehr));
		kampfWerteFeld.getLblInitiativePunkte().setText(Integer.toString(initiative));
		kampfWerteFeld.getLblLaufenPunkte().setText(Double.toString(laufen));
		kampfWerteFeld.getLblSchlagenPunkte().setText(Integer.toString(schlagen));
		kampfWerteFeld.getLblSchiessenPunkte().setText(Integer.toString(schiessen));
		kampfWerteFeld.getLblZaubernPunkte().setText(Integer.toString(zaubern));
		kampfWerteFeld.getLblZielzauberPunkte().setText(Integer.toString(zielzauber));
	}
	


}
