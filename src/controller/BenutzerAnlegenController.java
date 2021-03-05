package controller;

import model.Arzt;
import model.EPA;
import model.Patient;

import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
/**
 * einen neuen Benutzer anlegen der , Patient oder Arzt sein kann
 */
public class BenutzerAnlegenController {

	/**
	 * 
	 */
    private EPAController ePAController;

	/**
	 * Instantiates a new Benutzer anlegen controller.
	 *
	 * @param e the e
	 */
	public BenutzerAnlegenController(EPAController e) {
    	this.ePAController = e ;
    }

    /**
	 * Diese Methode liegt einen neuen Arzt an
	 * @param Vorname des Arztes
	 * @param Nachname des Arztes
	 * @param fach  des Arztes
	 * @param num des Arztes
	 * @param passwort des Arztes
	 * @param Tel des Arztes
 	 */
    public void arztAnlegen(String Vorname, String Nachname, String fach, String num, String passwort, String Tel) throws IOException {
    	Arzt arzt = new Arzt(Vorname, Nachname, fach, num, passwort, Tel);
    	ePAController.getEPA().addArzttToList(arzt);
    	ePAController.getIO().save();
    }

    /**
	 *  Diese Methode liegt einen neuen Patient an
	 * @param versicherungsnummer des Patienten
	 * @param Vorname Datum und Uhrzeit
	 * @param Nachname des Patienten
	 * @param Address  des Patienten
	 * @param
	 * @param Birth des Patienten
	 * @param pass des Patienten
	 */
    public void patientAnlegen(String versicherungsnummer, String Vorname, String Nachname, String Address, boolean geschlecht, String Birth, String pass,String hausarztid) throws IOException {
    	//neuen Patient anlegen
		String sex = geschlecht ? "f" : "m";
		Patient patient = new Patient(versicherungsnummer, Vorname, Nachname, Address, sex, Birth, pass) ;
		if(!hausarztid.isEmpty()&&ePAController.getEPA().checkNumArzt(hausarztid)){patient.behandeldenArztAendern(ePAController.getEPA().getArzt(hausarztid));}
        ePAController.getEPA().addPatientToList(patient);
		EPA epa = ePAController.getEPA();
		ePAController.getIO().save();
    }
}
