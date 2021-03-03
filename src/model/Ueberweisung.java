package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ueberweisung {

	private String patientnummer;
	private String neuarztnummer;
	private String altArztnummer;

	private ArrayList<Untersuchungsbericht> untersuchungsbericht;

	private String auftrag;

	private String date;
	private boolean datenStimmZu=false;

	public Ueberweisung(String altArzt, String patient, String neuArzt, ArrayList<Untersuchungsbericht> untersuchungsList, String Auftrag, String date) {
        patientnummer=patient;
        neuarztnummer=neuArzt;
        altArztnummer=altArzt;
        this.untersuchungsbericht=untersuchungsList;
        this.auftrag=Auftrag;
        this.date=date;
	}

	public String getNeuarztnummer() {
		return neuarztnummer;
	}

	public String getAltArztnummer() {
		return altArztnummer;
	}

	public String getAuftrag() {
		return auftrag;
	}

	public String getDate() {
		return date;
	}

	public boolean isDatenStimmZu() {
		return datenStimmZu;
	}
	public void setDatenStimmZu(boolean b){datenStimmZu=b;}

	public String getPatientnummer() {
		return patientnummer;
	}

	public ArrayList<Untersuchungsbericht> getUntersuchungsbericht() {
		return untersuchungsbericht;
	}

	public void setUntersuchungsbericht(ArrayList<Untersuchungsbericht> untersuchungsbericht) {
		this.untersuchungsbericht = untersuchungsbericht;
	}
}
