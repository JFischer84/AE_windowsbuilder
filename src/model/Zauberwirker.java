package model;

public class Zauberwirker implements CharakterKlasse {
	
	private String klassenName = "Zauberwirker";
	private String zauberWirkerTyp;
	private String startZauber;

	public String getZauberWirkerTyp() {
		return zauberWirkerTyp;
	}

	public void setZauberWirkerTyp(String zaubererTyp) {
		this.zauberWirkerTyp = zaubererTyp;
	}

	public String getStartZauber() {
		return startZauber;
	}

	public void setStartZauber(String startZauber) {
		this.startZauber = startZauber;
	}

	@Override
	public String getKlassenName() {
		return klassenName;
	}

}
