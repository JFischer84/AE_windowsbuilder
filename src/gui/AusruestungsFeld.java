package gui;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Ausruestung;
import model.Waffe;


//diese Klasse ist noch WiP und stellt momentan keine Funktionalitaet.
public class AusruestungsFeld {
	
	List<Ausruestung> ausruestung = new ArrayList<Ausruestung>();

	public AusruestungsFeld(JPanel contentPane) {
		
		JTabbedPane tabbedPaneAusruestung = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAusruestung.setBounds(10, 399, 781, 253);
		
		contentPane.add(tabbedPaneAusruestung);
		
		JPanel waffenPanel = new JPanel();
		tabbedPaneAusruestung.addTab("Waffen", null, waffenPanel, null);
		waffenPanel.setLayout(null);
		
		JCheckBox chckbxAxt = new JCheckBox("Axt");
		chckbxAxt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Waffe axt = new Waffe(1, "", 6, chckbxAxt.getName());
				if (chckbxAxt.isSelected()) {
					ausruestung.add(axt);
				} else {
					ausruestung.remove(axt);
				}
			}
		});
		chckbxAxt.setBounds(6, 6, 128, 23);
		waffenPanel.add(chckbxAxt);
		
		JCheckBox chckbxArmbrustLeicht = new JCheckBox("Armbrust, leicht");
		chckbxArmbrustLeicht.setBounds(6, 41, 142, 23);
		waffenPanel.add(chckbxArmbrustLeicht);
		
		JCheckBox chckbxArmbrustSchwer = new JCheckBox("Armbrust, schwer");
		chckbxArmbrustSchwer.setBounds(6, 76, 162, 23);
		waffenPanel.add(chckbxArmbrustSchwer);
		
		JCheckBox chckbxBihaender = new JCheckBox("Bihänder");
		chckbxBihaender.setBounds(6, 111, 128, 23);
		waffenPanel.add(chckbxBihaender);
		
		JCheckBox chckbxBogenElfen = new JCheckBox("Bogen, Elfen-");
		chckbxBogenElfen.setBounds(6, 146, 128, 23);
		waffenPanel.add(chckbxBogenElfen);
		
		JCheckBox chckbxBogenKurz = new JCheckBox("Bogen, Kurz-");
		chckbxBogenKurz.setBounds(6, 178, 128, 23);
		waffenPanel.add(chckbxBogenKurz);
		
		JCheckBox chckbxBogenLang = new JCheckBox("Bogen, Lang-");
		chckbxBogenLang.setBounds(163, 6, 128, 23);
		waffenPanel.add(chckbxBogenLang);
		
		JCheckBox chckbxDolch = new JCheckBox("Dolch");
		chckbxDolch.setBounds(163, 41, 128, 23);
		waffenPanel.add(chckbxDolch);
		
		JCheckBox chckbxFlegel = new JCheckBox("Flegel");
		chckbxFlegel.setBounds(163, 76, 128, 23);
		waffenPanel.add(chckbxFlegel);
		
		JCheckBox chckbxHammer = new JCheckBox("Hammer");
		chckbxHammer.setBounds(163, 111, 128, 23);
		waffenPanel.add(chckbxHammer);
		
		JCheckBox chckbxHellebarde = new JCheckBox("Hellebarde");
		chckbxHellebarde.setBounds(163, 146, 128, 23);
		waffenPanel.add(chckbxHellebarde);
		
		JCheckBox chckbxKampfstab = new JCheckBox("Kampfstab");
		chckbxKampfstab.setBounds(163, 178, 128, 23);
		waffenPanel.add(chckbxKampfstab);
		
		JCheckBox chckbxKeule = new JCheckBox("Keule");
		chckbxKeule.setBounds(303, 6, 128, 23);
		waffenPanel.add(chckbxKeule);
		
		JCheckBox chckbxLanze = new JCheckBox("Lanze");
		chckbxLanze.setBounds(303, 41, 128, 23);
		waffenPanel.add(chckbxLanze);
		
		JCheckBox chckbxSchlachtbeil = new JCheckBox("Schlachtbeil");
		chckbxSchlachtbeil.setBounds(303, 76, 128, 23);
		waffenPanel.add(chckbxSchlachtbeil);
		
		JCheckBox chckbxSchlachtgeissel = new JCheckBox("Schlachtgeißel");
		chckbxSchlachtgeissel.setBounds(303, 111, 128, 23);
		waffenPanel.add(chckbxSchlachtgeissel);
		
		JCheckBox chckbxSchlagring = new JCheckBox("Schlagring");
		chckbxSchlagring.setBounds(303, 146, 128, 23);
		waffenPanel.add(chckbxSchlagring);
		
		JCheckBox chckbxSchleuder = new JCheckBox("Schleuder");
		chckbxSchleuder.setBounds(303, 178, 128, 23);
		waffenPanel.add(chckbxSchleuder);
		
		JCheckBox chckbxSchwertBreit = new JCheckBox("Schwert, Breit-");
		chckbxSchwertBreit.setBounds(443, 6, 128, 23);
		waffenPanel.add(chckbxSchwertBreit);
		
		JCheckBox chckbxSchwertKurz = new JCheckBox("Schwert, Kurz-");
		chckbxSchwertKurz.setBounds(443, 41, 128, 23);
		waffenPanel.add(chckbxSchwertKurz);
		
		JCheckBox chckbxSchwertLang = new JCheckBox("Schwert, Lang-");
		chckbxSchwertLang.setBounds(443, 76, 128, 23);
		waffenPanel.add(chckbxSchwertLang);
		
		JCheckBox chckbxSpeer = new JCheckBox("Speer");
		chckbxSpeer.setBounds(443, 111, 128, 23);
		waffenPanel.add(chckbxSpeer);
		
		JCheckBox chckbxStreithammer = new JCheckBox("Streithammer");
		chckbxStreithammer.setBounds(443, 178, 128, 23);
		waffenPanel.add(chckbxStreithammer);
		
		JCheckBox chckbxStreitkolben = new JCheckBox("Streitkolben");
		chckbxStreitkolben.setBounds(612, 6, 128, 23);
		waffenPanel.add(chckbxStreitkolben);
		
		JCheckBox chckbxWurfmesser = new JCheckBox("Wurfmesser");
		chckbxWurfmesser.setBounds(612, 41, 128, 23);
		waffenPanel.add(chckbxWurfmesser);
		
		JCheckBox chckbxZwergenaxt = new JCheckBox("Zwergenaxt");
		chckbxZwergenaxt.setBounds(612, 76, 128, 23);
		waffenPanel.add(chckbxZwergenaxt);
		
		JCheckBox chckbxStreitaxt = new JCheckBox("Streitaxt");
		chckbxStreitaxt.setBounds(443, 146, 128, 23);
		waffenPanel.add(chckbxStreitaxt);
		
		JPanel ruestungPanel = new JPanel();
		tabbedPaneAusruestung.addTab("Rüstungen", null, ruestungPanel, null);
		ruestungPanel.setLayout(null);
		
		JCheckBox chckbxKettenpanzer = new JCheckBox("Kettenpanzer");
		chckbxKettenpanzer.setBounds(6, 6, 128, 23);
		ruestungPanel.add(chckbxKettenpanzer);
		
		JCheckBox chckbxLederschienen = new JCheckBox("Lederschienen");
		chckbxLederschienen.setBounds(6, 41, 128, 23);
		ruestungPanel.add(chckbxLederschienen);
		
		JCheckBox chckbxLederpanzer = new JCheckBox("Lederpanzer");
		chckbxLederpanzer.setBounds(6, 76, 128, 23);
		ruestungPanel.add(chckbxLederpanzer);
		
		JCheckBox chckbxMetallhelm = new JCheckBox("Metallhelm");
		chckbxMetallhelm.setBounds(6, 111, 128, 23);
		ruestungPanel.add(chckbxMetallhelm);
		
		JCheckBox chckbxPlattenarmschienen = new JCheckBox("Plattenarmschienen");
		chckbxPlattenarmschienen.setBounds(6, 146, 163, 23);
		ruestungPanel.add(chckbxPlattenarmschienen);
		
		JCheckBox chckbxPlattenbeinschienen = new JCheckBox("Plattenbeinschienen");
		chckbxPlattenbeinschienen.setBounds(6, 178, 163, 23);
		ruestungPanel.add(chckbxPlattenbeinschienen);
		
		JCheckBox chckbxPlattenpanzer = new JCheckBox("Plattenpanzer");
		chckbxPlattenpanzer.setBounds(167, 6, 128, 23);
		ruestungPanel.add(chckbxPlattenpanzer);
		
		JCheckBox chckbxRobe = new JCheckBox("Robe");
		chckbxRobe.setBounds(167, 41, 128, 23);
		ruestungPanel.add(chckbxRobe);
		
		JCheckBox chckbxRoberunenbestickt = new JCheckBox("Robe (runenbestickt)");
		chckbxRoberunenbestickt.setBounds(167, 76, 163, 23);
		ruestungPanel.add(chckbxRoberunenbestickt);
		
		JCheckBox chckbxSchildHolz = new JCheckBox("Schild, Holz-");
		chckbxSchildHolz.setBounds(167, 111, 128, 23);
		ruestungPanel.add(chckbxSchildHolz);
		
		JCheckBox chckbxSchildMetall = new JCheckBox("Schild, Metall-");
		chckbxSchildMetall.setBounds(167, 146, 128, 23);
		ruestungPanel.add(chckbxSchildMetall);
		
		JCheckBox chckbxSchildTurm = new JCheckBox("Schild, Turm-");
		chckbxSchildTurm.setBounds(167, 178, 128, 23);
		ruestungPanel.add(chckbxSchildTurm);
		
		
		JLabel lblGoldmuenzen = new JLabel("Goldmünzen:");
		lblGoldmuenzen.setBounds(512, 387, 89, 16);
		contentPane.add(lblGoldmuenzen);
		
		JLabel lblGoldmuenzenUebrig = new JLabel("10");
		lblGoldmuenzenUebrig.setBounds(609, 387, 58, 16);
		contentPane.add(lblGoldmuenzenUebrig);	
	}

}
