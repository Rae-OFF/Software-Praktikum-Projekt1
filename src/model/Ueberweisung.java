package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Ueberweisung.
 */
public class Ueberweisung {

	private String patientnummer;
	private String neuarztnummer;
	private String altArztnummer;

	private ArrayList<Untersuchungsbericht> untersuchungsbericht;

	private String auftrag;

	private String date;
	private boolean datenStimmZu=false;

	/**
	 * Instantiates a new Ueberweisung.
	 *
	 * @param altArzt           the alt arzt
	 * @param patient           the patient
	 * @param neuArzt           the neu arzt
	 * @param untersuchungsList the untersuchungs list
	 * @param Auftrag           the auftrag
	 * @param date              the date
	 */
	public Ueberweisung(String altArzt, String patient, String neuArzt, ArrayList<Untersuchungsbericht> untersuchungsList, String Auftrag, String date) {
        patientnummer=patient;
        neuarztnummer=neuArzt;
        altArztnummer=altArzt;
        this.untersuchungsbericht=untersuchungsList;
        this.auftrag=Auftrag;
        this.date=date;
	}

	/**
	 * Gets neuarztnummer.
	 *
	 * @return the neuarztnummer
	 */
	public String getNeuarztnummer() {
		return neuarztnummer;
	}

	/**
	 * Gets alt arztnummer.
	 *
	 * @return the alt arztnummer
	 */
	public String getAltArztnummer() {
		return altArztnummer;
	}

	/**
	 * Gets auftrag.
	 *
	 * @return the auftrag
	 */
	public String getAuftrag() {
		return auftrag;
	}

	/**
	 * Gets date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Is daten stimm zu boolean.
	 *
	 * @return the boolean
	 */
	public boolean isDatenStimmZu() {
		return datenStimmZu;
	}

	/**
	 * Set daten stimm zu.
	 *
	 * @param b the b
	 */
	public void setDatenStimmZu(boolean b){datenStimmZu=b;}

	/**
	 * Gets patientnummer.
	 *
	 * @return the patientnummer
	 */
	public String getPatientnummer() {
		return patientnummer;
	}

	/**
	 * Gets untersuchungsbericht.
	 *
	 * @return the untersuchungsbericht
	 */
	public ArrayList<Untersuchungsbericht> getUntersuchungsbericht() {
		return untersuchungsbericht;
	}

	/**
	 * Sets untersuchungsbericht.
	 *
	 * @param untersuchungsbericht the untersuchungsbericht
	 */
	public void setUntersuchungsbericht(ArrayList<Untersuchungsbericht> untersuchungsbericht) {
		this.untersuchungsbericht = untersuchungsbericht;
	}
}
