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
	 * @param epaController the EPAController
	 */
	public BenutzerAnlegenController(EPAController epaController) {
    	this.ePAController = epaController ;
    }

    /**
	 * Diese Methode liegt einen neuen Arzt an
	 * @param vorname vorname des Arztes
	 * @param nachname nachname des Arztes
	 * @param fach Fachrichtung des Arztes
	 * @param num  ID des Arztes
	 * @param passwort passowrt des Arztes
	 * @param tel Telefonnummmer des Arztes
 	 */
    public void arztAnlegen(String vorname, String nachname, String fach, String num, String passwort, String tel) throws IOException {

    	Arzt arzt = new Arzt(vorname, nachname, fach, num, passwort, tel); // create new instance arzt
		arzt.addToRevision(ePAController.getTime()+" Herzlich Willkommen");// add revision
		ePAController.getEPA().addArzttToList(arzt);                      // add arzt to list
    	ePAController.getIO().save();                                    // save

    }

    /**
	 *  Diese Methode liegt einen neuen Patient an
	 * @param versicherungsnummer versicherungsnummer des Patienten
	 * @param vorname vorname Datum und Uhrzeit
	 * @param nachname nachname des Patienten
	 * @param address address des Patienten
	 * @param geschlecht is the patient female?
	 * @param birth geburtstag des Patienten
	 * @param pass passwort des Patienten
	 * @param hausarztid hausarzt id to set for patient
	 */
    public void patientAnlegen(String versicherungsnummer, String vorname, String nachname, String address, boolean geschlecht, String birth, String pass, String hausarztid) throws IOException {

    	String sex = geschlecht ? "f" : "m";  // geschlecht is female ?
		Patient patient = new Patient(versicherungsnummer, vorname, nachname, address, sex, birth, pass) ;  // create new instance patient
		patient.addToRevision(ePAController.getTime()+" Herzlich Willkommen");// add revision
		if(!hausarztid.isEmpty()){patient.behandeldenArztAendern(ePAController.getEPA().getArzt(hausarztid));}  // hausarzt id not empty -> set hausarzt for patient
        ePAController.getEPA().addPatientToList(patient);  // add patient to list
		ePAController.getIO().save(); // save

    }
}
