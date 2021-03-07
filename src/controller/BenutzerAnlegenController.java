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
	 * @param e the EPAController
	 */
	public BenutzerAnlegenController(EPAController e) {
    	this.ePAController = e ;
    }

    /**
	 * Diese Methode liegt einen neuen Arzt an
	 * @param Vorname Vorname des Arztes
	 * @param Nachname Nachname des Arztes
	 * @param fach Fachrichtung des Arztes
	 * @param num  ID des Arztes
	 * @param passwort passowrt des Arztes
	 * @param Tel Telefonnummmer des Arztes
 	 */
    public void arztAnlegen(String Vorname, String Nachname, String fach, String num, String passwort, String Tel) throws IOException {

    	Arzt arzt = new Arzt(Vorname, Nachname, fach, num, passwort, Tel); // create new instance arzt
		arzt.addToRevision(ePAController.getTime()+" Herzlich Willkommen");// add revision
		ePAController.getEPA().addArzttToList(arzt);                      // add arzt to list
    	ePAController.getIO().save();                                    // save

    }

    /**
	 *  Diese Methode liegt einen neuen Patient an
	 * @param versicherungsnummer versicherungsnummer des Patienten
	 * @param Vorname vorname Datum und Uhrzeit
	 * @param Nachname nachname des Patienten
	 * @param Address address des Patienten
	 * @param geschlecht is the patient female?
	 * @param Birth geburtstag des Patienten
	 * @param pass passwort des Patienten
	 * @param hausarztid hausarzt id to set for patient
	 */
    public void patientAnlegen(String versicherungsnummer, String Vorname, String Nachname, String Address, boolean geschlecht, String Birth, String pass,String hausarztid) throws IOException {

    	String sex = geschlecht ? "f" : "m";  // geschlecht is female ?
		Patient patient = new Patient(versicherungsnummer, Vorname, Nachname, Address, sex, Birth, pass) ;  // create new instance patient
		patient.addToRevision(ePAController.getTime()+" Herzlich Willkommen");// add revision
		if(!hausarztid.isEmpty()){patient.behandeldenArztAendern(ePAController.getEPA().getArzt(hausarztid));}  // hausarzt id not empty -> set hausarzt for patient
        ePAController.getEPA().addPatientToList(patient);  // add patient to list
		ePAController.getIO().save(); // save

    }
}
