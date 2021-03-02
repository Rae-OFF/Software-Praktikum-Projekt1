package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ueberweisung {

	private String patientnummer;

	private String neuarztnummer;
	private String altArztnummer;

	private ArrayList<Untersuchungsbericht> untersuchungsbericht;

	private String Auftrag;

	private String date;

	public Ueberweisung(String altArzt, String patient, String arzt, ArrayList<Untersuchungsbericht> untersuchungsList, String Auftrag, String date) {
        patientnummer=patient;
        neuarztnummer=arzt;
        altArztnummer=altArzt;
        this.untersuchungsbericht=untersuchungsList;
        this.Auftrag=Auftrag;
        this.date=date;
	}

	public String getNeuarztnummer() {
		return neuarztnummer;
	}

	public String getAltArztnummer() {
		return altArztnummer;
	}

	public String getAuftrag() {
		return Auftrag;
	}

	public String getDate() {
		return date;
	}

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
